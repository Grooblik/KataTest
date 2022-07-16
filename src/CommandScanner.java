import exceptions.DigitNotSupportedException;
import exceptions.IllegalCommandException;
import exceptions.MathOperationNotSupportedException;

public class CommandScanner {
    public static Command parseString(String command) {
        String[] operands = command.split(" ");

        if (operands.length != 3) throw new IllegalCommandException();

        String operationString = operands[1];


        MathOperation operation;
        try {
            operation = MathOperation.getOperationBySign(operationString);
        } catch (MathOperationNotSupportedException e) {
            throw new IllegalCommandException(e);
        }


        String aString = operands[0];
        String bString = operands[2];

        Digit a;
        Digit b;

        try {
            a = new ArabicDigit(aString);
            b = new ArabicDigit(bString);
        } catch (DigitNotSupportedException e) {
            throw new IllegalCommandException("Операнды команды не поддерживаются", e);
        } catch (NumberFormatException e) {
            try {
                a = RomanDigits.toDigit(aString);
                b = RomanDigits.toDigit(aString);
            } catch (DigitNotSupportedException exception) {
                throw new IllegalCommandException("Операнды команды не поддерживаются", e);
            }
        }

        return new Command(a, b, operation);
    }
}
