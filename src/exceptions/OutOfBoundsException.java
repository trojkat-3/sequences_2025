package exceptions;

public class OutOfBoundsException extends Exception {
    public OutOfBoundsException(String msg, int n, int max) {
        super("Argument: [" + n + "] exceeds allowed range: [" + max + "], " + msg);
    }
}
