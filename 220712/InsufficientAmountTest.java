import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InsufficientAmountTest {

  @Test
  void solution() {
    InsufficientAmount application = new InsufficientAmount();

    assertEquals(10, application.solution(3, 20, 4));
  }

  @Test
  void solution2() {
    InsufficientAmount application = new InsufficientAmount();

    assertEquals(10, application.solution2(3, 20, 4));
  }
}