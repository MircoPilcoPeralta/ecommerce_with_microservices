package bo.enterprisesample.ecommerce.domain.response;

public record CustomerResponse(
        String id,
        String firstName,
        String lastName,
        String email
) {
}
