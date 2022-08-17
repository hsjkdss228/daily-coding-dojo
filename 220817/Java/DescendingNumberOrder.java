import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class DescendingNumberOrder {
  public long solution(long number) {
    List<Long> digits = new LinkedList<>();

    while (number > 0) {
      digits.add(number % 10);
      number /= 10;
    }

    digits.sort(Comparator.reverseOrder());

    long answer = 0;
    for (int i = 0; i < digits.size(); i += 1) {
      answer += digits.get(digits.size() - (i + 1)) * Math.pow(10, i);
    }

    return answer;
  }
}
