package EX;

public class QueueFullException extends RuntimeException {
    public QueueFullException(String message) {
        super(message);
    }
}
