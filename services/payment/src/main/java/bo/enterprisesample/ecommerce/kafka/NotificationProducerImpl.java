package bo.enterprisesample.ecommerce.kafka;

import bo.enterprisesample.ecommerce.domain.record.PaymentNotificationRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationProducerImpl implements INotificationProducer {
    private KafkaTemplate<String, PaymentNotificationRequest> kafkaTemplate;

    @Override
    public void sendNotification(PaymentNotificationRequest request) {
        log.info("Sending message from payment-topic, with body <{}>", request);

        Message<PaymentNotificationRequest> notificationMessage = MessageBuilder
                .withPayload(request)
                .setHeader(KafkaHeaders.TOPIC, "payment-topic")
                .build();

        kafkaTemplate.send(notificationMessage);
    }
}
