package bo.enterprisesample.ecommerce.kafka;

import bo.enterprisesample.ecommerce.domain.record.OrderConfirmation;

public interface IOrderProducer {
    void sendOrderConfirmation(OrderConfirmation orderConfirmation);
}
