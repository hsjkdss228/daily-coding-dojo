// 틀을 짠 뒤, 틀을 구성하는 method들을
// 순차적으로 Test Case를 통과시켜 나가는 방식으로 구현한다.
//
// 1. lottos에서 0을 제외한 숫자들로 구성된 배열을 마련한다. 이때 배열에 0만 있으면 null 배열...
// 2. lottosExceptZero와 winNumbers를 비교해 맞는 개수를 카운트한다
// 3. 최소 순위는
//   >> 정답 개수가 1개 이하이면: 6
//   >> 정답 개수가 2개 이상이면: 6 - 정답 개수 + 1
// 4. lottos에서 0이 몇 개인지 센다.
// 5. 최대 순위는
//   >> 정답 개수가 6개이면: 1
//   >> 정답 개수가 5개 이하이면: 6 - (정답 개수 + 0 개수) + 1

public class Lotto {
  public int[] solution(int[] lottos, int[] winNumbers) {
    int[] result = new int[2];

    int[] lottosExceptZero = excludeZero(lottos);

    int winCount = countAnswerExceptZero(lottosExceptZero, winNumbers);

    result[1] = setLowestRanking(winCount);

    int zeroCount = countZero(lottos);

    result[0] = setHighestRanking(winCount, zeroCount);

    return result;
  }

  public int[] excludeZero(int[] lottos) {
    int zeroCount = countZero(lottos);

    if (zeroCount == 6) {
      return null;
    }

    int[] lottosExceptZero = new int[lottos.length - zeroCount];

    int indexLottosExceptZero = 0;

    for (int eachNumber : lottos) {
      if (eachNumber == 0) {
        continue;
      }

      lottosExceptZero[indexLottosExceptZero] = eachNumber;
      indexLottosExceptZero += 1;
    }

    return lottosExceptZero;
  }

  public int countZero(int[] lottos) {
    int zeroCount = 0;

    for (int eachNumber : lottos) {
      if (eachNumber == 0) {
        zeroCount += 1;
      }
    }

    return zeroCount;
  }

  public int countAnswerExceptZero(int[] lottosExceptZero, int[] winNumbers) {
    if (lottosExceptZero == null) {
      return 0;
    }

    int winCount = 0;

    for (int eachExceptZero : lottosExceptZero) {
      for (int eachWinNumber : winNumbers) {
        if (eachExceptZero == eachWinNumber) {
          winCount += 1;
        }
      }
    }

    return winCount;
  }

  public int setLowestRanking(int winCount) {
    if (winCount <= 1) {
      return 6;
    }

    if (winCount >= 2) {
      return 6 - winCount + 1;
    }

    return 0;
  }

  public int setHighestRanking(int winCount, int zeroCount) {
    //   >> 정답 개수가 6개이면: 1
    //   >> 정답 개수가 5개 이하이면: 6 - (정답 개수 + 0 개수) + 1
    if (winCount == 6) {
      return 1;
    }

    if (winCount <= 5) {
      return 6 - (winCount + zeroCount) + 1;
    }

    return 0;
  }
}
