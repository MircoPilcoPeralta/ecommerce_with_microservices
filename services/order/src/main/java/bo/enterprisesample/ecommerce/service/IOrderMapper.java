package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.entity.Order;
import bo.enterprisesample.ecommerce.domain.entity.OrderLine;
import bo.enterprisesample.ecommerce.domain.request.CreateOrderRequest;
import bo.enterprisesample.ecommerce.domain.request.OrderLineRequest;
import bo.enterprisesample.ecommerce.domain.response.OrderResponse;

public interface IOrderMapper {
    Order toOrder(CreateOrderRequest request);
    OrderResponse toOrderResponse(Order order);
    OrderLine toOrderLine(OrderLineRequest request);
}
