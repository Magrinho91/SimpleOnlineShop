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

    private final UserService userService;
    private final CategoryRepository categoryRepository;


    public List<CategoryModel> getAll() {
        return categoryRepository.findAll();
    }

    public CategoryModel addCategory(CategoryModel categoryModelFromForm) {

        CategoryModel categoryModelToAdd = CategoryModel.builder()
                .name(categoryModelFromForm.getName())
                .build();
        return categoryRepository.save(categoryModelToAdd);
    }

    public void delete(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
