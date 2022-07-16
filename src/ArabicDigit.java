import exceptions.DigitNotSupportedException;

public class ArabicDigit implements Digit{
    private final int value;

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

}
