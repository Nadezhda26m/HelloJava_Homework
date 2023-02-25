import java.util.ArrayList;
import java.util.Collections;

/* Реализовать алгоритм пирамидальной сортировки (HeapSort).
            0
      1            2
   3    4       5     6
 7  8  9 10   11 12 13 14      */

public class Main016 {
    public static void main(String[] args) {

        // String num = "34 76 95 15 38 90 4 18";
        // String num = "34 76 95 15 38 90 4";
        String num = "34 14 76 37 95 2 15 38 18 90 4 18";
        String[] nums = num.split(" ");
        size = nums.length;
        ArrayList<Integer> numbers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            numbers.add(Integer.parseInt(nums[i]));
        }
        System.out.println("Исходный массив");
        System.out.printf("[%s]\n", num);
        System.out.println("Неотсортированная куча");
        printHeap(numbers);
        // ставим минимальное значение на вершину кучи
        System.out.println("Первое просеивание");
        findMinTopHeap(numbers, size / 2 - 1);
        printHeap(numbers);
        System.out.println("Отсортированная куча (по убыванию)");
        heapSort(numbers, size - 1);
        printHeap(numbers);

        System.out.println("Отсортированный массив чисел (по убыванию)");
        System.out.println(numbers);
    }

    public static int size;

    public static void printHeap(ArrayList<Integer> numbers) {
        int j = 0, degree = 0;
        while (j < size) {
            for (int k = 0; k < Math.pow(2, degree); k++) {
                System.out.printf("%3d(%2d) ", numbers.get(j), j++);
                if (j == size) break;
            }
            degree++;
            System.out.print("\n");
        }
    }

    public static void findMinTopHeap(ArrayList<Integer> numbers, int index) {
        if (index < 0) return;
        for (int i = 1; i < 3; i++) {
            if (index * 2 + i < size && numbers.get(index) > numbers.get(index * 2 + i)) {
                Collections.swap(numbers, index, index * 2 + i);
            }
        }
        findMinTopHeap(numbers, --index);
    }

    public static void heapSort(ArrayList<Integer> heap, int lastIndex) {
        if (lastIndex == 0) return;
        Collections.swap(heap, 0, lastIndex);
        findMinTopHeap(heap, --lastIndex / 2 - 1);
        heapSort(heap, lastIndex);
    }
}