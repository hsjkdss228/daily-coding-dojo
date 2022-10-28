import java.util.Arrays;

public class NextBigNumber {
  public String convertToBinary(int number) {
    return Integer.toBinaryString(number);
  }

  public int countOne(String binaryNumber) {
//    return (int) Arrays.stream(binaryNumber.split(""))
//        .filter(digit -> digit.equals("1"))
//        .count();
    int count = 0;

    for (int i = 0; i < binaryNumber.length(); i += 1) {
      if (binaryNumber.charAt(i) == '1') {
        count += 1;
      }
    }

    return count;
  }

  public int solution(int number) {
    String originalBinaryNumber = convertToBinary(number);

    int nextBigNumber = number;

    do {
      nextBigNumber += 1;
    } while ((countOne(convertToBinary(nextBigNumber)) != countOne(originalBinaryNumber)));

    return nextBigNumber;
  }
}
