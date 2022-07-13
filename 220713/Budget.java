import java.util.Arrays;

public class Budget {
  public int solution(int[] appliedAmount, int budget) {
    int[] sortedAppliedAmount = Arrays.stream(appliedAmount)
        .sorted()
        .toArray();

    /*for (int amount : sortedAppliedAmount) {
      System.out.print(amount + " ");
    }
    System.out.println();*/

    int sumOfAmount = 0;
    int result = 0;

    for (int amount : sortedAppliedAmount) {
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
