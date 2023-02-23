/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
что 1 человек может иметь несколько телефонов.
 */

import java.util.*;

public class Main014 {

    public static void main(String[] args) {
        // ["Ф", "И", "О", "дд.мм.гггг"] : ["тел1", "тел2"]
        Map<String[], ArrayList<String>> phBook = new HashMap<>();
        String[] key;
        ArrayList<String> phones = new ArrayList<>(3);

        String stop = "";
        String newPhone;
        boolean addPhone;
        while (stop.equals("")) {
            key = enterUserKey();

            addPhone = true;
            System.out.println("ключи");
            printPhonebook(phBook);

            // if (phBook.containsKey(key)) {
            if (checkContainsKey(key, phBook)) {
                System.out.println("Контакт найден");
                phones = phBook.get(key); // добавление нового номера к существующему контакту
                System.out.println(phones);
            } else {
                System.out.println("Контакт не найден");
                System.out.println(phones);
                phones.clear(); // добавление номеров нового контакта
                System.out.println(phones);
            }
            while (addPhone) {
                printKey(key);
                System.out.print("Введите номер телефона: ");
                newPhone = scan.nextLine();
                if (phones.contains(newPhone)) {
                    System.out.println("Данный номер уже зарегистрирован");
                    System.out.println("Отправьте 1, чтобы завершить добавление, " +
                            "или нажмите Enter, чтобы ввести другой номер ");

                } else {
                    System.out.println("Номер был добавлен");
                    System.out.println("Отправьте 1, чтобы завершить добавление, " +
                            "или нажмите Enter, чтобы ввести следующий номер ");
                    phones.add(newPhone);
                }
                if (!scan.nextLine().equals("")) {
                    addPhone = false;
                }
            }
            // key[0] = "Петрова";
            // key[1] = "Светлана";
            // key[2] = "Ивановна";
            // key[3] = "23.02.1987";
            // phones.add("+71234567890");
            // phones.add("+71234767890");
            phBook.put(key, phones);
            System.out.println("Продолжить заполнение телефонной книги? ");
            stop = scan.nextLine();
            printPhonebook(phBook);
        }
        printPhonebook(phBook);

    }

    public static String[] userEnter = getUserEnter();
    public static Scanner scan = new Scanner(System.in);

    public static boolean checkContainsKey(String[] key,
                                            Map<String[], ArrayList<String>> phBook) {
        for (var item : phBook.keySet()) {
            if (Arrays.equals(key, item)) {
                return true;
            }
        }
        return false;
    }

    public static String[] enterUserKey() {
        String[] key = new String[4];
        String newKey;
        Scanner scan = new Scanner(System.in);

        for (int i = 0; i < 4; i++) {
            System.out.print(userEnter[i]);
            newKey = scan.nextLine();
            key[i] = newKey;
        }
        return key;
    }

    public static String[] getUserEnter() {
        String[] userEnter = new String[4];
        userEnter[0] = "Введите фамилию: ";
        userEnter[1] = "Введите имя: ";
        userEnter[2] = "Введите отчество: ";
        userEnter[3] = "Введите дату рождения в формате дд.мм.гггг: ";
        return userEnter;
    }

    public static void printPhonebook(Map<String[], ArrayList<String>> phBook) {
        for (var item : phBook.entrySet()) {
            System.out.printf("%s : %s\n", printKey(item.getKey()),
                    printValue(item.getValue(), ", "));
        }
    }

    public static String printKey(String[] array) {
        StringBuilder result = new StringBuilder();
        result.append(array[0]).append(" ");
        result.append(array[1]).append(" ");
        result.append(array[2]).append(", ");
        result.append(array[3]);
        return result.toString();
    }

    public static String printValue(ArrayList<String> strings, String separator) {
        StringBuilder result = new StringBuilder();
        for (String item : strings) {
            result.append(item).append(separator);
        }
        result.delete(result.length() - separator.length(), result.length());
        return result.toString();
    }
}