import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheSmallestRectanglesTest {
  @Test
  void solution() {
    TheSmallestRectangles test = new TheSmallestRectangles();

    assertEquals(
        4000,
        test.solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}}));

  }
}