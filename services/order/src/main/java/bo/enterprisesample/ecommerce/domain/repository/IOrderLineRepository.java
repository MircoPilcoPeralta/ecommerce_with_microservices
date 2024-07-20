package bo.enterprisesample.ecommerce.domain.repository;

import bo.enterprisesample.ecommerce.domain.entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IOrderLineRepository extends JpaRepository<OrderLine, Integer> {
    List<OrderLine> findAllByOrderId(Integer orderId);
}
