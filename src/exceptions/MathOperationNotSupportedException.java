package exceptions;

public class MathOperationNotSupportedException extends IllegalStateException {
    public MathOperationNotSupportedException(String s) {
        super(s);
    }
}
