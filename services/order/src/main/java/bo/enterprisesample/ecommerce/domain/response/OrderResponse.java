package bo.enterprisesample.ecommerce.domain.response;

import bo.enterprisesample.ecommerce.domain.entity.OrderLine;
import bo.enterprisesample.ecommerce.domain.entity.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponse(
        String customerId,
        PaymentMethod paymentMethod,
        String reference,
        BigDecimal totalAmount
) {
}
