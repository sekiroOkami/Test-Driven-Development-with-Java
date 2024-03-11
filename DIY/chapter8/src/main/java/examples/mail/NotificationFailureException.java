package examples.mail;

public class NotificationFailureException extends RuntimeException {
    public NotificationFailureException(String message) {
        super(message);
    }
}
