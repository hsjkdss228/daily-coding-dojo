import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTernary2Test {

  @Test
  void solution() {
    ConvertTernary2 test = new ConvertTernary2();

    assertEquals(7, test.solution(45));
    assertEquals(229, test.solution(125));
  }
}