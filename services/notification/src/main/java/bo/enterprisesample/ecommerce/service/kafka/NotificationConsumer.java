package bo.enterprisesample.ecommerce.service.kafka;

import bo.enterprisesample.ecommerce.domain.record.OrderConfirmation;
import bo.enterprisesample.ecommerce.domain.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository repository;

    @KafkaListener(topics = "order-topic")
    public void listenOrder(OrderConfirmation orderConfirmation) {

    }
}
