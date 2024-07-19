package com.example.ecommerce.domain.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ProductPurchaseRequest(
        @NotNull(message = "Product id must be provided")
        Integer productId,
        @Positive(message = "quantity must be positive")
        @NotNull(message = "quantity must be provided")
        Double quantity
) {
}
