package bo.enterprisesample.ecommerce.domain.exceptions;

import com.sun.jdi.InternalException;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFoundException extends InternalException {
    private final String msg;
}
