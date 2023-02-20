import java.util.Collections;
import java.util.LinkedList;

/*
Пусть дан LinkedList с несколькими элементами. Реализуйте метод,
который вернет "перевернутый" список.
 */
public class Main012 {
    public static void main(String[] args) {
        LinkedList<Integer> myList = new LinkedList<>();
        for (int i = 0; i < 15; i++) {
            myList.add(i + 1);
        }
        System.out.println(myList);
        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]

        // Вариант 1
        Collections.reverse(myList);
        System.out.println(myList);
        // [15, 14, 13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1]

        // Вариант 2
        reverseLinkedList(myList);
        System.out.println(myList);
        // [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15]
    }

    public static void reverseLinkedList(LinkedList<Integer> list) {
        LinkedList<Integer> helpList = new LinkedList<>();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            helpList.addFirst(list.removeFirst());
        }
        list.addAll(helpList);
    }
}