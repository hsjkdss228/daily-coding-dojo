import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DigitNumberTest {
  @Test
  void zero() {
    DigitNumber test = new DigitNumber();

    assertEquals(0, test.solution3(0));
  }

  @Test
  void oneDigit() {
    DigitNumber test = new DigitNumber();

    assertEquals(3, test.solution3(3));
    assertEquals(7, test.solution3(7));
  }

  @Test
  void twoDigits() {
    DigitNumber test = new DigitNumber();

    assertEquals(5, test.solution3(32));
    assertEquals(11, test.solution3(74));
  }

  @Test
  void moreThanThreeDigits() {
    DigitNumber test = new DigitNumber();

    assertEquals(6, test.solution3(123));
    assertEquals(24, test.solution3(987));
  }

  @Test
  void crazy() {
    DigitNumber test = new DigitNumber();

    assertEquals(41, test.solution3(873246182));
  }
}