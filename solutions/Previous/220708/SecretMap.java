public class SecretMap {
  public String[] solution(int length, int[] array1, int[] array2) {
// 두 int[] array의 각 요소를 이진수 문자열로 변환한 String[] array를 생성한다.
// ex) {3, 6, 5} >> {"011", "110", "101"},
//     {1, 7, 4} >> {"001", "111", "100"},
//
// 생성된 두 array의 동일한 index 위치에 있는 문자열의 각 자리수를 비교해
// 각 자리수가 둘 중 하나라도 1이면 "#", 둘 다 0이면 " "인 문자로 변환한 문자열을 생성한 뒤
// 생성한 문자열을 정답 String[] array의 index 번째 문자열에 추가한다.
// ex) 두 array의 [0]에 들어있는 "011", "001"의 비교 결과는 " ##" >> 정답 array의 [0]에 입력
//               [1]에 들어있는 "110", "111"의 비교 결과는 "###" >> 정답 array의 [1]에 입력
//               [2]에 들어있는 "101", "100"의 비교 결과는 "# #" >> 정답 array의 [2]에 입력
// >> 최종 정답: {" ##", "###", "# #"}

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

  public String[] solution2(int length, int[] array1, int[] array2) {
    String[] binaryArray1 = new String[length];
    String[] binaryArray2 = new String[length];

    for (int i = 0; i < length; i += 1) {
      binaryArray1[i] = Integer.toBinaryString(array1[i]);
      for (int j = binaryArray1[i].length() - 1; j < length - 1; j += 1) {
        binaryArray1[i] = "0" + binaryArray1[i];
      }

      binaryArray2[i] = Integer.toBinaryString(array2[i]);
      for (int j = binaryArray2[i].length() - 1; j < length - 1; j += 1) {
        binaryArray2[i] = "0" + binaryArray2[i];
      }
    }

    String[] answerArray = new String[length];
    for (int i = 0; i < length; i += 1) {
      answerArray[i] = "";

      for (int j = 0; j < length; j += 1) {
        if (binaryArray1[i].charAt(j) == '1' || binaryArray2[i].charAt(j) == '1') {
          answerArray[i] += "#";
          continue;
        }

        answerArray[i] += " ";
      }
    }

    return answerArray;
  }
}
