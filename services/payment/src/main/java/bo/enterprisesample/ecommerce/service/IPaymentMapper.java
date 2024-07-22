package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.entity.Payment;
import bo.enterprisesample.ecommerce.domain.request.PaymentRequest;
import bo.enterprisesample.ecommerce.domain.response.PaymentResponse;

public interface IPaymentMapper{
    Payment toPayment(PaymentRequest request);

    PaymentResponse toPaymentResponse(Payment payment);
}
