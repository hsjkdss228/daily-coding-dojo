import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CommonFactorTest {

  @Test
  void solution() {
    CommonFactor test = new CommonFactor();

    assertArrayEquals(new int[]{3, 12}, test.solution(3, 12));
    assertArrayEquals(new int[]{1, 10}, test.solution(2, 5));
    assertArrayEquals(new int[]{4, 4}, test.solution(4, 4));
    assertArrayEquals(new int[]{12, 240}, test.solution(60, 48));
  }
}
