import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarPasswordTest {

  @Test
  void solution() {
    CaesarPassword test = new CaesarPassword();

    assertEquals("BC", test.solution2("AB", 1));
    assertEquals("a", test.solution2("z", 1));
    assertEquals("e F d", test.solution2("a B z", 4));
  }
}
