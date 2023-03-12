import store.Filter;
import store.SuperFilter;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FilterValues {

    public static int chooseKey(Filter filter) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите номер ключа: ");
        int key = scan.nextInt();
        if (filter.getFilter().containsKey(key)) return key;
        else {
            System.out.println("Неверный номер");
            return chooseKey(filter);
        }
    }

    public static int chooseMinValue() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите минимальное значение: ");
        int minValue = scan.nextInt();
        if (minValue < 0) {
            System.out.println("Неверные данные");
            return chooseMinValue();
        }
        return minValue;
    }

    public static Map<Integer, Integer> setMultiselect(SuperFilter superF) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, Integer> choose = new TreeMap<>();
        String next = "";
        int key, minValue, sizeFit;
        while (next.equals("")) {
            System.out.println(superF.showFilter());
            key = chooseKey(superF);
            // if (choose.containsKey(key)) { // filterSet.add()
            //     System.out.println("Изменение заданного минимального значения");
            // }
            if (!choose.containsKey(key)) {
                minValue = chooseMinValue();
                choose.put(key, minValue);

                System.out.println(choose);
                sizeFit = superF.filterMultiselect(key, minValue);
                if (sizeFit == 0 || superF.getFilter().size() == choose.size()) break;
                System.out.println("Чтобы добавить новый параметр, нажмите Enter");
                System.out.println("Чтобы закончить, отправьте любой символ");
                next = scan.nextLine();
            } else {
                System.out.println("Данный параметр уже задан");
            }
        }
        return choose;
    }
}
