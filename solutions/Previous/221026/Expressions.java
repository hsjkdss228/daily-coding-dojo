public class Expressions {
  private int count = 0;

  public int solution(int n) {
    for (int start = 1; start <= n; start += 1) {
      int sum = 0;

      for (int number = start; number <= n; number += 1) {
        sum += number;

        if (sum == n) {
          count += 1;
          break;
        }

        if (sum > n) {
          break;
        }
      }
    }

    return count;
  }
}
