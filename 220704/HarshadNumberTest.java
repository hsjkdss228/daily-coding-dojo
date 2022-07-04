import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HarshadNumberTest {
  @Test
  void makeDivisorTest() {
    HarshadNumber harshadNumber = new HarshadNumber();

    assertEquals(9, harshadNumber.makeDivisor(135));
  }

  @Test
  void makeDivisorInADifferentWayTest() {
    HarshadNumber harshadNumber = new HarshadNumber();

    assertEquals(9, harshadNumber.makeDivisorInADifferentWay(135));
  }

  @Test
  void test1() {
    HarshadNumber harshadNumber = new HarshadNumber();

    assertEquals(false, harshadNumber.solution(11));
  }

  @Test
  void otherTests() {
    HarshadNumber harshadNumber = new HarshadNumber();

    assertEquals(true, harshadNumber.solution(10));
    assertEquals(true, harshadNumber.solution(12));
    assertEquals(false, harshadNumber.solution(13));
  }
}