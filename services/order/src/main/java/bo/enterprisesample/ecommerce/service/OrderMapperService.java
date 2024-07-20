package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.entity.Order;
import bo.enterprisesample.ecommerce.domain.entity.OrderLine;
import bo.enterprisesample.ecommerce.domain.request.CreateOrderRequest;
import bo.enterprisesample.ecommerce.domain.request.OrderLineRequest;
import bo.enterprisesample.ecommerce.domain.request.PurchaseRequest;
import bo.enterprisesample.ecommerce.domain.response.OrderResponse;
import bo.enterprisesample.ecommerce.domain.response.PurchaseResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderMapperService implements IOrderMapper {
    @Override
    public Order toOrder(CreateOrderRequest request) {
        return Order
                .builder()
                .id(request.id())
                .customerId(request.customerId())
                .reference(request.reference())
                .paymentMethod(request.paymentMethod())
                .totalAmount(request.totalAmount())
                /*
                    todo: test automatic creation of orders, changing the code from Order entity to;
                     @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true, )
                     private List<OrderLine> orderLines;

                    .orderLines(toOrderLines(request.products()))
                 */
                .build();
    }

    @Override
    public OrderResponse toOrderResponse(Order order) {
        return null;
    }

    @Override
    public OrderLine toOrderLine(OrderLineRequest request) {
        return OrderLine
                .builder()
                .id(request.id())
                .order( Order.builder().id(request.orderId()).build() )
                .productId(request.productId())
                .quantity(request.quantity())
                .build();
    }

    private List<OrderLine> toOrderLines(List<PurchaseRequest> purchaseRequests) {
        List<OrderLine> orderLines = new ArrayList<>();

        purchaseRequests.stream().forEach(
                (pcr) -> {
                    orderLines.add(OrderLine.builder().productId(pcr.productId()).quantity(pcr.quantity()).build());
                }
        );
        return orderLines;
    }
}
