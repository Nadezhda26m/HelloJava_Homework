/*
Вывести все простые числа от 1 до 1000
 */
public class Main002 {
    public static void main(String[] args) {
        int num = 1;
        int numMax = 100; // 1000

        // 1. вывод в столбик
        System.out.println("В столбик:");
        while (num <= numMax){
            System.out.println(num++);
        }

        // 2. вывод в строчку по countMax элементов
        int countMax = 20;
        System.out.printf("В строчку по %d:\n", countMax);
        num = 1;
        while (num < numMax){
            System.out.printf("%d, ", num);
            if (num % countMax == 0){
                System.out.println();
            }
            num++;
        }
        System.out.println(num);
    }
}