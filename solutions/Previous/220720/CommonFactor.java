public class CommonFactor {
  public int[] solution(int number1, int number2) {
    int[] answer = new int[2];

    int biggerOne = Math.max(number1, number2);

    //최대공약수
    for (int i = 1; i <= biggerOne; i += 1) {
      if (i > number1 || i > number2) {
        break;
      }

      if (number1 % i == 0 && number2 % i == 0 && answer[0] < i) {
        answer[0] = i;
      }
    }

    //최소공배수
    int multipleOfNumber1 = number1;
    int multipleOfNumber2 = number2;

    while (!(multipleOfNumber1 == multipleOfNumber2)) {
      if (multipleOfNumber1 > multipleOfNumber2) {
        multipleOfNumber2 += number2;
      }

      if (multipleOfNumber1 < multipleOfNumber2) {
        multipleOfNumber1 += number1;
      }
    }

    answer[1] = multipleOfNumber1;

    return answer;
  }
}
