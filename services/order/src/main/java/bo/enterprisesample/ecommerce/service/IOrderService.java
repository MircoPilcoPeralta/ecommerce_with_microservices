package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.entity.Order;
import bo.enterprisesample.ecommerce.domain.request.CreateOrderRequest;
import bo.enterprisesample.ecommerce.domain.response.OrderResponse;

public interface IOrderService {
    OrderResponse createOrder(CreateOrderRequest request);
}
