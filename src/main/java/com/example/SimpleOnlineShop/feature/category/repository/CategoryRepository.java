package com.example.SimpleOnlineShop.feature.category.repository;

import com.example.SimpleOnlineShop.feature.category.model.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
