package bo.enterprisesample.ecommerce.domain.request;

public record OrderLineRequest(
        Integer id,
        Integer orderId,
        Integer productId,
        Double quantity
) {
}
