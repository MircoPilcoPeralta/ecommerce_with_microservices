package com.example.ecommerce.domain.exceptions;


import com.sun.jdi.InternalException;

public class ProductPurchaseFailedException extends InternalException {
    public ProductPurchaseFailedException(String message) {
        super(message);
    }
}
