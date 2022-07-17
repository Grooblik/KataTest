import exceptions.DigitNotSupportedException;
import exceptions.IllegalCommandException;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, KataAcademy!");
        System.out.println("Поддерживаются числа от " + Number.MIN_VALUE + " до " + Number.MAX_VALUE);
        System.out.println("Форматы чисел: арабские или римские");
        System.out.println("Поддерживаемые операции: " + Arrays.toString(MathOperation.values()));
        System.out.println("Для подсчета, введите первое число, операнд и второе число.");
        System.out.println("Для выхода введите 'exit'");

        Scanner in = new Scanner(System.in);

        while (true) {
            String commandString = in.nextLine();
            if (commandString.equals("exit")) break;

            try {
                Command command = CommandScanner.parseString(commandString);

                Number res = command.calculate();

                System.out.println(res);

            } catch (IllegalCommandException | DigitNotSupportedException e) {
                System.out.println(e.getLocalizedMessage());
                System.out.println("Попробуйте еще раз.");
            }

        }


        System.out.println("Cпасибо за использование калькулятора! До свидания.");


    }
}
