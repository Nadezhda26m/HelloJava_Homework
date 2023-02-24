import java.util.ArrayList;
import java.util.Collections;

/* Реализовать алгоритм пирамидальной сортировки (HeapSort). */
/*          0
      1            2
   3    4       5     6
 7  8  9 10   11 12 13 14   */

// в разработке

public class Main016 {
    public static void main(String[] args) {

        String num = "34 76 95 15 38 90 4 18";
        String[] nums = num.split(" ");
        size = nums.length;
        ArrayList<Integer> numbers = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            numbers.add(Integer.parseInt(nums[i]));
        }
        System.out.println(num);
        System.out.println("Неотсортированная куча");
        printHeap(numbers);

        // Collections.swap(numbers, i, j);
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
}