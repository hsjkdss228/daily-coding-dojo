public class ConvertTernary2 {
  public int solution(int number) {
    //10진법 수를 3진법으로 변환
    int quotient = number;
    String ternary = "";

    while (quotient != 0) {
      ternary = (quotient % 3) + ternary;
      quotient /= 3;
    }

    //3진법 수를 앞뒤 반전
    String reversedTernary = "";

    for (int i = ternary.length() - 1; i >= 0; i -= 1) {
      reversedTernary = reversedTernary + ternary.charAt(i);
    }

    //3진법 수를 10진법으로 표현
    int answer = 0;

    for (int i = reversedTernary.length() - 1; i >= 0; i -= 1) {
      int digit = Character.getNumericValue(reversedTernary.charAt(i));
//      System.out.println("digit = " + digit);

      digit *= (int) Math.pow(3, reversedTernary.length() - (i + 1));
//      System.out.println("Math.pow(3, reversedTernary.length() - (i + 1)) = " + (int) Math.pow(3, reversedTernary.length() - (i + 1)));
//      System.out.println("after digit = " + digit);

      answer += digit;
    }

    return answer;
  }
}
