package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.request.CreateOrderRequest;
import bo.enterprisesample.ecommerce.domain.response.OrderResponse;

import java.util.List;

public interface IOrderService {
    OrderResponse createOrder(CreateOrderRequest request);

    List<OrderResponse> findAll();

    OrderResponse findById(Integer id);
}
