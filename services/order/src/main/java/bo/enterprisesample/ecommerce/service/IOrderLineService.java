package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.entity.OrderLine;
import bo.enterprisesample.ecommerce.domain.request.OrderLineRequest;
import bo.enterprisesample.ecommerce.domain.response.OrderLineResponse;

import java.util.List;

public interface IOrderLineService {
    OrderLine createOrderLine(OrderLineRequest request);

    List<OrderLineResponse> findOrderLinesByOrderId(Integer orderId);
}
