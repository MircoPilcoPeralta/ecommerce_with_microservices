package bo.enterprisesample.ecommerce.service.kafka;

import bo.enterprisesample.ecommerce.domain.entity.Notification;
import bo.enterprisesample.ecommerce.domain.enums.NotificationType;
import bo.enterprisesample.ecommerce.domain.record.OrderConfirmation;
import bo.enterprisesample.ecommerce.domain.record.PaymentConfirmation;
import bo.enterprisesample.ecommerce.domain.repository.NotificationRepository;
import bo.enterprisesample.ecommerce.service.email.IEmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {

    private final NotificationRepository repository;
    private final IEmailService emailService;


    @KafkaListener(topics = "payment-topic")
    public void consumePaymentSuccessNotification(PaymentConfirmation paymentConfirmation) throws MessagingException {
        log.info("Consuming from payment-topic, payment confirmation: <{}>", paymentConfirmation );

        Notification notification = Notification
                .builder()
                .notificationType(NotificationType.PAYMENT_CONFIRMATION)
                .notificationDate(LocalDateTime.now())
                .paymentConfirmation(paymentConfirmation)
                .build();
        repository.save(notification);


        emailService.sendPaymentSuccessEmail(
                paymentConfirmation.customerEmail(),
                paymentConfirmation.customerFirstname() + " " + paymentConfirmation.customerLastname(),
                paymentConfirmation.amount(),
                paymentConfirmation.orderReference()
        );
    }

    @KafkaListener(topics = "order-topic")
    public void consumeOrderConfirmationNotification(OrderConfirmation orderConfirmation) throws MessagingException {
        log.info("Consuming from order-topic, order confirmation: <{}>", orderConfirmation );

        Notification notification = Notification
                .builder()
                .notificationType(NotificationType.ORDER_CONFIRMATION)
                .notificationDate(LocalDateTime.now())
                .orderConfirmation(orderConfirmation)
                .build();

        repository.save(notification);

        emailService.sendOrderConfirmationEmail(
                orderConfirmation.customer().email(),
                orderConfirmation.customer().firstname() + " " +orderConfirmation.customer().lastname(),
                orderConfirmation.totalAmount(),
                orderConfirmation.orderReference(),
                orderConfirmation.products()
        );

    }


}
