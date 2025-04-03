package exception;

public class BadStringValue extends RuntimeException {

    public BadStringValue(String message) {
        super(message);
    }
}