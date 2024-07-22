package bo.enterprisesample.ecommerce.domain.repository;

import bo.enterprisesample.ecommerce.domain.entity.Notification;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface NotificationRepository extends MongoRepository<Notification, String> {
}
