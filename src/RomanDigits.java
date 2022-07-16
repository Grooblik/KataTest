import exceptions.DigitNotSupportedException;

public enum RomanDigits implements Digit {
    I(1, "I"),
    II(2, "II"),
    III(3, "II"),
    IV(4, "IV"),
    V(5, "V"),
    VI(6, "VI"),
    VII(7, "VII"),
    VIII(8, "VIII"),
    IX(9, "IX"),
    X(10, "X");

    public int arabicValue;
    public String glyph;

    RomanDigits(int arabicValue, String glyph) {
        this.arabicValue = arabicValue;
        this.glyph = glyph;
    }

    public static int toArabic(String glyph) throws DigitNotSupportedException {
        for (RomanDigits digit :
                RomanDigits.values()) {
            if (glyph.equals(
                    digit.glyph
            ))
                return digit.arabicValue;
        }
        throw new DigitNotSupportedException("Число '" + glyph + "' - не поддерживается программой.");
    }

    @Override
    public int toInt() {
        return this.arabicValue;
    }
}


