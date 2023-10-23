import java.util.Arrays;

public class PrimeNumber6 {
    public int solution(int max) {
        boolean[] numbers = new boolean[max + 1];

        Arrays.fill(numbers, true);

        numbers[1] = false;
        numbers[2] = false;

        // 2는 여기에 포함
        int answer = 1;

        for (int index = 3; index < numbers.length; index += 1) {
            if (index % 2 == 0) {
                numbers[index] = false;
                continue;
            }

            if (!numbers[index]) {
                continue;
            }

            numbers[index] = true;
            answer += 1;

            int multiplier = 2;
            int multiple = index * multiplier;
            while (multiple <= max) {
                numbers[multiple] = false;
                multiplier += 1;
                multiple = index * multiplier;
            }
        }

        return answer;
    }
}

