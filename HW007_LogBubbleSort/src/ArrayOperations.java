import java.util.Random;

public class ArrayOperations {
    public static int[] createArray(int size) {
        return new int[size];
    }

    public static void fillArrayRandom(int[] array, int minValue, int maxValue) {
        int size = array.length;
        if (maxValue < minValue) {
            int temp = minValue;
            minValue = maxValue;
            maxValue = temp;
        }
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(minValue, maxValue);
        }
    }

    public static void printArray(int[] array, String separator) {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            System.out.printf("%d%s", array[i], separator);
        }
        System.out.println(array[size - 1]);
    }

    public static String convertArrayToString(int[] arr, String separator) {
        int size = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size - 1; i++) {
            sb.append(arr[i]).append(separator);
        }
        sb.append(arr[size - 1]);
        return sb.toString();
    }
}
