import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareRootTest {
  @Test
  void mathematicalIntegerDiscriminationTest() {
    SquareRoot testApplication = new SquareRoot();

    double squareRootNumber = Math.sqrt(137);

    assertFalse(testApplication.isMathematicallyInteger(squareRootNumber));

    squareRootNumber = Math.sqrt(121);

    assertTrue(testApplication.isMathematicallyInteger(squareRootNumber));
  }

  @Test
  void solutionTest() {
    SquareRoot testApplication = new SquareRoot();

    assertEquals(-1, testApplication.solution(137));
    assertEquals(144, testApplication.solution(121));
    assertEquals(-1, testApplication.solution(3));
  }
}
