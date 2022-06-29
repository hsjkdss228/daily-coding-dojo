import java.util.Arrays;

public class SumOfAliquot {
  public int solution(int number) {
    int[] ascending = new int[number];

    for (int i = 0; i < number; i += 1) {
      ascending[i] = i + 1;
    }

    return Arrays.stream(ascending)
        .filter(eachDivisor -> number % eachDivisor == 0)
        .sum();
  }
}
