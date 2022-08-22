import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthNumberTest {
  @Test
  void arrayLength() {
    int array[][] = new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}};

    System.out.println(array.length);
    System.out.println(array[0].length);
  }

  @Test
  void solution() {
    KthNumber test = new KthNumber();

    assertArrayEquals(new int[]{5, 6, 3},
        test.solution(new int[]{1, 5, 2, 6, 3, 7, 4},
            new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));
  }
}
