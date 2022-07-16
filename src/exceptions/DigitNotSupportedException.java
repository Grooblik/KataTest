package exceptions;

public class DigitNotSupportedException extends Exception {
    public DigitNotSupportedException(String s) {
        super(s);
    }

    public DigitNotSupportedException(String s, Throwable cause) {
        super(s, cause);
    }
}
