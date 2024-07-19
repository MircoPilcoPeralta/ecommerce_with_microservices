package com.example.ecommerce.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class ErrorResponse {
    private Map<String, String> errors;
}
