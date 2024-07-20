package bo.enterprisesample.ecommerce.controller;

import bo.enterprisesample.ecommerce.domain.response.OrderLineResponse;
import bo.enterprisesample.ecommerce.service.IOrderLineService;
import bo.enterprisesample.ecommerce.service.IOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-lines")
@RequiredArgsConstructor
public class OrderLineController {
    private final IOrderLineService service;
    private final IOrderService orderService;

    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderLineResponse>> findOrderLinesByOrderId(@PathVariable Integer orderId) {
        return ResponseEntity.ok().body(service.findOrderLinesByOrderId(orderId));
    }
}
