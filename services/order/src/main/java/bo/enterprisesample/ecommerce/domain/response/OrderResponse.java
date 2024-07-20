package bo.enterprisesample.ecommerce.domain.response;

import bo.enterprisesample.ecommerce.domain.entity.OrderLine;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponse(
        String customerId,
        String paymentMethod,
        String reference,
        BigDecimal totalAmount,
        List<OrderLine> orderLines
) {
}
