import java.util.ArrayList;
import java.util.List;

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
}
