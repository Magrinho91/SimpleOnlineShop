package com.example.SimpleOnlineShop.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductModelDto {

    private Long id;
    private String name;
    private String categoryName;
    private Double price;

    public static ProductModelDto of(ProductModel productModel) {
        return new ProductModelDto(
                productModel.getId(),
                productModel.getName(),
                productModel.getCategoryName(),
                productModel.getPrice()
        );
    }

    public static List<ProductModelDto> ofList(List<ProductModel> productModels) {
        List<ProductModelDto> productModelList = new ArrayList<>();

        for (ProductModel productModel : productModels) {
            productModelList.add(ProductModelDto.of(productModel));
        }

        return productModelList;
    }
}
