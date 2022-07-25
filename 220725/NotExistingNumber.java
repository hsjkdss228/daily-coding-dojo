import java.util.Arrays;

public class NotExistingNumber {
  public int solution(int[] numbers) {
    int sumOf0To10 = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9;

    int sumOfNumbers = Arrays.stream(numbers).sum();

    return sumOf0To10 - sumOfNumbers;
  }


}
