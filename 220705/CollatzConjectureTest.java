import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CollatzConjectureTest {
  @Test
  void solution1Test() {
    CollatzConjecture collatzConjecture = new CollatzConjecture();

    assertEquals(8, collatzConjecture.solution1(6));
    assertEquals(0, collatzConjecture.solution1(1));
    assertEquals(4, collatzConjecture.solution1(16));
    assertEquals(-1, collatzConjecture.solution1(626331));
  }

  @Test
  void solution2Test() {
    CollatzConjecture collatzConjecture = new CollatzConjecture();

    assertEquals(8, collatzConjecture.solution2(6));
    assertEquals(0, collatzConjecture.solution2(1));
    assertEquals(4, collatzConjecture.solution2(16));
    assertEquals(-1, collatzConjecture.solution2(626331));
  }
}