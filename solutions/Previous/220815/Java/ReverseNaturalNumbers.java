// 문제 URL: https://school.programmers.co.kr/learn/courses/30/lessons/12932?language=java

public class ReverseNaturalNumbers {
  public int[] solution(long givenNumber) {
    int[] reversedDigits = new int[Long.toString(givenNumber).length()];

    for (int i = 0; i < reversedDigits.length; i += 1) {
      reversedDigits[i] = (int) (givenNumber % 10);

      givenNumber /= 10;
    }

    return reversedDigits;
  }
}
