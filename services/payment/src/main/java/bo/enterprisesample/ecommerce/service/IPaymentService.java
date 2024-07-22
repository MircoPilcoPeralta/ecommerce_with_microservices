package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.request.PaymentRequest;
import bo.enterprisesample.ecommerce.domain.response.PaymentResponse;

public interface IPaymentService {
    PaymentResponse createPayment(PaymentRequest request);
}
