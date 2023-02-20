import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Реализуйте очередь с помощью LinkedList со следующими методами:
enqueue() - помещает элемент в конец очереди,
dequeue() - возвращает первый элемент из очереди и удаляет его,
first() - возвращает первый элемент из очереди, не удаляя.
*/
public class Main013 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // очередь с LinkedList
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 15; i++) {
            list.add(i + 1);
        }
        System.out.println(list + "\n");

        String stop = "";
        while (stop.equals("")) {
            System.out.printf("Первый в очереди - %d\n", first(list));
            enqueue(dequeue(list), list);
            System.out.println(list);
            System.out.println("Нажмите Enter для продолжения ");
            stop = scan.nextLine();
        }

        // Очередь с Queue
        stop = "";
        Queue<Integer> listQ = new LinkedList<>();

        for (int i = 0; i < 15; i++) {
            listQ.add(i + 1);
        }
        System.out.println(listQ);
        System.out.println("\n\nНовая очередь");

        while (stop.equals("")) {
            System.out.printf("Первый в очереди - %d\n", listQ.peek());
            listQ.add(listQ.poll());
            System.out.println(listQ);
            System.out.println("Нажмите Enter для продолжения ");
            stop = scan.nextLine();
        }

        scan.close();
    }

    /**
     * Возвращает первый элемент из очереди и удаляет его
     */
    public static Integer dequeue(LinkedList<Integer> list) {
        return list.removeFirst();
    }

    /**
     * Помещает элемент в конец очереди
     */
    public static void enqueue(Integer item, LinkedList<Integer> list) {
        list.addLast(item);
    }

    /**
     * Возвращает первый элемент из очереди, не удаляя
     */
    public static Integer first(LinkedList<Integer> list) {
        return list.getFirst();
    }
}