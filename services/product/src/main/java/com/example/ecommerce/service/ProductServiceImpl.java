package com.example.ecommerce.service;

import com.example.ecommerce.domain.enitites.Product;
import com.example.ecommerce.domain.exceptions.ProductPurchaseException;
import com.example.ecommerce.domain.repository.IProductRepository;
import com.example.ecommerce.domain.request.CreateProductRequest;
import com.example.ecommerce.domain.request.ProductPurchaseRequest;
import com.example.ecommerce.domain.response.ProductPurchaseResponse;
import com.example.ecommerce.domain.response.ProductResponse;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements IProductService {

    private final IProductRepository repository;
    private final IProductMapper mapper;

    @Override
    public ProductResponse createProduct(CreateProductRequest request) {
        if(request == null) {
            return null;
        }
        Product product = mapper.toProduct(request);
        return mapper.toProductResponse(repository.save(product));
    }

    @Override
    public List<ProductPurchaseResponse> purchaseProducts(List<ProductPurchaseRequest> request) {
        List<Integer> productIds = request
                .stream()
                .map(ProductPurchaseRequest::productId)
                .toList();

        List<Product> storedProducts = repository.findAllByIdInOrderById(productIds);

        if(productIds.size() != storedProducts.size()) {
            throw new ProductPurchaseException("One or more products does not exist");
        }

        List<ProductPurchaseRequest> storesRequest = request
                .stream()
                .sorted(Comparator.comparing(ProductPurchaseRequest::productId))
                .toList();

        List<ProductPurchaseResponse> purchasedProducts = new ArrayList<ProductPurchaseResponse>();

        for(int i = 0; i < storedProducts.size(); i++) {
            Product productDb = storedProducts.get(i);
            ProductPurchaseRequest productRequest = storesRequest.get(i);

            if(productDb.getAvailableQuantity() < productRequest.quantity()) {
                throw new ProductPurchaseException(
                        String.format("Insufficient stock quantity for product with id: %s", productDb.getId())
                );
            } else {
                Double newQuantity = productDb.getAvailableQuantity() - productRequest.quantity();
                productDb.setAvailableQuantity(newQuantity);

                purchasedProducts.add(mapper.toProductPurchaseResponse(productDb, newQuantity));

                repository.save(productDb);
            }
            
        }


        return purchasedProducts;
    }

    @Override
    public ProductResponse findProductById(Integer id) {
        return mapper.toProductResponse(
                repository.findById(id).orElseThrow(()-> new EntityNotFoundException(
                        String.format("Product with id %s was not found", id)
                ))
        );
    }

    @Override
    public List<ProductResponse> findAll() {
        return List.of();
    }
}
