package bo.enterprisesample.ecommerce.domain.repository;

import bo.enterprisesample.ecommerce.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderRepository extends JpaRepository<Order, Integer> {
}
