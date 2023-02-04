import java.util.Scanner;
import java.util.logging.Logger;

public class InputScan {
    // получить номер операции, от 1 до 4 вкл
    public static int selectOperation(Logger logger) {
        String operation = "";
        Scanner iScan = new Scanner(System.in);
        boolean fit = false;
        while (!fit) {
            System.out.print("Выберите действие:\n1 - сложение (+)\n2 - вычитание (-)\n" +
                    "3 - умножение (*)\n4 - деление (/)\nУкажите число > ");
            operation = iScan.next();
            if ((operation.length() == 1) && (operation.charAt(0) > '0')
                    && (operation.charAt(0) < '5')) {
                fit = true;
                logger.info("Код операции - %s".formatted(operation));
            } else {
                System.out.println("Вы ввели неверное значение, повторите ввод");
                logger.warning("Ошибка ввода операции, получено: \"%s\"".formatted(operation));
            }
        }
        return Integer.parseInt(operation);
    }

    // получить из консоли вещественное число, указав в сообщении приглашение к вводу
    public static double getDoubleValue(String message, Logger logger) {
        Scanner iScan = new Scanner(System.in);
        System.out.println("*Дробную часть указывайте через запятую");
        while (true) {
            System.out.print(message);
            String number = iScan.next();
            if (NumFormat.isDouble(number)) {
                logger.info("Введено число: %s".formatted(number));
                return Double.parseDouble(number);
            } else {
                System.out.println("Вы ввели неверное значение, повторите ввод");
                logger.warning("Ошибка ввода числа, получено: \"%s\"".formatted(number));
            }
        }
    }
}
