import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseNaturalNumbersTest {

  @Test
  void solution() {
    ReverseNaturalNumbers test = new ReverseNaturalNumbers();

    assertArrayEquals(new int[]{5, 4, 3, 2, 1}, test.solution(12345));
  }
}
