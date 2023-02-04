import java.util.logging.Logger;

/*
Реализуйте алгоритм сортировки пузырьком числового массива,
результат после каждой итерации запишите в лог-файл.
 */
/*
Алгоритм
1. Создать и заполнить массив целых чисел
2. Создать экземпляр класса Logger
3. Создать и добавить FileHandler
 */
public class Main007 {
    public static void main(String[] args) throws Exception {
        int size = 8;
        int[] nums = ArrayOperations.createArray(size);
        ArrayOperations.fillArrayRandom(nums, 1, 70);
        String separator = ", ";
        // ArrayOperations.printArray(nums, separator);

        String path = "HW007_LogBubbleSort/src/Logs/";
        Logger logger = Logging.createSimpleLogFile(path, "log.log", false);
        logger.info("Запись всех итераций пузырьковой сортировки числового массива");

        // BubbleSort.decomposeBubbleSort(nums, separator); // вывод в консоль
        BubbleSort.loggingBubbleSortIterations(nums, separator, logger); // запись в файл
    }
}