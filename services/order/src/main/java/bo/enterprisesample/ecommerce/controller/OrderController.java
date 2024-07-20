package bo.enterprisesample.ecommerce.controller;

import bo.enterprisesample.ecommerce.domain.request.CreateOrderRequest;
import bo.enterprisesample.ecommerce.domain.response.OrderResponse;
import bo.enterprisesample.ecommerce.service.IOrderService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<OrderResponse>> fingAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{order-id}")
    public ResponseEntity<OrderResponse> findById(@PathVariable("order-id") Integer id) {
        return ResponseEntity.ok(service.findById(id));
    }

}
