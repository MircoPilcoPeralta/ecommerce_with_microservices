package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.entity.Payment;
import bo.enterprisesample.ecommerce.domain.request.PaymentRequest;
import bo.enterprisesample.ecommerce.domain.response.PaymentResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentMapperImpl implements IPaymentMapper {

    @Override
    public Payment toPayment(PaymentRequest request) {
        return Payment
                .builder()
                .id(request.id())
                .amount(request.amount())
                .paymentMethod(request.paymentMethod())
                .orderId(request.orderId())
                .build();
    }

    @Override
    public PaymentResponse toPaymentResponse(Payment payment) {
        return new PaymentResponse(
                payment.getId(),
                payment.getAmount(),
                payment.getPaymentMethod(),
                payment.getOrderId()
        );
    }
}
