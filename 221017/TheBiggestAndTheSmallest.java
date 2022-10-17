import java.util.Arrays;

public class TheBiggestAndTheSmallest {
  public int[] slice(String numbers) {
    String[] splitNumbers = numbers.split(" ");

    return Arrays.stream(splitNumbers)
        .mapToInt(Integer::parseInt)
        .toArray();
  }

  public int findTheBiggest(int[] numbers) {
    return Arrays.stream(numbers)
        .max()
        .getAsInt();
  }

  public int findTheSmallest(int[] numbers) {
    return Arrays.stream(numbers)
        .min()
        .getAsInt();
  }

  public String concatenate(int theSmallestNumber, int theBiggestNumber) {
    return "" + theSmallestNumber + " " + theBiggestNumber;
  }

  public String solution(String numbers) {
    int[] splitNumbers = slice(numbers);

    int theBiggestNumber = findTheBiggest(splitNumbers);
    int theSmallestNumber = findTheSmallest(splitNumbers);

    return concatenate(theSmallestNumber, theBiggestNumber);
  }
}
