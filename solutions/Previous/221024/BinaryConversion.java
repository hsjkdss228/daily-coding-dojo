public class BinaryConversion {
  private int excludedZerosCount = 0;
  private int convertedCount = 0;

  public int excludedZerosCount() {
    return excludedZerosCount;
  }

  public int convertedCount() {
    return convertedCount;
  }

  public int[] solution(String binaryNumber) {
    convertUntil1(binaryNumber);

    return new int[]{convertedCount, excludedZerosCount};
  }

  public String excludeAllZeros(String binaryNumber) {
    for (int i = 0; i < binaryNumber.length(); i += 1) {
      if (binaryNumber.charAt(i) == '0') {
        excludedZerosCount += 1;
      }
    }
    return binaryNumber.replace("0", "");
  }

  public Integer length(String numberExcludedAllZeros) {
    return numberExcludedAllZeros.length();
  }

  public String convertToBinaryNumber(Integer length) {
    return Integer.toBinaryString(length);
  }

  public String convert(String binaryNumber) {
    String numberExcludedAllZeros = excludeAllZeros(binaryNumber);
    Integer length = length(numberExcludedAllZeros);
    String convertedBinaryNumber = convertToBinaryNumber(length);
    convertedCount += 1;
    return convertedBinaryNumber;
  }

  public String convertUntil1(String binaryNumber) {
    String convertedBinaryNumber = binaryNumber;
    while (!convertedBinaryNumber.equals("1")) {
      convertedBinaryNumber = convert(convertedBinaryNumber);
    }
    return convertedBinaryNumber;
  }
}
