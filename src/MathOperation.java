import exceptions.MathOperationNotSupportedException;

public enum MathOperation {

    ADD("+"),
    SUBTRACT("-"),
    MULTIPLY("*"),
    DIVIDE("/");


    public String sign;

    MathOperation(String sign) {
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

    public static MathOperation getOperationBySign(String operationString) throws MathOperationNotSupportedException {
        for (MathOperation operation :
                MathOperation.values()) {
            if (operation
                    .sign
                    .equals(operationString))
                return operation;
        }
        throw new MathOperationNotSupportedException("Математическая операция не поддерживается.");
    }

}
