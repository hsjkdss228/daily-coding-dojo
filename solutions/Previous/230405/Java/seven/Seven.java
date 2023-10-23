import java.util.Arrays;
import java.util.stream.Collectors;

public class Seven {
    public int solution1(int[] array) {
        int answer = 0;
        for (int number : array) {
            while (number > 0) {
                if (number % 10 == 7) {
                    answer += 1;
                }
                number /= 10;
            }
        }
        return answer;
    }

    public int solution2(int[] array) {
        return (int) Arrays.stream(splitByDigit(array))
            .filter(digit -> digit.equals("7"))
            .count();
    }

    public String[] splitByDigit(int[] array) {
        return Arrays.stream(array)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining())
            .split("");
    }
}
