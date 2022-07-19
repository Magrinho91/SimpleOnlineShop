package com.example.SimpleOnlineShop.feature.category.service;

import com.example.SimpleOnlineShop.feature.category.model.CategoryModel;
import com.example.SimpleOnlineShop.feature.category.repository.CategoryRepository;
import com.example.SimpleOnlineShop.feature.user.service.UserService;
import lombok.RequiredArgsConstructor;
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
