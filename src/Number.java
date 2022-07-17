import exceptions.DigitNotSupportedException;

import java.io.Serializable;

public interface Number extends Serializable {
    int MIN_VALUE = 1;
    int MAX_VALUE = 10;

    int toInt();

    Number calculate(Number b, MathOperation operation) throws DigitNotSupportedException;
}
