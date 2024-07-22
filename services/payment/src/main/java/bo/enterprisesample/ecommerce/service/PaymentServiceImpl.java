package bo.enterprisesample.ecommerce.service;

import bo.enterprisesample.ecommerce.domain.entity.Payment;

import bo.enterprisesample.ecommerce.domain.record.PaymentNotificationRequest;
import bo.enterprisesample.ecommerce.domain.repository.PaymentRepository;
import bo.enterprisesample.ecommerce.domain.request.PaymentRequest;
import bo.enterprisesample.ecommerce.domain.response.PaymentResponse;
import bo.enterprisesample.ecommerce.kafka.INotificationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements IPaymentService {

    private final PaymentRepository repository;
    private final IPaymentMapper mapper;
    private final INotificationProducer notificationProducer;

    @Override
    public PaymentResponse createPayment(PaymentRequest request) {
        Payment payment = repository.save(mapper.toPayment(request));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        request.orderReference(),
                        request.amount(),
                        request.paymentMethod(),
                        request.customer().firstname(),
                        request.customer().lastname(),
                        request.customer().email()
                )
        );
        return mapper.toPaymentResponse(payment);

    }
}
