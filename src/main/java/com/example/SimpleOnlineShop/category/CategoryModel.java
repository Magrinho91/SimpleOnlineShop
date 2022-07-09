package com.example.SimpleOnlineShop.category;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoryModel {

    @Id
    @GeneratedValue
    private Long id;

    @Column
    private String name;

}
