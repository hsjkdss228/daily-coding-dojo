import java.util.Arrays;

public class Budget {
  public int solution(int[] appliedAmounts, int budget) {
    int[] sortedAppliedAmounts = Arrays.stream(appliedAmounts)
        .sorted()
        .toArray();

    int sumAmount = 0;
    int result = 0;

    for (int amount : sortedAppliedAmounts) {
      sumAmount += amount;
      result += 1;

      if (sumAmount == budget) {
        break;
      }

      if (sumAmount > budget) {
        result -= 1;
        break;
      }
    }

    return result;
  }

  public int solution2(int[] appliedAmounts, int budget) {
    int[] sortedAppliedAmounts = Arrays.stream(appliedAmounts)
        .sorted()
        .toArray();

    int index = 0;
    int sumAmount = 0;
    int result = 0;

    while (sumAmount < budget && index < sortedAppliedAmounts.length) {
      sumAmount += sortedAppliedAmounts[index];
      result += 1;

      if (sumAmount == budget) {
        break;
      }

      if (sumAmount > budget) {
        result -= 1;
        break;
      }

      index += 1;
    }

    return result;
  }
}
