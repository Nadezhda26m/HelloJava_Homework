import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/*
Задан целочисленный список ArrayList. Найти минимальное, максимальное
и среднее из этого списка.
 */
public class Main011 {
    public static DecimalFormat df = new DecimalFormat("#.########");
    public static void main(String[] args) {
        int size = 15;
        ArrayList<Integer> numbers = fillNewArrayList(size, -99, 99);
        System.out.println(numbers);
        System.out.printf("maxValue = %d\n", Collections.max(numbers));
        System.out.printf("minValue = %d\n", Collections.min(numbers));

        double sum = 0;
        for (Integer item : numbers) {
            sum += item;
        }
        System.out.printf("AVG1 = %s\n", df.format(sum / size));

        // через массив
        sum = 0;
        Integer[] nums = numbers.toArray(new Integer[0]);
        for (int i = 0; i < size; i++) {
            sum += nums[i];
        }
        System.out.printf("AVG2 = %s\n", df.format(sum / size));
    }

    public static ArrayList<Integer> fillNewArrayList(int count, int minValue, int maxValue) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            numbers.add(rand.nextInt(minValue, maxValue + 1));
        }
        return numbers;
    }
}