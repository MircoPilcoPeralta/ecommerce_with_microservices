package bo.enterprisesample.ecommerce.controller;

import bo.enterprisesample.ecommerce.domain.request.CreateOrderRequest;
import bo.enterprisesample.ecommerce.domain.response.OrderResponse;
import bo.enterprisesample.ecommerce.service.IOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final IOrderService service;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(
            @RequestBody @Valid CreateOrderRequest request
    ) {
        return ResponseEntity.ok(service.createOrder(request));
    }


}
