package ThuchanhJavaAdvanced_Session05;

public class InvalidProductException extends RuntimeException {
    public InvalidProductException() {
        System.err.println("ID bị trùng hoặc không tồn tại");
    }
}
