package bo.enterprisesample.ecommerce.domain.response;

import bo.enterprisesample.ecommerce.domain.entity.PaymentMethod;
import bo.enterprisesample.ecommerce.domain.request.CustomerRequest;

import java.math.BigDecimal;

public record PaymentResponse(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId
) {
}
