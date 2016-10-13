package cheque.core.services.exceptions;

/**
 * Created by finwebmailer on 7/24/2016.
 */
public class FYBCHKSNotFoundException extends RuntimeException {
    public FYBCHKSNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FYBCHKSNotFoundException(String message) {
        super(message);
    }

    public FYBCHKSNotFoundException() {
    }
}
