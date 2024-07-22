package bo.enterprisesample.ecommerce.domain.repository;

import bo.enterprisesample.ecommerce.domain.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {
}
