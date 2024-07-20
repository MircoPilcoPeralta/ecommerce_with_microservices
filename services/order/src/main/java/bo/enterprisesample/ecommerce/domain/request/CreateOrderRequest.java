package bo.enterprisesample.ecommerce.domain.request;

import bo.enterprisesample.ecommerce.domain.entity.OrderLine;
import bo.enterprisesample.ecommerce.domain.entity.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record CreateOrderRequest(
        Integer id,
        @NotNull(message = "Customer should be present")
        @NotEmpty(message = "Customer should be present")
        @NotBlank(message = "Customer should be present")
        String customerId,
        @NotNull(message = "Payment method should be precised")
        PaymentMethod paymentMethod,
        @Positive(message = "Order amount should be positive")
        BigDecimal totalAmount,
        @NotEmpty
        String reference,
        @NotEmpty(message = "You should at least purchase one product")
        List<PurchaseRequest> products
) {
}
