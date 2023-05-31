import java.util.Arrays;
import java.util.Random;

/* Реализовать алгоритм пирамидальной сортировки (HeapSort).
            0
      1            2
   3    4       5     6
 7  8  9 10   11 12 13 14      */

public class Main016 {

    public static int size = 2;

    public static void main(String[] args) {

        int[] numbers = fillArray(size, 1, 99);
        // printHeap рассчитан на числа с 1 или 2 цифрами
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Неотсортированная куча");
        printHeap(numbers);

        heapSort(numbers);

        System.out.println("Отсортированная куча (по убыванию)");
        printHeap(numbers);
        System.out.println("Отсортированный массив чисел (по убыванию)");
        System.out.println(Arrays.toString(numbers));
    }

    public static int[] fillArray(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(minValue, maxValue + 1);
        }
        return array;
    }

    public static void heapSort(int[] array) {
        heapSort(array, size);
    }

    private static void findMinTopHeap(int[] array, int index) {
        if (index < 0) return;
        for (int i = 1; i < 3; i++) {
            // проверяем сначала слева, при необходимости меняем, затем справа
            if (index * 2 + i < size && array[index] > array[index * 2 + i]) {
                int tmp = array[index];
                array[index] = array[index * 2 + i];
                array[index * 2 + i] = tmp;
                printHeap(array);
                System.out.println();
            }
        }
        findMinTopHeap(array, --index);
    }

    private static void heapSort(int[] array, int lastIndex) {
        if (lastIndex <= 0) return;
        findMinTopHeap(array, lastIndex / 2 - 1);
        if (lastIndex == size) lastIndex--;
        int tmp = array[0];
        array[0] = array[lastIndex];
        array[lastIndex] = tmp;
        System.out.printf("new last - %d(%d)\n", tmp, lastIndex);
        printHeap(array);
        heapSort(array, --lastIndex);
    }

    public static void printHeap(int[] numbers) {
        int j = 0, degree = 0, raw = 0;
        while (Math.pow(2, raw) <= size) raw++;
        int tab = 7 * raw;
        while (j < size) {
            int a = (int) (Math.pow(2, raw - 1) * 7 - 1) / 2;
            System.out.printf("%s%2d(%2d)", " ".repeat(a - degree + 2), numbers[j], j++);
            if (raw == 1) tab = 1;
            for (int k = 1; k < Math.pow(2, degree); k++) {
                if (j == size) break;
                System.out.printf("%s%2d(%2d)", " ".repeat(tab), numbers[j], j++);
            }
            tab = a - 5;
            raw--;
            degree++;
            System.out.print("\n");
        }
    }
}
