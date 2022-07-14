import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeduplicationTest {
  @Test
  void solution() {
    Deduplication deduplication = new Deduplication();

    assertArrayEquals(
        new int[]{1, 3, 0 ,1},
        deduplication.solution(new int[]{1, 1, 3, 3, 0, 1, 1})
    );

    assertArrayEquals(
        new int[]{4, 3},
        deduplication.solution(new int[]{4, 4, 4, 3, 3})
    );
  }
}
