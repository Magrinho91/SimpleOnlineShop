package com.example.SimpleOnlineShop.product;

import com.example.SimpleOnlineShop.category.CategoryModel;
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

    @OneToOne
    private CategoryModel category;

    @Column
    private Double price;



}
