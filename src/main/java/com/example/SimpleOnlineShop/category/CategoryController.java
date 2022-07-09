package com.example.SimpleOnlineShop.category;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.SimpleOnlineShop.user.UserRole.UserRoleValues.ROLE_ADMIN;

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
