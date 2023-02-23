/*
Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
что 1 человек может иметь несколько телефонов.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main014 {

    public static void main(String[] args) {
        // "Ф-И-О-дд.мм.гггг" : ["тел1", "тел2"]
        Map<String, ArrayList<String>> phBook = new HashMap<>();
        String key;
        ArrayList<String> phones = new ArrayList<>(3);

        String stop = "";
        String newPhone;
        boolean addPhone;
        while (stop.equals("")) {
            key = enterUserKey();

            addPhone = true;

            if (phBook.containsKey(key)) {
                phones = phBook.get(key); // добавление нового номера к существующему контакту
            } else {
                phones.clear(); // добавление номеров нового контакта
            }
            while (addPhone) {
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

            phBook.put(key, phones);
            System.out.println("Продолжить заполнение телефонной книги? ");
            stop = scan.nextLine();
            printPhonebook(phBook);
        }
        printPhonebook(phBook);
    }

    public static String[] userEnter = getUserEnter();
    public static Scanner scan = new Scanner(System.in);

    public static String enterUserKey() {
        StringBuilder result = new StringBuilder();
        String newKey;
        for (int i = 0; i < 3; i++) {
            System.out.print(userEnter[i]);
            newKey = scan.nextLine();
            result.append(newKey).append("-");
        }
        System.out.print(userEnter[3]);
        newKey = scan.nextLine();
        result.append(newKey);
        return result.toString();
    }

    public static String[] getUserEnter() {
        String[] userEnter = new String[4];
        userEnter[0] = "Введите фамилию: ";
        userEnter[1] = "Введите имя: ";
        userEnter[2] = "Введите отчество: ";
        userEnter[3] = "Введите дату рождения в формате дд.мм.гггг: ";
        return userEnter;
    }

    public static void printPhonebook(Map<String, ArrayList<String>> phBook) {
        for (var item : phBook.entrySet()) {
            System.out.printf("%s : %s\n", printKey(item.getKey()),
                    printValue(item.getValue(), ", "));
        }
    }

    public static String printKey(String str) {
        StringBuilder result = new StringBuilder();
        String[] array = str.split("-");
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