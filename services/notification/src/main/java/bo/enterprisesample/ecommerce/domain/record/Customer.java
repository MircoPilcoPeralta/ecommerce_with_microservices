package bo.enterprisesample.ecommerce.domain.record;

public record Customer(
    String id,
    String firstname,
    String lastname,
    String email
) {
}
