import java.util.ArrayList;
import java.util.List;

public class Progression {
  public long[] solution1(int x, int n) {
    List<Long> list = new ArrayList<>();

    for (long i = 1; i <= n; i += 1) {
      list.add(x * i);
    }

    return list.stream()
        .mapToLong(element -> element)
        .toArray();
  }

  public long[] solution2(int x, int n) {
    long[] array = new long[n];

    for (int i = 0; i < n; i += 1) {
      array[i] = x * (long) (i + 1);
    }

    return array;
  }
}
