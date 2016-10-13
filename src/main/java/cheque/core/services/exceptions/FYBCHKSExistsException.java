package cheque.core.services.exceptions;

/**
 * Created by finwebmailer on 7/24/2016.
 */
public class FYBCHKSExistsException extends RuntimeException {
    public FYBCHKSExistsException() {
    }

    public FYBCHKSExistsException(String message) {
        super(message);
    }

    public FYBCHKSExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FYBCHKSExistsException(Throwable cause) {
        super(cause);
    }
}