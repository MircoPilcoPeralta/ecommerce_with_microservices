package bo.enterprisesample.ecommerce.domain.record;

import bo.enterprisesample.ecommerce.domain.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation (
    String orderReference,
    BigDecimal totalAmount,
    PaymentMethod paymentMethod,
    Customer customer,
    List<Product> products
){
}
