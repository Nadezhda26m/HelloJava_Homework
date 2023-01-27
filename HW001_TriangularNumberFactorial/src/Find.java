public class Find {
    public static int findTriangularNumber(int number) {
        return number * (number + 1) / 2;
    }

    public static double findFactorial(double number) {
        if (number == 0 || number == 1) {
            return 1;
        } else {
            return number * findFactorial(number - 1);
        }
    }
}
