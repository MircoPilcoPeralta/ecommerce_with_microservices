package bo.enterprisesample.ecommerce.domain.repository;

import bo.enterprisesample.ecommerce.domain.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderLineRepository extends JpaRepository<OrderLine, Integer> {
}
