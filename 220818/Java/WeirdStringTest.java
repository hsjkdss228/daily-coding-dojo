import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WeirdStringTest {

  @Test
  void solution() {
    WeirdString test = new WeirdString();

    assertEquals("TrY HeLlO WoRlD", test.solution("try hello world"));
    assertEquals("CoDiNg     DoJaNg I My Me MiNe", test.solution("coding     dojang i my me mine"));
    assertEquals("TrY HeLlO WoRlD", test.solution("TRY hello world"));
    assertEquals("TrYhElLoWoRlD", test.solution("tryhelloworld"));
    assertEquals("      ", test.solution("      "));
    assertEquals("TrYhElLoWoRlD      ", test.solution("tryhelloworld      "));
    assertEquals("     TrYhElLoWoRlD", test.solution("     tryhelloworld"));
    assertEquals("A B C D E F G", test.solution("a b c d e f g"));
  }
}
