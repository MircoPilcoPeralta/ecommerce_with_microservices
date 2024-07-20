package bo.enterprisesample.ecommerce.domain.exception;

import com.sun.jdi.InternalException;

public class BusinessException extends InternalException {
    public BusinessException(String message ) {
        super( message );
    }
}
