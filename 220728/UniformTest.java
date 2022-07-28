import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniformTest {
  @Test
  void solution() {
    Uniform test = new Uniform();

    assertEquals(
        6,
        test.solution(8, new int[]{1, 3, 4, 6, 7}, new int[]{2, 5, 6})
    );

    assertEquals(
        5,
        test.solution(5, new int[]{2, 4}, new int[]{1, 3, 5})
    );

    assertEquals(
        4,
        test.solution(5, new int[]{2, 4}, new int[]{3})
    );

    assertEquals(
        2,
        test.solution(3, new int[]{3}, new int[]{1})
    );

    assertEquals(
        8,
        test.solution(9, new int[]{5, 6, 8, 1, 2}, new int[]{2, 3, 1, 4, 8, 9})
    );
  }
}