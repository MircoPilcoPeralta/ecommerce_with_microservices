package bo.enterprisesample.ecommerce.domain.record;

import java.math.BigDecimal;

public record Product(
        Integer id,
        String name,
        String  description,
        BigDecimal price,
        Double quantity
) {
}
