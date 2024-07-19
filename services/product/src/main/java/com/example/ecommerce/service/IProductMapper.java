package com.example.ecommerce.service;

import com.example.ecommerce.domain.enitites.Product;
import com.example.ecommerce.domain.request.CreateProductRequest;
import com.example.ecommerce.domain.request.ProductPurchaseRequest;
import com.example.ecommerce.domain.response.ProductPurchaseResponse;
import com.example.ecommerce.domain.response.ProductResponse;

public interface IProductMapper {
    Product toProduct(CreateProductRequest request);
    ProductResponse toProductResponse(Product product);
    ProductPurchaseResponse toProductPurchaseResponse(Product product, Double quantity);
}
