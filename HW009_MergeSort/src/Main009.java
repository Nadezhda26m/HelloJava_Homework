import java.util.Random;
import static java.lang.System.arraycopy;

/*
Реализовать алгоритм сортировки слиянием
 */
public class Main009 {
    public static void main(String[] args) {
        int size = 11;
        int[] numbers = createAndFillArray(size, -9, 9);
        printArray(numbers);
        mergeSortArray(numbers);
        printArray(numbers);
    }

    public static int[] createAndFillArray(int size, int minValue, int maxValue) {
        Random rand = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = rand.nextInt(minValue, maxValue + 1);
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static int[] sortPartArray(int[] array, int step, int sizeHelp,
                                      int startPos, int stopPos, int rightStop) {
        int portion = step * 2;
        int[] helpArr = new int[sizeHelp];
        int left, right;
        int helpPos = 0;
        for (int i = startPos; i < stopPos; i += portion) {
            left = 0;
            right = step;
            while (left < step || right < rightStop) {
                if (left < step && right < rightStop) {
                    if (array[i + left] < array[i + right]) {
                        helpArr[helpPos++] = array[i + left++];
                    } else {
                        helpArr[helpPos++] = array[i + right++];
                    }
                } else if (left < step) {
                    helpArr[helpPos++] = array[i + left++];
                } else {
                    helpArr[helpPos++] = array[i + right++];
                }
                // printArray(helpArr);
            }
        }
        return helpArr;
    }

    public static void mergeSortArray(int[] array) {
        mergeSortArray(array, 1);
    }

    public static int[] mergeSortArray(int[] array, int step) {
        int size = array.length;
        if (step >= size) {
            return array;
        } else {
            int sizeRight = size % (step * 2);
            int sizeLeft = size - sizeRight;
            int[] helpLeft = sortPartArray(array, step, sizeLeft,
                    0, sizeLeft, step * 2);
            arraycopy(helpLeft, 0, array, 0, sizeLeft);
            if (sizeRight > step) {
                int[] helpRight = sortPartArray(array, step, sizeRight,
                        sizeLeft, size, sizeRight);
                arraycopy(helpRight, 0, array, sizeLeft, sizeRight);
            }
            // printArray(array);
            return mergeSortArray(array, step * 2);
        }
    }
}