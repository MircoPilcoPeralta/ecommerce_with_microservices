package bo.enterprisesample.ecommerce.domain.entity;

import bo.enterprisesample.ecommerce.domain.enums.NotificationType;
import bo.enterprisesample.ecommerce.domain.record.OrderConfirmation;
import bo.enterprisesample.ecommerce.domain.record.PaymentConfirmation;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Notification {
    @Id
    private String id;
    private NotificationType notificationType;
    private LocalDateTime notificationDate;
    private OrderConfirmation orderConfirmation;
    private PaymentConfirmation paymentConfirmation;
}
