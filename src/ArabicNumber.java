import exceptions.DigitNotSupportedException;

public class ArabicNumber implements Number {
    private int value;

    public ArabicNumber(int value) throws DigitNotSupportedException {
        if (value < MIN_VALUE || value > MAX_VALUE)
            throw new DigitNotSupportedException("Число '" + value + "' - не поддерживается программой.");
        this.value = value;
    }


    public ArabicNumber(String string) throws DigitNotSupportedException, NumberFormatException {
        this(Integer.parseInt(string));
    }


    @Override
    public int toInt() {
        return value;
    }

    @Override
    public Number calculate(Number b, MathOperation operation) {
        switch (operation) {
            case ADD -> this.value += b.toInt();
            case SUBTRACT -> this.value -= b.toInt();
            case MULTIPLY -> this.value *= b.toInt();
            case DIVIDE -> this.value /= b.toInt();
        }
        return this;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
