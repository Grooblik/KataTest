import exceptions.DigitNotSupportedException;

public class Command {

    private final MathOperation mathOperation;
    private final Number a;
    private final Number b;

    public Command(Number a, Number b, MathOperation operation) {
        this.a = a;
        this.b = b;
        this.mathOperation = operation;
    }

    public Number calculate() throws DigitNotSupportedException {
        return a.calculate(b, mathOperation);
    }


}
