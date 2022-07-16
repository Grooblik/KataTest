public class Command {

    private final MathOperation mathOperation;
    private final Digit a;
    private final Digit b;

    public Command(Digit a, Digit b, MathOperation operation) {
        this.a = a;
        this.b = b;
        this.mathOperation = operation;
    }

    public int calculate() {
        return mathOperation.calculate(a.toInt(), b.toInt());
    }


}
