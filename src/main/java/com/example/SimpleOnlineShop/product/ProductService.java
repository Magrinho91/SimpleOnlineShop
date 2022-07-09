package com.example.SimpleOnlineShop.product;

import com.example.SimpleOnlineShop.category.CategoryModel;
import com.example.SimpleOnlineShop.category.CategoryRepository;
import com.example.SimpleOnlineShop.user.UserModel;
import com.example.SimpleOnlineShop.user.UserService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.memory.UserAttribute;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private ProductRepository productRepository;
    private UserService userService;
    private CategoryRepository categoryRepository;

    public List<ProductModel> getAllProducts() {
        return productRepository.findAll();
    }


    public List<ProductModelDto> getAllProductsForSeller() {
        UserModel loggedUser = userService.getLoggedAccount();
        return ProductModelDto.ofList(productRepository.findBySeller(loggedUser));
    }

    public List<ProductModelDto> getAllProductsForOwner() {
        UserModel loggedUser = userService.getLoggedAccount();

        return ProductModelDto.ofList(productRepository.findByOwner(loggedUser));
    }

    public ProductModelDto addProduct(ProductModelDto productModelDto) {
        UserModel loggedUser = userService.getLoggedAccount();

        List<CategoryModel> categoryModels = categoryRepository.findAll();

        List<String> categoryStreamNames = categoryModels.stream()
                .map(category -> category.getName())
                .collect(Collectors.toList());

        if (categoryStreamNames.contains(productModelDto.getCategoryName())) {
            ProductModel productToCreate = ProductModel.builder()
                    .name(productModelDto.getName())
                    .price(productModelDto.getPrice())
                    .seller(loggedUser)
                    .categoryName(productModelDto.getCategoryName())
                    .build();
            return ProductModelDto.of(productRepository.save(productToCreate));
        } else {
            throw new RuntimeException("Category is now in the list");
        }
    }

    public ProductModelDto updateProduct(ProductModelDto productModel) {
        UserModel loggedUser = userService.getLoggedAccount();

        ProductModel updatedProduct = productRepository.findBySellerAndId(loggedUser, productModel.getId()).orElseThrow();
        updatedProduct.setCategoryName(productModel.getCategoryName());
        updatedProduct.setName(productModel.getName());
        updatedProduct.setPrice(productModel.getPrice());
        productRepository.save(updatedProduct);

        return ProductModelDto.of(updatedProduct);
    }


    public void deleteProduct(Long productId) {
        UserModel loggedUser = userService.getLoggedAccount();

        ProductModel productToDelete = productRepository.findBySellerAndId(loggedUser, productId).orElseThrow();

        productRepository.delete(productToDelete);
    }

    public ProductModelDto buyProduct(ProductModelDto productToBuy) {
        UserModel loggedUser = userService.getLoggedAccount();

        ProductModel productBought = productRepository.findById(productToBuy.getId()).orElseThrow();
        productBought.setIsBought(true);
        productBought.setSeller(null);
        productBought.setOwner(loggedUser);

        return ProductModelDto.of(productRepository.save(productBought));
    }
}
