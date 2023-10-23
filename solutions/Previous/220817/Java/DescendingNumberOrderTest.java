import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescendingNumberOrderTest {
  @Test
  void solution() {
    DescendingNumberOrder test = new DescendingNumberOrder();

    assertEquals(873211, test.solution(118372));
  }
}
