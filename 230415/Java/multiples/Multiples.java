import java.util.Arrays;
import java.util.Objects;

public class Multiples {
    public int[] solution(int number, int[] numbers) {
        return Arrays.stream(numbers)
            .boxed()
            .map(element -> element % number == 0 ? element : null)
            .filter(Objects::nonNull)
            .mapToInt(multiple -> multiple)
            .toArray();
    }
}
