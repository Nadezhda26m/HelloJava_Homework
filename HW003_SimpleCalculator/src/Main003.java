import java.text.DecimalFormat;
import java.util.Scanner;

/*
Реализовать простой калькулятор
 */
public class Main003 {
    public static void main(String[] args) {
        Scanner iScan = new Scanner(System.in);
        boolean stop = false;
        String num1, num2, goNext;
        double number1, number2;
        int operation;
        DecimalFormat dfResult = new DecimalFormat("#.#####"); // результат
        DecimalFormat dfUser = new DecimalFormat("#.#########"); // положит.
        DecimalFormat dfNegv = new DecimalFormat("(-#.#########)"); // отрицат.

        System.out.println(">>> Простой калькулятор <<<\n");

        while (!stop) {

            System.out.print("Выберите действие:\n1 - сложение (+)\n2 - вычитание (-)\n" +
                    "3 - умножение (*)\n4 - деление (/)\nУкажите число > ");
            operation = iScan.nextInt();
            if (operation > 0 && operation < 5) {

                System.out.println("*Дробную часть указывайте через запятую");
                System.out.print("Введите первое число: ");
                number1 = iScan.nextDouble();
                System.out.print("Введите второе число: ");
                number2 = iScan.nextDouble();

                // для красивого вывода отрицательных чисел
                if (number1 < 0) {
                    num1 = dfNegv.format((number1 * (-1)));
                } else {
                    num1 = dfUser.format(number1);
                }
                if (number2 < 0) {
                    num2 = dfNegv.format((number2 * (-1)));
                } else {
                    num2 = dfUser.format(number2);
                }

                switch (operation) {
                    case 1:
                        System.out.printf("%s + %s = %s\n", num1, num2,
                                dfResult.format((number1 + number2)));
                        break;
                    case 2:
                        System.out.printf("%s - %s = %s\n", num1, num2,
                                dfResult.format((number1 - number2)));
                        break;
                    case 3:
                        System.out.printf("%s * %s = %s\n", num1, num2,
                                dfResult.format((number1 * number2)));
                        break;
                    case 4:
                        if (number2 == 0) {
                            System.out.println("Нельзя выполнить операцию (деление на 0)");
                        } else {
                            System.out.printf("%s / %s = %s\n", num1, num2,
                                    dfResult.format((number1 / number2)));
                        }
                        break;
                }

                System.out.print("\nОтправьте 1 для продолжения или " +
                        "любой другой символ для завершения\n> ");
                goNext = iScan.next();
                if (!goNext.equals("1")) {
                    stop = true;
                }
            } else {
                System.out.println("Вы ввели неверное число");
            }
        }
        iScan.close();
    }
}