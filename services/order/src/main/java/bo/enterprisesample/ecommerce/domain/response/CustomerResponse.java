package bo.enterprisesample.ecommerce.domain.response;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
