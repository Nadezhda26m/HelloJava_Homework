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

        // получить список уникальных имен с количеством их повторений
        TreeMap<String, Integer> listNames = new TreeMap<>();
        String[] name;
        for (String item : initial) {
            name = item.split(" ");
            if (!listNames.containsKey(name[0])) {
                listNames.put(name[0], 1);
            } else {
                listNames.put(name[0], listNames.get(name[0]) + 1);
            }
        }

        // поменять ключи и значения местами
        TreeMap<Integer, ArrayList<String>> listRepeat = new TreeMap<>();
        ArrayList<String> someNames;
        Integer count;
        for (var item : listNames.entrySet()) {
            count = item.getValue();
            if (listRepeat.containsKey(count)) {
                someNames = listRepeat.get(count);
                String strNew = item.getKey();
                someNames.add(strNew);
                listRepeat.put(count, someNames);
            } else {
                someNames = new ArrayList<>();
                someNames.add(item.getKey());
                listRepeat.put(count, someNames);
            }
        }

        // Вывод повторяющихся имен с количеством повторений
        for (Integer key : listRepeat.descendingMap().keySet()) {
            for (String value : listRepeat.descendingMap().get(key)) {
                if (key != 1) {
                    System.out.printf("%d раза: %s\n", key, value);
                } // else System.out.printf("%d раз: %s\n", key, value);
            }
        }
    }
}