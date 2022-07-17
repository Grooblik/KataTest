import exceptions.DigitNotSupportedException;

public class RomanNumber implements Number {
    private final static int MAX_ROMAN = 100;
    private final static int MIN_ROMAN = 1;
    String glyph;
    int value;

    public RomanNumber(String glyph) throws DigitNotSupportedException, IllegalArgumentException {
        this(
                RomanDigits
                        .valueOf(glyph)
                        .arabicValue
        );
    }

    private RomanNumber(int value) throws DigitNotSupportedException {
        if (value < MIN_ROMAN || value > MAX_ROMAN)
            throw new DigitNotSupportedException("Число " + value + "не поддерживается.");

        this.glyph = getGlyph(value);
        this.value = value;
    }

    private static String getGlyph(int value) {
        String resGlyph = "";


        resGlyph += C(value / 100);

        value %= 100;

        resGlyph += X(value / 10);

        value %= 10;

        resGlyph += I(value);

        return resGlyph;
    }

    private static String C(int amount) {
        return "C".repeat(amount);
    }

    private static String X(int amount) {
        if (amount < 4) return "X".repeat(amount);
        if (amount == 9) return "XC";
        if (amount > 4) return "L" + "X".repeat(amount - 5);
        return "XL";
    }

    private static String I(int amount) {
        if (amount < 4) return "I".repeat(amount);
        if (amount == 9) return "IX";
        if (amount > 4) return "V" + "I".repeat(amount - 5);
        return "IV";
    }


    @Override
    public int toInt() {
        return value;
    }

    @Override
    public Number calculate(Number b, MathOperation operation) throws DigitNotSupportedException, IllegalStateException {
        int result;
        switch (operation) {
            case ADD -> result = this.toInt() + b.toInt();
            case SUBTRACT -> result = this.toInt() - b.toInt();
            case MULTIPLY -> result = this.toInt() * b.toInt();
            case DIVIDE -> result = this.toInt() / b.toInt();
            default -> throw new IllegalStateException("Unexpected value: " + operation);
        }

        return new RomanNumber(result);
    }

    @Override
    public String toString() {
        return glyph;
    }
}
