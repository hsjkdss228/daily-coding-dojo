import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DayTest {
  @Test
  void soultion() {
    Day test = new Day();

    assertEquals("TUE", test.solution(5, 24));
    assertEquals("WED", test.solution(9, 14));
    assertEquals("THU", test.solution(5, 5));
    assertEquals("FRI", test.solution(1, 1));
    assertEquals("SAT", test.solution(10, 1));
    assertEquals("SUN", test.solution(12, 25));
    assertEquals("MON", test.solution(6, 6));

  }
}