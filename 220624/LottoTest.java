import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LottoTest {

  @Test
  void excludeZero() {
    Lotto test = new Lotto();

    assertArrayEquals(
        new int[]{44, 1, 31, 25},
        test.excludeZero(new int[]{44, 1, 0, 0, 31, 25})
    );

    assertNull(test.excludeZero(new int[]{0, 0, 0, 0, 0, 0}));

    assertArrayEquals(
        new int[]{45, 4, 35, 20, 3, 9},
        test.excludeZero(new int[]{45, 4, 35, 20, 3, 9})
    );
  }

  @Test
  void countZero() {
    Lotto test = new Lotto();

    assertEquals(2, test.countZero(new int[]{44, 1, 0, 0, 31, 25}));
    assertEquals(6, test.countZero(new int[]{0, 0, 0, 0, 0, 0}));
    assertEquals(0, test.countZero(new int[]{45, 4, 35, 20, 3, 9}));
  }

  @Test
  void countAnswerExceptZero() {
    Lotto test = new Lotto();

    assertEquals(
        2,
        test.countAnswerExceptZero(
            new int[]{44, 1, 31, 25},
            new int[]{31, 10, 45, 1, 6, 19}
        )
    );

    assertEquals(
        0,
        test.countAnswerExceptZero(
            null,
            new int[]{38, 19, 20, 40, 15, 25}
        )
    );

    assertEquals(
        6,
        test.countAnswerExceptZero(
            new int[]{45, 4, 35, 20, 3, 9},
            new int[]{20, 9, 3, 45, 4, 35}
        )
    );
  }

  @Test
  void setLowestRanking() {
    Lotto test = new Lotto();

    assertEquals(5, test.setLowestRanking(2));
    assertEquals(6, test.setLowestRanking(0));
    assertEquals(1, test.setLowestRanking(6));
  }

  @Test
  void setHighestRanking() {
    Lotto test = new Lotto();

    assertEquals(3, test.setHighestRanking(2, 2));
    assertEquals(1, test.setHighestRanking(0, 6));
    assertEquals(1, test.setHighestRanking(6, 0));
  }

  @Test
  void finalTest() {
    Lotto test = new Lotto();

    assertArrayEquals(
        new int[]{1, 6},
        test.solution(
            new int[]{0, 0, 0, 0, 0, 1},
            new int[]{1, 2, 3, 4, 5, 6}
        )
    );

    assertArrayEquals(
        new int[]{2, 6},
        test.solution(
            new int[]{0, 0, 0, 0, 0, 1},
            new int[]{2, 3, 4, 5, 6, 7}
        )
    );
  }
}
