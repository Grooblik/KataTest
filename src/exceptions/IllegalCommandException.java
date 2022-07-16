package exceptions;

public class IllegalCommandException extends IllegalArgumentException{
    public IllegalCommandException() {
        super("Математическая команда не поддерживается");
    }

    public IllegalCommandException(Throwable cause) {
        super("Математическая команда не поддерживается", cause);
    }

    public IllegalCommandException(String s, Throwable cause) {
        super(s, cause);
    }
}
