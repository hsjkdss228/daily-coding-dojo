import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

// 1. 두 수의 최소공배수를 구해본다.
// 2. 세 수의 최소공배수를 구해본다.

class TheLeastCommonMultipleTest {
  @Test
  void theLeastCommonMultipleOfTwoNumbers() {
    TheLeastCommonMultiple test = new TheLeastCommonMultiple();

    int number1 = 3;
    int number2 = 2;

    int theLeastCommonMultiple
        = test.calculateTheLeastCommonMultiple(number1, number2);

    assertThat(theLeastCommonMultiple).isEqualTo(6);
  }

  @Test
  void theLeastCommonMultipleOfThreeNumbers() {
    TheLeastCommonMultiple test = new TheLeastCommonMultiple();

    int[] numbers = new int[]{3, 2, 13};

    int theLeastCommonMultiple
        = test.solution(numbers);

    assertThat(theLeastCommonMultiple).isEqualTo(78);
  }

  @Test
  void theLeastCommonMultipleOfManyNumbers() {
    TheLeastCommonMultiple test = new TheLeastCommonMultiple();

    int[] numbers = new int[]{2, 6, 8, 14};

    int theLeastCommonMultiple
        = test.solution(numbers);

    assertThat(theLeastCommonMultiple).isEqualTo(168);
  }
}