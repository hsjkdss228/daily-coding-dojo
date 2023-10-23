public class TheLeastCommonMultiple {
  public int calculateTheLeastCommonMultiple(int number1, int number2) {
    int multipleOfNumber1 = number1;
    int multipleOfNumber2 = number2;

    while (multipleOfNumber1 != multipleOfNumber2) {
      if (multipleOfNumber1 < multipleOfNumber2) {
        multipleOfNumber1 += number1;
        continue;
      }

      multipleOfNumber2 += number2;
    }

    return multipleOfNumber1;
  }

  public int solution(int[] numbers) {
    int[] multipleOfNumbers = numbers.clone();

    int theLeastCommonMultipleForAllNumbers = multipleOfNumbers[0];

    for (int i = 1; i < multipleOfNumbers.length; i += 1) {
      theLeastCommonMultipleForAllNumbers
          = calculateTheLeastCommonMultiple(
          theLeastCommonMultipleForAllNumbers, multipleOfNumbers[i]);
    }

    return theLeastCommonMultipleForAllNumbers;
  }
}
