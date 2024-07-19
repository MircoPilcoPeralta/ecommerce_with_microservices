package com.example.ecommerce.domain.response;

import com.example.ecommerce.domain.enitites.Category;
import java.math.BigDecimal;

public record ProductResponse(
    Integer id,
    String name,
    String description,
    Double availableQuantity,
    BigDecimal price,
    Category category
) {
}
