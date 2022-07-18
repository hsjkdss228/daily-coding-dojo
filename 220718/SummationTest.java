import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SummationTest {

  @Test
  void solution() {
    Summation summation = new Summation();

    assertEquals(9, summation.solution(
        new int[]{4, 7, 12}, new boolean[]{true, false, true}
    ));

    assertEquals(0, summation.solution(
        new int[]{1, 2, 3}, new boolean[]{false, false, true}
    ));
  }
}