import java.util.*;

public class Deduplication {
  public int[] solution(int[] array) {
    List<Integer> deduplicatedArray = new ArrayList<>();

    int duplicatedNumber = -1;

    for (int number : array) {
      if (duplicatedNumber != number) {
        deduplicatedArray.add(number);

        duplicatedNumber = number;
      }
    }

    return deduplicatedArray.stream()
        .mapToInt(element -> element)
        .toArray();
  }

  public int[] solution2(int[] array) {
    Stack<Integer> deduplicated = new Stack<>();

    for (int number : array) {
      if (deduplicated.isEmpty() || deduplicated.peek() != number) {
        deduplicated.add(number);
      }
    }

    return deduplicated.stream()
        .mapToInt(i -> i)
        .toArray();
  }
}
