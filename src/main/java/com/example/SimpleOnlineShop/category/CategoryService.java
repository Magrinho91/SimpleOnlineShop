package com.example.SimpleOnlineShop.category;

import com.example.SimpleOnlineShop.user.UserModel;
import com.example.SimpleOnlineShop.user.UserRole;
import com.example.SimpleOnlineShop.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    @Autowired
    private final UserService userService;
    @Autowired
    private final CategoryRepository categoryRepository;


    public List<CategoryModel> getAll() {
        return categoryRepository.findAll();
    }

    public CategoryModel addCategory(CategoryModel categoryModelFromForm) {
        UserModel loggedUser = userService.getLoggedAccount();

        CategoryModel categoryModelToAdd = CategoryModel.builder()
                .name(categoryModelFromForm.getName())
                .build();
        return categoryRepository.save(categoryModelToAdd);
//        if (loggedUser.getRole().value.equals(UserRole.UserRoleValues.User_ADMIN)) {
//
//        } else {
//            throw new RoleException("Your role is not appropriate");
//        }
    }

    public void delete(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
