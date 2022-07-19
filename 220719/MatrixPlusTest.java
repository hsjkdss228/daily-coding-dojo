import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MatrixPlusTest {
  @Test
  void solution() {
    MatrixPlus matrixPlus = new MatrixPlus();

    assertArrayEquals(
        new int[][]{{4, 6}, {7, 9}},
        matrixPlus.solution(
            new int[][]{{1, 2}, {2, 3}}, new int[][]{{3, 4}, {5, 6}}
        )
    );

    assertArrayEquals(
        new int[][]{{4}, {6}},
        matrixPlus.solution(
            new int[][]{{1}, {2}}, new int[][]{{3}, {4}}
        )
    );
  }
}
