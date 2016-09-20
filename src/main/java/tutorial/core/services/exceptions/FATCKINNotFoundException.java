package tutorial.core.services.exceptions;

/**
 * Created by finwebmailer on 6/19/2016.
 */
public class FATCKINNotFoundException extends RuntimeException {
    public FATCKINNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FATCKINNotFoundException(String message) {
        super(message);
    }

    public FATCKINNotFoundException() {
    }
}