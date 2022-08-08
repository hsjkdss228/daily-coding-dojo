import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DivisibleTest {
  @Test
  void solution() {
    Divisible test = new Divisible();

    assertArrayEquals(new int[]{5, 10}, test.solution(new int[]{5, 9, 7, 10}, 5));
    assertArrayEquals(new int[]{1, 2, 3, 36}, test.solution(new int[]{2, 36, 1, 3}, 1));
    assertArrayEquals(new int[]{-1}, test.solution(new int[]{3, 2, 6}, 10));
  }
}