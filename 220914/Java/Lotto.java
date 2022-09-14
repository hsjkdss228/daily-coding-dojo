import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
  public int[] solution(int[] myNumbers, int[] winNumbers) {
    List<Integer> myConvertedNumbers = convertToList(myNumbers);

    int matchingNumberCount
        = compareMyNumberAndWinNumber(myConvertedNumbers, winNumbers);

    int zeroCount = countZeroNumber(myConvertedNumbers);

    return rank(matchingNumberCount, zeroCount);
  }

  public List<Integer> convertToList(int[] myNumbers) {
    return Arrays.stream(myNumbers)
        .boxed()
        .collect(Collectors.toList());
  }

  public int compareMyNumberAndWinNumber(
      List<Integer> myConvertedNumbers, int[] winNumbers) {
    int matchingNumberCount = 0;

    for (int winNumber : winNumbers) {
      if (myConvertedNumbers.contains(winNumber)) {
        matchingNumberCount += 1;
      }
    }

    return matchingNumberCount;
  }

  public int countZeroNumber(List<Integer> myConvertedNumbers) {
    return (int) myConvertedNumbers.stream()
        .filter(number -> number == 0)
        .count();
  }

  public int[] rank(int matchingNumberCount, int zeroCount) {
    int theLowestRanking = 7 - matchingNumberCount;
    int theHighestRanking = theLowestRanking - zeroCount;

    if (theLowestRanking == 7) {
      theLowestRanking = 6;
    }

    if (matchingNumberCount == 0 && zeroCount == 0) {
      theHighestRanking = 6;
    }

    return new int[]{theHighestRanking, theLowestRanking};
  }
}
