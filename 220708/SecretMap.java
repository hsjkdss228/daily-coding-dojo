// 두 int[] array의 각 요소를 이진수 문자열로 변환한 String[] array를 생성한다.
// 두 array의 동일한 index 위치에 있는 문자열의 각 자리수를 비교해
// 각 자리수가 둘 중 하나라도 1이면 "#", 둘 다 0이면 " "인 문자로 변환한 문자열을 생성해
// 새로운 String[] array의 index 번째 문자열에 추가한다.

public class SecretMap {
  public String[] solution(int length, int[] array1, int[] array2) {
    String[] binaryArray1 = new String[length];
    String[] binaryArray2 = new String[length];

    for (int i = 0; i < length; i += 1) {
      binaryArray1[i] = decimalToBinary(array1[i], length);
      binaryArray2[i] = decimalToBinary(array2[i], length);
    }

    return makeSecretMap(length, binaryArray1, binaryArray2);
  }

  public String decimalToBinary(int decimal, int length) {
    String binary = "";

    int dividend = decimal;

    while (dividend > 0) {
      int remainder = dividend % 2;

      binary = remainder + binary;

      dividend /= 2;
    }

    while (binary.length() < length) {
      binary = "0" + binary;
    }

    return binary;
  }

  public String[] makeSecretMap(
      int length, String[] binaryArray1, String[] binaryArray2) {
    String[] secretMap = new String[length];

    for (int i = 0; i < length; i += 1) {
      String secretMapElement = "";

      for (int j = 0; j < length; j += 1) {
        secretMapElement = secretMapElement + (
            binaryArray1[i].charAt(j) == '0' && binaryArray2[i].charAt(j) == '0'
                ? " "
                : "#"
        );

        secretMap[i] = secretMapElement;
      }
    }

    return secretMap;
  }
}
