import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/* Реализовать алгоритм пирамидальной сортировки (HeapSort).
            0
      1            2
   3    4       5     6
 7  8  9 10   11 12 13 14      */

public class Main016 {

    public static int size = 12;

    public static void main(String[] args) {

        int[] numbers = fillArray(size, 1, 99);
        // printHeap рассчитан на числа с 1 или 2 цифрами
        System.out.println("Исходный массив");
        System.out.println(Arrays.toString(numbers));
        System.out.println("Неотсортированная куча");
        printHeap(numbers);

        AtomicInteger cnt = new AtomicInteger();
        heapSort(numbers, cnt);

        System.out.println("Отсортированная куча (по убыванию)");
        printHeap(numbers);
        System.out.println("Отсортированный массив чисел (по убыванию)");
        System.out.println(Arrays.toString(numbers));
        System.out.println("counter = " + cnt);
    }

    public static int[] fillArray(int size, int minValue, int maxValue) {
        int[] array = new int[size];
        Random rand = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(minValue, maxValue + 1);
        }
        return array;
    }

    public static void heapSort(int[] array, AtomicInteger cnt) {
        heapSort(array, size, cnt);
    }

    private static void findMinTopHeap(int[] array, int indexNode, AtomicInteger cnt) {
        if (indexNode < 0) return;
        cnt.incrementAndGet();
        int smaller = indexNode;
        if (indexNode * 2 + 1 < size && array[smaller] > array[indexNode * 2 + 1])
            smaller = indexNode * 2 + 1;
        if (indexNode * 2 + 2 < size && array[smaller] > array[indexNode * 2 + 2])
            smaller = indexNode * 2 + 2;
        if (smaller != indexNode) {
            int tmp = array[indexNode];
            array[indexNode] = array[smaller];
            array[smaller] = tmp;
            printHeap(array);
            System.out.println();
            cnt.incrementAndGet();
        }
        findMinTopHeap(array, --indexNode, cnt);
    }



    private static void heapSort(int[] array, int lastIndex, AtomicInteger cnt) {
        if (lastIndex <= 0) return;
        findMinTopHeap(array, lastIndex / 2 - 1, cnt);
        if (lastIndex == size) lastIndex--;
        int tmp = array[0];
        array[0] = array[lastIndex];
        array[lastIndex] = tmp;
        cnt.incrementAndGet();
        System.out.printf("new last - %d(%d)\n", tmp, lastIndex);
        printHeap(array);
        System.out.println();
        heapSort(array, --lastIndex, cnt);
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
