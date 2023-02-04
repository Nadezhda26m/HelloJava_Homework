import java.text.DecimalFormat;

public class NumFormat {
    public static DecimalFormat dfPosv = new DecimalFormat("#.#########"); // положит.
    public static DecimalFormat dfNegv = new DecimalFormat("(-#.#########)"); // отрицат.

    // применить форматирование по образцу к вещественным числам
    public static String applyUserInputFormat(double number) {
        if (number < 0) {
            return dfNegv.format((number * (-1)));
        } else {
            return dfPosv.format(number);
        }
    }

    // проверить, является ли строка вещественным числом
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
