package com.example.SimpleOnlineShop.product;

import com.example.SimpleOnlineShop.user.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


public interface ProductRepository extends JpaRepository<ProductModel, Long> {

    List<ProductModel> findBySeller(UserModel seller);

    List<ProductModel> findByOwner(UserModel loggedUser);

    Optional<ProductModel> findBySellerAndId(UserModel seller, Long id);
}
