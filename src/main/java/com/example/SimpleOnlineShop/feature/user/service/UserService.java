package com.example.SimpleOnlineShop.feature.user.service;

import com.example.SimpleOnlineShop.feature.user.dto.UserModelDto;
import com.example.SimpleOnlineShop.feature.user.model.UserModel;
import com.example.SimpleOnlineShop.feature.user.repository.UserRepository;
import com.example.SimpleOnlineShop.feature.user.role.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;
    private final PasswordEncoder encoder;


    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        final UserModel userModel =
                userRepository.findByLogin(login).orElseThrow(() -> new UsernameNotFoundException(login));
        final List<GrantedAuthority> permissions = List.of(new SimpleGrantedAuthority(userModel.getRole().value));

        return new User(
                userModel.getLogin(),
                userModel.getPassword(),
                userModel.isEnabled(),
                userModel.isAccountNonExpired(),
                userModel.isCredentialsNonExpired(),
                userModel.isAccountNonLocked(),
                permissions
        );
    }


    public List<UserModel> getUsers() {
        return userRepository.findAll();
    }

    public void registerUser(UserModelDto userModelDto) {

        UserModel userToRegister = UserModel.builder()
                .firstName(userModelDto.getFirstName())
                .lastName(userModelDto.getLastName())
                .login(userModelDto.getLogin())
                .password(encoder.encode(userModelDto.getPassword()))
                .role(UserRole.fromValue(userModelDto.getRole()))
                .build();

        userRepository.save(userToRegister);
    }

    public UserModel getLoggedAccount() {
        final String login = getUserPrincipal().getUsername();
        return userRepository.findByLogin(login).orElseThrow(() -> new RuntimeException("User was not found by login."));
    }

    private User getUserPrincipal() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (User) authentication.getPrincipal();
    }
}
