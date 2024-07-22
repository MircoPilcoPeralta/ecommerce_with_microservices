package bo.enterprisesample.ecommerce.domain.record;

import bo.enterprisesample.ecommerce.domain.enums.PaymentMethod;

import java.math.BigDecimal;

public record PaymentConfirmation(
    String orderReference,
    BigDecimal amount,
    PaymentMethod paymentMethod,
    String customerFirstname,
    String customerLastname,
    String customerEmail
) {
}
