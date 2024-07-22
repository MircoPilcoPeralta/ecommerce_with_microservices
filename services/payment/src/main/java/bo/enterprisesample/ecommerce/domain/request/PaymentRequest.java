package bo.enterprisesample.ecommerce.domain.request;

import bo.enterprisesample.ecommerce.domain.entity.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest (
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerRequest customer
){
}
