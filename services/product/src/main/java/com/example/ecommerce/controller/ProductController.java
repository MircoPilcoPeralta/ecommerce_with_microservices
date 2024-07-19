package com.example.ecommerce.controller;

import com.example.ecommerce.domain.request.CreateProductRequest;
import com.example.ecommerce.domain.request.ProductPurchaseRequest;
import com.example.ecommerce.domain.response.ProductPurchaseResponse;
import com.example.ecommerce.domain.response.ProductResponse;
import com.example.ecommerce.service.IProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final IProductService service;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody @Valid CreateProductRequest request) {
        return ResponseEntity.ok(service.createProduct(request));
    }

    @PostMapping("/purchase")
    public ResponseEntity<List<ProductPurchaseResponse>> purchaseProducts(
            @RequestBody List<ProductPurchaseRequest> request
    ) {
        return ResponseEntity.ok(service.purchaseProducts(request));
    }

    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findProductById(@PathVariable("product-id") Integer id) {
        return ResponseEntity.ok(service.findProductById(id));
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponse>> findAllProducts() {
        return ResponseEntity.ok(service.findAll());
    }

}
