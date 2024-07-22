package bo.enterprisesample.ecommerce.service.email;

import bo.enterprisesample.ecommerce.domain.record.Product;
import jakarta.mail.MessagingException;

import java.math.BigDecimal;
import java.util.List;

public interface IEmailService {
     void sendPaymentSuccessEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference
    ) throws MessagingException;

     void sendOrderConfirmationEmail(
            String destinationEmail,
            String customerName,
            BigDecimal amount,
            String orderReference,
            List<Product> products
    ) throws MessagingException;
}
