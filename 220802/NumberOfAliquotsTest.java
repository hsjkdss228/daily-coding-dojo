import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfAliquotsTest {

  @Test
  void solution() {
    NumberOfAliquots test = new NumberOfAliquots();

    assertEquals(43, test.solution(13, 17));
    assertEquals(52, test.solution(24, 27));
  }
}
