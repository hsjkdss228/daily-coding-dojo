import java.util.Arrays;

public class AddingDigits {
    public int solution(int number) {
        String stringified = Integer.toString(number);
        String[] digits = stringified.split("");
        return Arrays.stream(digits)
            .map(Integer::parseInt)
            .reduce(0, Integer::sum);
    }
}
