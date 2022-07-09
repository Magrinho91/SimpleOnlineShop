package com.example.SimpleOnlineShop.product;

import com.example.SimpleOnlineShop.category.CategoryModel;
import com.example.SimpleOnlineShop.user.UserModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {
    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

    @Column
    private String categoryName;

    @Column
    private Double price;

    @ManyToOne
    private UserModel seller;

    @OneToOne
    private UserModel owner;

    @Column
    @Builder.Default
    private Boolean isBought = false;




}
