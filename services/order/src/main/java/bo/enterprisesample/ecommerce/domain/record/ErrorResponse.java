package bo.enterprisesample.ecommerce.domain.record;

import java.util.Map;

public record ErrorResponse(
        Map<String, String> errors
) {
}
