import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NotExistingNumberTest {
  @Test
  void solution() {
    NotExistingNumber test = new NotExistingNumber();

    assertEquals(14, test.solution(new int[]{1, 2, 3, 4, 6, 7, 8, 0}));
    assertEquals(6, test.solution(new int[]{5, 8, 4, 0, 6, 7, 9}));
  }
}
