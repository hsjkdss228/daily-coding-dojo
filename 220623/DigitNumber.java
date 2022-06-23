package solutions;

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
}
