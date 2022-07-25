import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class NotExistingNumber {
  private int result;

  public int solution(int[] numbers) {
    int sumOf0To10 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9;

    int sumOfNumbers
        = Arrays.stream(numbers)
        .sum();

    return sumOf0To10 - sumOfNumbers;
  }

  public int solution2(int[] numbers) {
    Map<Integer, Boolean> numbersWithExistingCheckFlag = new HashMap<>();

    for (int i = 0; i < 10; i += 1) {
      numbersWithExistingCheckFlag.put(i, true);
    }
    //찜찜하다 Map에 초기값을 넣어주는데 for문을 쓴 것...
    //stream 쓰는 식으로 바꾸고 싶다... 아...

    int[] sortedNumbers
        = Arrays.stream(numbers)
        .sorted()
        .toArray();

    Arrays.stream(sortedNumbers)
        .forEach(i -> {
          if (numbersWithExistingCheckFlag.containsKey(i)) {
            numbersWithExistingCheckFlag.replace(i, false);
          }
        });

    result = 0;

    numbersWithExistingCheckFlag.forEach((i, isNotExistingNumber) -> {
      if (isNotExistingNumber) {
        result += i;
      }
    });

    return result;
  }
}
