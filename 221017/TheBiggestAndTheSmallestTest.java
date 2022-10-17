import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TheBiggestAndTheSmallestTest {
  @Test
  void slice() {
    TheBiggestAndTheSmallest test = new TheBiggestAndTheSmallest();

    String numbers = "1 2 3 4";
    int[] slicedNumbers = new int[]{1, 2, 3, 4};

    assertThat(test.slice(numbers)).isEqualTo(slicedNumbers);
  }

  @Test
  void findTheBiggest() {
    TheBiggestAndTheSmallest test = new TheBiggestAndTheSmallest();

    int[] numbers = new int[]{1, 2, 3, 4};
    int theBiggestNumber = 4;

    assertThat(test.findTheBiggest(numbers)).isEqualTo(theBiggestNumber);
  }

  @Test
  void findTheBiggestWhenEqual() {
    TheBiggestAndTheSmallest test = new TheBiggestAndTheSmallest();

    int[] numbers = new int[]{1, 1};
    int theBiggestNumber = 1;

    assertThat(test.findTheBiggest(numbers)).isEqualTo(theBiggestNumber);
  }

  @Test
  void findTheSmallest() {
    TheBiggestAndTheSmallest test = new TheBiggestAndTheSmallest();

    int[] numbers = new int[]{1, 2, 3, 4};
    int theSmallestNumber = 1;

    assertThat(test.findTheSmallest(numbers)).isEqualTo(theSmallestNumber);
  }

  @Test
  void findTheSmallestWhenEqual() {
    TheBiggestAndTheSmallest test = new TheBiggestAndTheSmallest();

    int[] numbers = new int[]{1, 1};
    int theSmallestNumber = 1;

    assertThat(test.findTheSmallest(numbers)).isEqualTo(theSmallestNumber);
  }

  @Test
  void concatenate() {
    TheBiggestAndTheSmallest test = new TheBiggestAndTheSmallest();

    int theSmallestNumber = 3;
    int theBiggestNumber = 10;
    String answer = "3 10";

    assertThat(test.concatenate(theSmallestNumber, theBiggestNumber))
        .isEqualTo(answer);
  }

  @Test
  void solution() {
    TheBiggestAndTheSmallest test = new TheBiggestAndTheSmallest();

    String numbers = "1 2 3 4";
    String answer = "1 4";

    assertThat(test.solution(numbers)).isEqualTo(answer);
  }

  @Test
  void solutionWhenEqual() {
    TheBiggestAndTheSmallest test = new TheBiggestAndTheSmallest();

    String numbers = "-1 -1";
    String answer = "-1 -1";

    assertThat(test.solution(numbers)).isEqualTo(answer);
  }
}
