public class ReverseTernary {
  public int solution(int number) {
    String ternary = convertTernary(number);

    String reversedTernary = reverse(ternary);

    return convertDecimal(reversedTernary);
  }

  public String convertTernary(int number) {
    int quotient = number;
    String ternary = "";

    while (quotient > 0) {
      ternary = (quotient % 3) + ternary;

      quotient /= 3;
    }

    return ternary;
  }

  public String reverse(String ternary) {
    String reversedTernary = "";

    for (int i = 0; i < ternary.length(); i += 1) {
      reversedTernary = ternary.charAt(i) + reversedTernary;
    }

    return reversedTernary;
  }

  public int convertDecimal(String reversedTernary) {
    int result = 0;
    int index = 0;

    for (int i = reversedTernary.length() - 1; i >= 0 ; i -= 1) {
      int oneDecimalDigit = Character.getNumericValue(
          reversedTernary.charAt(i)
      );

      result += oneDecimalDigit * (int) Math.pow(3, index);

      index += 1;
    }

    return result;
  }
}
