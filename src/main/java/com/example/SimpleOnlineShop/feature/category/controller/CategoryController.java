package com.example.SimpleOnlineShop.feature.category.controller;

import com.example.SimpleOnlineShop.feature.category.model.CategoryModel;
import com.example.SimpleOnlineShop.feature.category.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.SimpleOnlineShop.feature.user.role.UserRole.UserRoleValues.ROLE_ADMIN;

@RestController
@AllArgsConstructor
@RequestMapping("categories")
public class CategoryController {

    final private CategoryService categoryService;

    @GetMapping()
    public List<CategoryModel> getAll() {
        return categoryService.getAll();
    }

    @Secured(ROLE_ADMIN)
    @PostMapping
    public CategoryModel add(@RequestBody CategoryModel categoryModelFromForm) {
        return categoryService.addCategory(categoryModelFromForm);
    }

    @DeleteMapping("{categoryId}")
    @Secured(ROLE_ADMIN)
    public void delete(@PathVariable Long categoryId) {
        categoryService.delete(categoryId);
    }


}
