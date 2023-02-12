import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Random;

/*
Пусть дан произвольный список целых чисел, удалить из него четные числа
 */
public class Main010 {
    public static void main(String[] args) {
        int size = 20;
        ArrayList<Integer> numbers = fillNewArrayList(size, -9, 9);
        ArrayList<Integer> nums2 = new ArrayList<>(numbers);

        // первый вариант
        System.out.println(numbers);
        numbers.removeIf(item -> (item % 2 == 0));
        System.out.println(numbers);

        // второй вариант
        System.out.println(nums2);
        ListIterator<Integer> iter = nums2.listIterator(0);
        int num;
        int j = 0;

        while (iter.hasNext()) {
            num = iter.next();
            if (num % 2 == 0) {
                nums2.remove(j);
                iter = nums2.listIterator(j);
            } else j++;
        }
        System.out.println(nums2);
    }

    /**
     * Создает и заполняет ArrayList
     * @param count размер списка
     * @param minValue минимальное значение элементов
     * @param maxValue максимальное значение элементов
     * @return new ArrayList
     */
    public static ArrayList<Integer> fillNewArrayList(int count, int minValue, int maxValue) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            numbers.add(rand.nextInt(minValue, maxValue + 1));
        }
        return numbers;
    }
}