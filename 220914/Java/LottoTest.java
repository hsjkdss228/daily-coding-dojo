import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// 문제 풀이 순서
// 내 로또 번호가 정답 로또 번호와 몇 개나 일치하는지 확인한다.
// 현재 일치하는 갯수로 최저 순위를 알아낼 수 있음
// 현재 일치하는 갯수 + 내 로또 번호에 있는 0의 갯수로 최고 순위를 알아낼 수 있음

class LottoTest {
  @Test
  void convertToList() {
    Lotto test = new Lotto();

    int[] myNumbers = new int[]{44, 1, 0, 0, 31, 25};

    List<Integer> myConvertedNumbers = test.convertToList(myNumbers);

    for (int i = 0; i < myConvertedNumbers.size(); i += 1) {
      assertEquals(myConvertedNumbers.get(i), myNumbers[i]);
    }
  }

  @Test
  void compareMyNumberAndWinNumber() {
    Lotto test = new Lotto();

    List<Integer> myConvertedNumbers = List.of(44, 1, 0, 0, 31, 25);
    int[] winNumbers = new int[]{31, 10, 45, 1, 6, 19};

    int matchingNumberCount
        = test.compareMyNumberAndWinNumber(myConvertedNumbers, winNumbers);

    System.out.println(matchingNumberCount);

    assertEquals(2, matchingNumberCount);
  }

  @Test
  void countZeroNumber() {
    Lotto test = new Lotto();

    List<Integer> myConvertedNumbers = List.of(44, 1, 0, 0, 31, 25);

    int zeroCount = test.countZeroNumber(myConvertedNumbers);

    assertEquals(2, zeroCount);
  }

  @Test
  void rank() {
    Lotto test = new Lotto();

    int matchingNumberCount = 2;
    int zeroCount = 2;

    int[] theHighestRankAndTheLowestRank
        = test.rank(matchingNumberCount, zeroCount);

    int theHighestRanking = theHighestRankAndTheLowestRank[0];
    int theLowestRanking = theHighestRankAndTheLowestRank[1];

    assertEquals(3, theHighestRanking);
    assertEquals(5, theLowestRanking);
  }

  @Test
  void rankEdgeCases() {
    Lotto test = new Lotto();

    assertArrayEquals(new int[]{1, 1}, test.rank(6, 0));
    assertArrayEquals(new int[]{1, 6}, test.rank(0, 6));
    assertArrayEquals(new int[]{6, 6}, test.rank(0, 0));
  }

  @Test
  void solution() {
    Lotto test = new Lotto();

    assertArrayEquals(
        new int[]{3, 5},
        test.solution(new int[]{44, 1, 0, 0, 31, 25}, new int[]{31, 10, 45, 1, 6, 19}));

    assertArrayEquals(
        new int[]{1, 6},
        test.solution(new int[]{0, 0, 0, 0, 0, 0}, new int[]{38, 19, 20, 40, 15, 25}));

    assertArrayEquals(
        new int[]{1, 1},
        test.solution(new int[]{45, 4, 35, 20, 3, 9}, new int[]{20, 9, 3, 45, 4, 35}));
  }
}
