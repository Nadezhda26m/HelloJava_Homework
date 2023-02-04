import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;

/*
Реализуйте алгоритм сортировки пузырьком числового массива,
результат после каждой итерации запишите в лог-файл.

Алгоритм
1. Создать и заполнить массив целых чисел
2. Создать экземпляр класса Logger
3. Создать и добавить FileHandler
4. Определить формат записи логов
5. Применить к массиву сортировку пузырьком, после каждой итерации (сравнение пар)
записать в журнал полученный массив
 */
public class Main007 {
    public static void main(String[] args) throws Exception {
        int size = 8;
        int[] nums = ArrayOperations.createArray(size);
        ArrayOperations.fillArrayRandom(nums, 1, 70);
        String separator = ", ";
        // ArrayOperations.printArray(nums, separator);

        String path = "HW007_LogBubbleSort/src/Logs";
        Files.createDirectories(Paths.get(path));
        Logger logger = Logging.createSimpleLogFile(path, "log.log", false);

        // BubbleSort.decomposeBubbleSort(nums, separator); // вывод в консоль
        BubbleSort.loggingBubbleSortIterations(nums, separator, logger); // запись в файл
    }
}
