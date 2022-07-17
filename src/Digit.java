public interface Digit {
    int MIN_VALUE = 1;
    int MAX_VALUE = 10;

    int toInt();

    Digit calculate(Digit b, MathOperation operation);
}
