import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Divisible {
  public int[] solution(int[] naturalNumbers, int divisor) {
    List<Integer> answers = new ArrayList<>();

    Arrays.stream(naturalNumbers)
        .sorted()
        .forEachOrdered(i -> {
          if (i % divisor == 0) {
            answers.add(i);
          }
        });

    if (answers.size() == 0) {
      answers.add(-1);
    }

    return answers.stream()
        .mapToInt(i -> i)
        .toArray();
  }
}
