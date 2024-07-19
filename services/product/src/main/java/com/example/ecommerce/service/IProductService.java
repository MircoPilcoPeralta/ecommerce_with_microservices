package com.example.ecommerce.service;

import com.example.ecommerce.domain.enitites.Product;
import com.example.ecommerce.domain.request.CreateProductRequest;
import com.example.ecommerce.domain.request.ProductPurchaseRequest;
import com.example.ecommerce.domain.response.ProductPurchaseResponse;
import com.example.ecommerce.domain.response.ProductResponse;

import java.util.List;

public interface IProductService {
    ProductResponse createProduct(CreateProductRequest request);

    List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request);

    ProductResponse findProductById(Integer id);

    List<ProductResponse> findAll();
}
