import exceptions.DigitNotSupportedException;

public class ArabicDigit implements Digit{
    private int value;

    public ArabicDigit(String string) throws DigitNotSupportedException, NumberFormatException {
        this(Integer.parseInt(string));
    }

    public ArabicDigit(int value) throws DigitNotSupportedException {
        if (MIN_VALUE <= value && value <= MAX_VALUE)
            this.value = value;
        else throw new DigitNotSupportedException("Число '" + value + "' - не поддерживается программой.");
    }


    @Override
    public int toInt() {
        return value;
    }

    @Override
    public Digit calculate(Digit b, MathOperation operation) {
        switch (operation) {
            case ADD -> this.value += b.toInt();
            case SUBTRACT -> this.value -= b.toInt();
            case MULTIPLY -> this.value *= b.toInt();
            case DIVIDE -> this.value /= b.toInt();
        }
        return this;
    }

}
