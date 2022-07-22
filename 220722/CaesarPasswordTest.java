import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CaesarPasswordTest {

  @Test
  void solution() {
    CaesarPassword test = new CaesarPassword();

    assertEquals("BC", test.solution("AB", 1));
    assertEquals("a", test.solution("z", 1));
    assertEquals("e F d", test.solution("a B z", 4));
  }
}