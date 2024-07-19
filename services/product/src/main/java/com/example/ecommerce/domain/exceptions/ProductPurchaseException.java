package com.example.ecommerce.domain.exceptions;


import com.sun.jdi.InternalException;

public class ProductPurchaseException extends InternalException {
    public ProductPurchaseException(String message) {
        super(message);
    }
}
