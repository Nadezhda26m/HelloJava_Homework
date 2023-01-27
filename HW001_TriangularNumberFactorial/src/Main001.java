import java.text.DecimalFormat;
import java.util.Scanner;

/*
Вычислить n-ое треугольного число (сумма чисел от 1 до n),
n! (произведение чисел от 1 до n)
 */
public class Main001 {
    public static void main(String[] args) {

        System.out.println("Данная программа высчитывает n-ое треугольного число и n!");

        Scanner iScan = new Scanner(System.in);
        boolean flag = false;
        int number = 0;

        while (!flag) {
            System.out.print("Введите целое положительное число (n): ");
            number = iScan.nextInt();
            if (number >= 0) {
                flag = true;
            } else {
                System.out.println("Вы ввели неверное число");
            }
        }

        // треугольное число
        int triangNum = Find.findTriangularNumber(number);
        System.out.printf("%d-е треугольное число = %d\n", number, triangNum);

        // факториал
        double fact = Find.findFactorial(number);
        DecimalFormat df = new DecimalFormat();
        if (number <= 21) {
            System.out.printf("%d! = %s\n", number, df.format(fact));
        } else {
            System.out.printf("%d!(*) = ~ %s\n", number, df.format(fact));
            System.out.println("* округленное значение");
        }
    }
}