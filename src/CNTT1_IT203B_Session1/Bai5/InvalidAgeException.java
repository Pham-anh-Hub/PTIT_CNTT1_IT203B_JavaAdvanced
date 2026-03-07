public class InvalidAgeException extends RuntimeException {
    public InvalidAgeException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return "";
    }
}
