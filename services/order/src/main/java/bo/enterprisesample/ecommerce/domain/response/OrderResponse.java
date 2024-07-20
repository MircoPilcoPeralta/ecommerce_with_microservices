package bo.enterprisesample.ecommerce.domain.response;

import bo.enterprisesample.ecommerce.domain.entity.OrderLine;
import bo.enterprisesample.ecommerce.domain.entity.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponse(
        Integer id,
        String reference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        String customerId
) {
}
