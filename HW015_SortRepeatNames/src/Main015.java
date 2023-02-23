/* Пусть дан список сотрудников:
Иван Иванов
Светлана Петрова
Кристина Белова
Анна Мусина
Анна Крутова
Иван Юрин
Петр Лыков
Павел Чернов
Петр Чернышов
Мария Федорова
Марина Светлова
Мария Савина
Мария Рыкова
Марина Лугова
Анна Владимирова
Иван Мечников
Петр Петин
Иван Ежов
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности. */

import java.util.*;

public class Main015 {
    public static void main(String[] args) {
        String str = "Иван Иванов\n" +
                "Светлана Петрова\n" +
                "Кристина Белова\n" +
                "Анна Мусина\n" +
                "Анна Крутова\n" +
                "Иван Юрин\n" +
                "Петр Лыков\n" +
                "Павел Чернов\n" +
                "Петр Чернышов\n" +
                "Мария Федорова\n" +
                "Марина Светлова\n" +
                "Мария Савина\n" +
                "Мария Рыкова\n" +
                "Марина Лугова\n" +
                "Анна Владимирова\n" +
                "Иван Мечников\n" +
                "Петр Петин\n" +
                "Иван Ежов";
        String[] initial = str.split("\n");

        HashMap<String, Integer> listNames = new HashMap<>();
        String[] name;
        for (String item : initial) {
            name = item.split(" ");
            if (!listNames.containsKey(name[0])) {
                listNames.put(name[0], 1);
            } else {
                listNames.put(name[0], listNames.get(name[0]) + 1);
            }
        }

        TreeMap<Integer, ArrayList<String>> listRepeat = new TreeMap<>();
        Integer count;
        ArrayList<String> someNames = new ArrayList<>();
        for (var item : listNames.entrySet()) {
            count = item.getValue();
            System.out.println(count);
            someNames.clear();
            if (listRepeat.containsKey(count)) { // false
                someNames = listRepeat.get(count);
                System.out.println(someNames);
                String strNew = item.getKey();
                someNames.add(strNew);
                System.out.println(someNames);
            } else {
                someNames.add(item.getKey());
                System.out.println("______");
                System.out.println(someNames);
            }
            listRepeat.put(count, someNames);
        }


        System.out.println(listNames);
        System.out.println(listRepeat);
        // {Анна=3, Иван=4, Кристина=1, Марина=2, Мария=3, Павел=1, Петр=3, Светлана=1}
        System.out.println(listNames.values());

    }
}