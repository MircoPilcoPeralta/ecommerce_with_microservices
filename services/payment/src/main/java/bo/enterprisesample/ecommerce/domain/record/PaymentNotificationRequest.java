package bo.enterprisesample.ecommerce.domain.record;

import bo.enterprisesample.ecommerce.domain.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        String customerFirstname,
        String customerLastname,
        String customerEmail
) {
}
