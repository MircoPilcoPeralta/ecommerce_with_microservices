package com.example.ecommerce.service;

import com.example.ecommerce.domain.enitites.Category;
import com.example.ecommerce.domain.enitites.Product;
import com.example.ecommerce.domain.request.CreateProductRequest;
import com.example.ecommerce.domain.response.ProductPurchaseResponse;
import com.example.ecommerce.domain.response.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductMapperImpl implements IProductMapper {
    @Override
    public Product toProduct(CreateProductRequest request) {
        return Product
                .builder()
                .id(request.id())
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(Category.builder().id(request.id()).build())
                .build();
    }

    @Override
    public ProductResponse toProductResponse(Product product) {
        return new ProductResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory()
        );
    }

    @Override
    public ProductPurchaseResponse toProductPurchaseResponse(Product product, Double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
