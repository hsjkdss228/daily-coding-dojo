import java.util.Arrays;

public class Brackets {
  private int openBracketCount = 0;

  public boolean solution(String brackets) {
//    String[] splitBrackets = split(brackets);
//
//    if (!isEqualNumberOfBrackets(splitBrackets)) {
//      return false;
//    }
//
//    for (String bracket : splitBrackets) {
//      checkBracket(bracket);
//
//      if (moreClosingBrackets()) {
//        return false;
//      }
//    }

    for (int i = 0; i < brackets.length(); i += 1) {
      String bracket = String.valueOf(brackets.charAt(i));

      checkBracket(bracket);

      if (moreClosingBrackets()) {
        return false;
      }
    }

    if (existsBracketNotClosed()) {
      return false;
    }
    return true;
  }

  public int openBracketCount() {
    return openBracketCount;
  }

//  public String[] split(String brackets) {
//    return brackets.split("");
//  }
//
//  public boolean isEqualNumberOfBrackets(String[] splitBrackets) {
//    long openBracketsCount = Arrays.stream(splitBrackets)
//        .filter(bracket -> bracket.equals("("))
//        .count();
//
//    long closingBracketsCount = Arrays.stream(splitBrackets)
//        .filter(bracket -> bracket.equals(")"))
//        .count();
//
//    return openBracketsCount == closingBracketsCount;
//  }

  public void checkBracket(String bracket) {
    if (bracket.equals(")")) {
      decreaseOpenBracketCount();
      return;
    }
    increaseOpenBracketCount();
  }

  public void increaseOpenBracketCount() {
    openBracketCount += 1;
  }

  public void decreaseOpenBracketCount() {
    openBracketCount -= 1;
  }

  public boolean moreClosingBrackets() {
    return openBracketCount < 0;
  }

  public boolean existsBracketNotClosed() {
    return openBracketCount > 0;
  }
}
