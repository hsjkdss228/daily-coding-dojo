package solutions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitNumberTest {
  @Test
  void zero() {
    DigitNumber testApplication = new DigitNumber();

    assertEquals(0, testApplication.solution(0));
  }

  @Test
  void oneDigit() {
    DigitNumber testApplication = new DigitNumber();

    assertEquals(3, testApplication.solution(3));
    assertEquals(7, testApplication.solution(7));
  }

  @Test
  void twoDigits() {
    DigitNumber testApplication = new DigitNumber();

    assertEquals(5, testApplication.solution(32));
    assertEquals(11, testApplication.solution(74));
  }

  @Test
  void moreThanThreeDigits() {
    DigitNumber testApplication = new DigitNumber();

    assertEquals(6, testApplication.solution(123));
    assertEquals(24, testApplication.solution(987));
  }

  @Test
  void crazy() {
    DigitNumber testApplication = new DigitNumber();

    assertEquals(41, testApplication.solution(873246182));
  }
}