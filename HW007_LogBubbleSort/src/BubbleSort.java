import java.util.logging.Level;
import java.util.logging.Logger;

public class BubbleSort {
    public static void decomposeBubbleSort(int[] array, String separator) {
        int size = array.length;
        int temp;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(">>>>> ");
            ArrayOperations.printArray(array, separator);
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                System.out.printf("%d/%d - ", j, j + 1);
                ArrayOperations.printArray(array, separator);
            }
        }
        System.out.print("end:  ");
        ArrayOperations.printArray(array, separator);
    }

    public static void loggingBubbleSortIterations(int[] array, String separator, Logger log) {
        int size = array.length;
        int temp;
        log.info("Запись всех итераций пузырьковой сортировки числового массива");
        for (int i = 0; i < size - 1; i++) {
            log.log(Level.INFO, ">>>>> {0}",
                    ArrayOperations.convertArrayToString(array, separator));
            for (int j = 0; j < size - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
                log.log(Level.INFO, "{0}/{1} - {2}", new Object[]{j, j + 1,
                        ArrayOperations.convertArrayToString(array, separator)});
            }
        }
        log.log(Level.INFO, "end:  {0}",
                ArrayOperations.convertArrayToString(array, separator));
    }
}
