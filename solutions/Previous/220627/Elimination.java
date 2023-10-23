import java.util.Arrays;

public class Elimination {
  public int[] solution(int[] initialArray) {
    int smallestDigit = findSmallestDigit(initialArray);

    int[] answerArray = Arrays.stream(initialArray)
        .filter(eachDigit -> eachDigit > smallestDigit)
        .toArray();

    if (answerArray.length == 0) {
      answerArray = new int[]{-1};
    }

    return answerArray;
  }

  public int findSmallestDigit(int[] initialArray) {
    int smallestDigit = Integer.MAX_VALUE;

    for (int eachDigit : initialArray) {
      if (smallestDigit > eachDigit) {
        smallestDigit = eachDigit;
      }
    }

    return smallestDigit;
  }
}
