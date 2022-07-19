package com.example.SimpleOnlineShop.feature.product.repository;

import com.example.SimpleOnlineShop.feature.product.model.ProductModel;
import com.example.SimpleOnlineShop.feature.user.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findBySeller(UserModel seller);

    List<ProductModel> findByOwner(UserModel loggedUser);

    Optional<ProductModel> findBySellerAndId(UserModel seller, Long id);
}
