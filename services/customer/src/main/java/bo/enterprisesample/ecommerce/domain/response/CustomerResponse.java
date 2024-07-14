package bo.enterprisesample.ecommerce.domain.response;

import bo.enterprisesample.ecommerce.domain.entities.Address;
import org.springframework.data.annotation.Id;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email,
        Address address
) {
}
