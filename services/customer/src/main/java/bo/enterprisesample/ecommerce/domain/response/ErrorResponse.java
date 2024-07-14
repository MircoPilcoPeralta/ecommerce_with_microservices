package bo.enterprisesample.ecommerce.domain.response;

import java.util.Map;

public record ErrorResponse (
        Map<String, String> errors
) {

}
