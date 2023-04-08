public class PerfectSquare {
    public boolean solution(int number) {
        int base = 1;
        int squared = (int) Math.pow(base, 2);
        while (squared <= number) {
            if (squared == number) {
                return true;
            }
            base += 1;
            squared = (int) Math.pow(base, 2);
        }
        return false;
    }

    public boolean solution2(int number) {
        return Math.sqrt(number) - (int) Math.sqrt(number) == 0;
    }
}
