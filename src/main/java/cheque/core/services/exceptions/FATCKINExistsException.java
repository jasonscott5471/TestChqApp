package cheque.core.services.exceptions;

/**
 * Created by finwebmailer on 6/19/2016.
 */
public class FATCKINExistsException extends RuntimeException {
    public FATCKINExistsException() {
    }

    public FATCKINExistsException(String message) {
        super(message);
    }

    public FATCKINExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public FATCKINExistsException(Throwable cause) {
        super(cause);
    }
}
