package bo.enterprisesample.ecommerce.domain.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record CustomerRequest(
        String id,
        @NotNull(message = "firstname is required")
        String firstname,
        @NotNull(message = "lastname is required")
        String lastname,
        @NotNull(message = "email is required")
        @Email(message = "email does not have a valid format")
        String email
) {
}
