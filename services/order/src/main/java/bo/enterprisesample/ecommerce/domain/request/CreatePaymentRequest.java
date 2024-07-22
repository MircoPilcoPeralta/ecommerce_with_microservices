package bo.enterprisesample.ecommerce.domain.request;

import bo.enterprisesample.ecommerce.domain.entity.PaymentMethod;
import bo.enterprisesample.ecommerce.domain.response.CustomerResponse;

import java.math.BigDecimal;

public record CreatePaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customerResponse
) {
}
