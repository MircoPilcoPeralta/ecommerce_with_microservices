package bo.enterprisesample.ecommerce.kafka;

import bo.enterprisesample.ecommerce.domain.record.PaymentNotificationRequest;
import bo.enterprisesample.ecommerce.domain.request.PaymentRequest;

public interface INotificationProducer {
    void sendNotification(PaymentNotificationRequest request);
}
