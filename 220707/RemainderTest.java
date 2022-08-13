import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemainderTest {

  @Test
  void solutionTest() {
    Remainder testApplication = new Remainder();

    assertEquals(3, testApplication.solution2(10));
    assertEquals(11, testApplication.solution2(12));
    assertEquals(37, testApplication.solution2(38));
  }
}