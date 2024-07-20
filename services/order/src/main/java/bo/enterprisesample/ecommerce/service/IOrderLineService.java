package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.entity.OrderLine;
import bo.enterprisesample.ecommerce.domain.request.OrderLineRequest;

public interface IOrderLineService {
    OrderLine createOrderLine(OrderLineRequest request);
}
