public class Average {
    public double solution(int[] array) {
        double quotient = 0;

        for (double element : array) {
            quotient += element;
        }

        return quotient / array.length;
    }
}
