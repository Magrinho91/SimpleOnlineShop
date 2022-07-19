package com.example.SimpleOnlineShop.feature.product.controller;

import com.example.SimpleOnlineShop.feature.product.model.ProductModel;
import com.example.SimpleOnlineShop.feature.product.dto.ProductModelDto;
import com.example.SimpleOnlineShop.feature.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.example.SimpleOnlineShop.feature.user.role.UserRole.UserRoleValues.ROLE_SELLER;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<ProductModel> getAll () {
        return productService.getAllProducts();
    }

    @GetMapping("/productsOfSeller")
    public List<ProductModelDto> getAllForSeller () {
        return productService.getAllProductsForSeller();
    }

    @GetMapping("productsOfOwner")
    public List<ProductModelDto> getAllForOwner () {
        return productService.getAllProductsForOwner();
    }

    @PostMapping
    @Secured(ROLE_SELLER)
    public ProductModelDto add(@RequestBody ProductModelDto productModelDto){
        return productService.addProduct(productModelDto);
    }

    @PutMapping("updateProduct")
    @Secured(ROLE_SELLER)
    public ProductModelDto update(@RequestBody ProductModelDto productModel){
        return productService.updateProduct(productModel);
    }

    @DeleteMapping("{productId}")
    @Secured(ROLE_SELLER)
    public void delete (@PathVariable Long productId){
        productService.deleteProduct(productId);
    }

    @PutMapping("buyProduct")
    public ProductModelDto buyProduct(@RequestBody ProductModelDto productToBuy){
        return productService.buyProduct(productToBuy);
    }
}
