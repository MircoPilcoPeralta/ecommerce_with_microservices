package bo.enterprisesample.ecommerce.domain.response;

import bo.enterprisesample.ecommerce.domain.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentResponse(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customerResponse
) {
}
