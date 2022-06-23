import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProgressionTest {

  @Test
  void exampleSolution1() {
    Progression testApplication = new Progression();

    assertArrayEquals(
        new long[]{2, 4, 6, 8, 10},
        testApplication.solution1(2, 5)
    );

    assertArrayEquals(
        new long[]{4, 8, 12},
        testApplication.solution1(4, 3)
    );

    assertArrayEquals(
        new long[]{-4, -8},
        testApplication.solution1(-4, 2)
    );
  }

  @Test
  void exampleSolution2() {
    Progression testApplication = new Progression();

    assertArrayEquals(
        new long[]{2, 4, 6, 8, 10},
        testApplication.solution2(2, 5)
    );

    assertArrayEquals(
        new long[]{4, 8, 12},
        testApplication.solution2(4, 3)
    );

    assertArrayEquals(
        new long[]{-4, -8},
        testApplication.solution2(-4, 2)
    );
  }
}