import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DescendingOrderTest {
  @Test
  void oneWord() {
    DescendingOrder descendingOrder = new DescendingOrder();

    assertEquals("h", descendingOrder.solution("h"));
    assertEquals("I", descendingOrder.solution("I"));
    assertEquals("w", descendingOrder.solution("w"));
  }

  @Test
  void twoAscendingWords() {
    DescendingOrder descendingOrder = new DescendingOrder();

    assertEquals("qh", descendingOrder.solution("hq"));
    assertEquals("uK", descendingOrder.solution("Ku"));
    assertEquals("ZM", descendingOrder.solution("MZ"));
  }

  @Test
  void moreThanThreeAscendingWords() {
    DescendingOrder descendingOrder = new DescendingOrder();

    assertEquals("cba", descendingOrder.solution("abc"));
    assertEquals("whI", descendingOrder.solution("hIw"));
    assertEquals("trfaTSRCA", descendingOrder.solution("StaRCrAfT"));
    assertEquals("tfaaaaTS", descendingOrder.solution("StaaaafT"));
  }
}
