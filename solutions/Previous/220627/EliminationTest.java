import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class EliminationTest {

  @Test
  void testCase1() {
    Elimination elimination = new Elimination();

    assertArrayEquals(
        new int[]{4, 3, 2}, elimination.solution(new int[]{4, 3, 2, 1})
    );
  }

  @Test
  void testCase2() {

    Elimination elimination = new Elimination();

    assertArrayEquals(
        new int[]{-1}, elimination.solution(new int[]{10})
    );
  }
}
