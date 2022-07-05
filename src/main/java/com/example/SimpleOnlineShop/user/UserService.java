package com.example.SimpleOnlineShop.user;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
        return new User(
                userModel.getLogin(),
                userModel.getPassword(),
                userModel.isEnabled(),
                userModel.isAccountNonExpired(),
                userModel.isCredentialsNonExpired(),
                userModel.isAccountNonLocked(),
                userModel.getAuthorities()
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
