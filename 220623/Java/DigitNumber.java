import java.util.ArrayList;
import java.util.List;

public class DigitNumber {
  public int solution(int number) {
    int quotient = number;
    int result = 0;

    while (quotient > 0) {
      result += quotient % 10;
      quotient /= 10;
    }

    return result;
  }

  public int solution2(int number) {
    String stringNumber = Integer.toString(number);
    int result = 0;

    for (int i = 0; i < stringNumber.length(); i += 1) {
      char digit = stringNumber.charAt(i);
      result += Character.getNumericValue(digit);
    }

    return result;
  }

  public int solution3(int number) {
    List<Integer> digits = new ArrayList<>();

    while (number >= 1) {
      digits.add(number % 10);
      number /= 10;
    }

    return digits.stream()
        .mapToInt(i -> i)
        .sum();
  }
}
