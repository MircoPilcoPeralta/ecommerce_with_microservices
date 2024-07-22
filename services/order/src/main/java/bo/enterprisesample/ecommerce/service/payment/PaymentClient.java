package bo.enterprisesample.ecommerce.service.payment;

import bo.enterprisesample.ecommerce.domain.request.CreatePaymentRequest;
import bo.enterprisesample.ecommerce.domain.response.PaymentResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@FeignClient(
        name="payment-service",
        url = "${application.config.payment-url}"
)
public interface PaymentClient {
    @PostMapping
    Optional<PaymentResponse> createPayment(@RequestBody CreatePaymentRequest request);
}
