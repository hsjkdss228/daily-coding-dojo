import java.util.Arrays;

public class Budget {
  public int solution(int[] appliedAmounts, int budget) {
    int[] sortedAppliedAmounts = Arrays.stream(appliedAmounts)
        .sorted()
        .toArray();

    /*for (int amount : sortedAppliedAmounts) {
      System.out.print(amount + " ");
    }
    System.out.println();*/

    int sumOfAmount = 0;
    int result = 0;

    for (int amount : sortedAppliedAmounts) {
      sumOfAmount += amount;
      result += 1;

      if (sumOfAmount == budget) {
        break;
      }

      if (sumOfAmount > budget) {
        sumOfAmount -= amount;
        result -= 1;
        break;
      }
    }

    return result;
  }
}
