package com.example.SimpleOnlineShop.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
