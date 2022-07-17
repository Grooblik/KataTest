import exceptions.DigitNotSupportedException;
import exceptions.IllegalCommandException;
import exceptions.MathOperationNotSupportedException;

public class CommandScanner {
    public static Command parseString(String command) throws IllegalCommandException {
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

        Number a;
        Number b;

        try {
            a = new ArabicNumber(aString);
            b = new ArabicNumber(bString);
        } catch (DigitNotSupportedException e) {
            throw new IllegalCommandException("Операнды команды не поддерживаются", e);
        } catch (NumberFormatException e) {
            try {
                a = new RomanNumber(aString);
                b = new RomanNumber(bString);
            } catch (IllegalArgumentException | DigitNotSupportedException exception) {
                throw new IllegalCommandException("Операнды команды не поддерживаются", e);
            }
        }

        return new Command(a, b, operation);
    }
}
