package com.example.SimpleOnlineShop.category;

import com.example.SimpleOnlineShop.user.UserRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("categories")
public class CategoryController {

    @Autowired
    final private CategoryService categoryService;

    @GetMapping()
    public List<CategoryModel> getAll() {
        return categoryService.getAll();
    }

    @PostMapping
    @Secured(UserRole.UserRoleValues.User_ADMIN)
    public CategoryModel add(@RequestBody CategoryModel categoryModelFromForm) {
        return categoryService.addCategory(categoryModelFromForm);
    }

    @DeleteMapping("{categoryId}")
    @Secured(UserRole.UserRoleValues.User_ADMIN)
    public void delete(@PathVariable Long categoryId) {
        categoryService.delete(categoryId);
    }


}
