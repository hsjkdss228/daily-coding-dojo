import java.util.ArrayList;
import java.util.List;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        List<Integer> accumulated = new ArrayList<>();
        accumulated.add(numbers[0]);
        accumulated.add(numbers[0] * -1);

        for (int i = 1; i < numbers.length; i += 1) {
            int number = numbers[i];
            List<Integer> replacement = new ArrayList<>();
            accumulated.forEach(interim -> {
                replacement.add(interim + number);
                replacement.add(interim - number);
            });
            accumulated = replacement;
        }

        return (int) accumulated.stream()
            .filter(result -> result.equals(target))
            .count();
    }
}
