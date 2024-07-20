package bo.enterprisesample.ecommerce.domain.record;

import bo.enterprisesample.ecommerce.domain.entity.PaymentMethod;
import bo.enterprisesample.ecommerce.domain.response.CustomerResponse;
import bo.enterprisesample.ecommerce.domain.response.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
