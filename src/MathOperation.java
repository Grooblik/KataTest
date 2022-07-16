public enum MathOperation {

    ADD('+'),
    SUBTRACT('-'),
    MULTIPLY('*'),
    DIVIDE('/');


    public char sign;

    MathOperation(char sign) {
        this.sign = sign;
    }

    public int calculate(int a, int b) {
        switch (this) {
            case ADD -> {
                return a + b;
            }
            case SUBTRACT -> {
                return a - b;
            }
            case MULTIPLY -> {
                return a * b;
            }
            case DIVIDE ->  {
                return a / b;
            }
            default -> throw new EnumConstantNotPresentException(MathOperation.class, String.valueOf(this.sign));
        }
    }

}
