import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
К калькулятору из предыдущего дз добавить логирование.
*/

public class Main008 {
    public static void main(String[] args) throws Exception {
        Scanner iScan = new Scanner(System.in);
        boolean stop = false;
        String num1, num2, goNext, resOut = "";
        double number1, number2;
        int operation;
        DecimalFormat dfResult = new DecimalFormat("#.#####"); // результат

        String path = "HW008_LogSimpleCalculator/src/Logs";
        Files.createDirectories(Paths.get(path));
        Logger logger = Logging.createSimpleLogFile(path, "log.log", false);

        System.out.println(">>> Простой калькулятор <<<\n");
        logger.info("Простой калькулятор, начало работы");

        while (!stop) {

            operation = InputScan.selectOperation(logger);
            number1 = InputScan.getDoubleValue("Введите первое число: ", logger);
            number2 = InputScan.getDoubleValue("Введите второе число: ", logger);

            // для красивого вывода отрицательных чисел
            num1 = NumFormat.applyUserInputFormat(number1);
            num2 = NumFormat.applyUserInputFormat(number2);

            switch (operation) {
                case 1:
                    resOut = "%s + %s = %s".formatted(num1, num2,
                            dfResult.format((number1 + number2)));
                    break;
                case 2:
                    resOut = "%s - %s = %s".formatted(num1, num2,
                            dfResult.format((number1 - number2)));
                    break;
                case 3:
                    resOut = "%s * %s = %s".formatted(num1, num2,
                            dfResult.format((number1 * number2)));
                    break;
                case 4:
                    if (number2 == 0) {
                        System.out.println("Нельзя выполнить операцию (деление на 0)");
                        resOut = "Error";
                        logger.warning("Попытка деления на 0");
                    } else {
                        resOut = "%s / %s = %s".formatted(num1, num2,
                                dfResult.format((number1 / number2)));
                    }
                    break;
            }
            System.out.println(resOut);
            logger.log(Level.INFO, "num1: {0}; num2: {1}; result: {2}",
                    new Object[]{num1, num2, resOut});

            System.out.print("\nОтправьте 1 для продолжения или " +
                    "любой другой символ для завершения\n> ");
            goNext = iScan.next();
            if (!goNext.equals("1")) {
                stop = true;
                logger.info("Завершение работы калькулятора");
            } else {
                logger.info("Переход к следующей операции");
            }
        }
        iScan.close();
    }
}