import java.util.HashSet;
import java.util.Set;

public class AddTwoNumbers {
    public int[] solution(int[] numbers) {
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < numbers.length; i += 1) {
            for (int j = i + 1; j < numbers.length; j += 1) {
                int sum = numbers[i] + numbers[j];
                sums.add(sum);
            }
        }
        return sums.stream()
            .sorted()
            .mapToInt(value -> value)
            .toArray();
    }
}
