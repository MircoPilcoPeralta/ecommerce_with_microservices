package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.entity.Order;
import bo.enterprisesample.ecommerce.domain.entity.OrderLine;
import bo.enterprisesample.ecommerce.domain.exception.BusinessException;
import bo.enterprisesample.ecommerce.domain.repository.IOrderRepository;
import bo.enterprisesample.ecommerce.domain.request.CreateOrderRequest;
import bo.enterprisesample.ecommerce.domain.request.OrderLineRequest;
import bo.enterprisesample.ecommerce.domain.request.PurchaseRequest;
import bo.enterprisesample.ecommerce.domain.response.OrderResponse;
import bo.enterprisesample.ecommerce.domain.response.PurchaseResponse;
import bo.enterprisesample.ecommerce.service.customer.ICustomerClient;
import bo.enterprisesample.ecommerce.service.product.IProductClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements IOrderService {

    private final IOrderRepository repository;
    private final ICustomerClient customerClient;
    private final IProductClient productClient;
    private final IOrderRepository orderRepository;
    private final IOrderMapper orderMapper;
    private final IOrderLineService orderLineService;

    @Override
    public OrderResponse createOrder(CreateOrderRequest request) {
        // Check the customer
        // Feign client method
        var customer = customerClient
                .findCustomerById(request.customerId())
                .orElseThrow(() -> new BusinessException(
                        String.format("the user with id: %s does not exist", request.customerId())
                ));

        // Discount products - product-service
        // Rest Template method
        List<PurchaseResponse> purchaseResponseList = productClient.purchaseProducts(request.products());

        // Persist order object
        Order orderSaved = orderRepository.save(orderMapper.toOrder(request));

        List<OrderLine> orderLinesSaved = new ArrayList<>();
        // Persist order Line
        for (PurchaseResponse product : purchaseResponseList) {
            OrderLine orderLine = orderLineService.createOrderLine(
                        new OrderLineRequest(
                                null,
                                orderSaved.getId(),
                                product.productId(),
                                product.quantity()
                        )
                    );

            orderLinesSaved.add(orderLine);
        }

        // payment process



        // Send a message to kafka broker (Notification-ms)


        return null;
    }
}
