import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseTernaryTest {

  @Test
  void convertTernaryTest() {
    ReverseTernary test = new ReverseTernary();

    assertEquals("1200", test.convertTernary(45));
    assertEquals("11122", test.convertTernary(125));
  }

  @Test
  void reverseTest() {
    ReverseTernary test = new ReverseTernary();

    assertEquals("0021", test.reverse("1200"));
    assertEquals("22111", test.reverse("11122"));
  }

  @Test
  void convertDecimalTest() {
    ReverseTernary test = new ReverseTernary();

    assertEquals(7, test.convertDecimal("0021"));
    assertEquals(229, test.convertDecimal("22111"));
  }
}