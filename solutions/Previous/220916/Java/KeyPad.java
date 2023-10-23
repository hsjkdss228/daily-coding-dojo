public class KeyPad {
  public String solution(int[] numbers, String handUse) {
    String result = "";

    int[] leftFingerPosition = new int[]{3, 0};
    int[] rightFingerPosition = new int[]{3, 2};

    for (int number : numbers) {
      String handUsed
          = selectFinger(number, leftFingerPosition, rightFingerPosition, handUse);

      result += handUsed;

      if (handUsed.equals("L")) {
        leftFingerPosition = moveFingerPosition(number);
      }
      if (handUsed.equals("R")) {
        rightFingerPosition = moveFingerPosition(number);
      }
    }

    return result;
  }

  public String selectFinger(int number,
                             int[] leftFingerPosition,
                             int[] rightFingerPosition,
                             String handUse) {
    String handUsed = switch (number) {
      case 1, 4, 7 -> "L";
      case 3, 6, 9 -> "R";
      case 2, 5, 8, 0 ->
          chooseFinger(number, leftFingerPosition, rightFingerPosition, handUse);
      default -> "";
    };

    return handUsed;
  }

  public String chooseFinger(int number,
                             int[] leftFingerPosition,
                             int[] rightFingerPosition,
                             String handUse) {
    int[] numberPosition = checkNumberPosition(number);

    int distanceBetweenLeftAndNumber
        = checkDistance(numberPosition, leftFingerPosition);
    int distanceBetweenRightAndNumber
        = checkDistance(numberPosition, rightFingerPosition);

    if (distanceBetweenLeftAndNumber != distanceBetweenRightAndNumber) {
      return chooseShortDistance(
          distanceBetweenLeftAndNumber, distanceBetweenRightAndNumber);
    }

    return chooseHandUse(handUse);
  }

  public int[] checkNumberPosition(int number) {
    return switch (number) {
      case 1 -> new int[]{0, 0};
      case 2 -> new int[]{0, 1};
      case 3 -> new int[]{0, 2};
      case 4 -> new int[]{1, 0};
      case 5 -> new int[]{1, 1};
      case 6 -> new int[]{1, 2};
      case 7 -> new int[]{2, 0};
      case 8 -> new int[]{2, 1};
      case 9 -> new int[]{2, 2};
      case 0 -> new int[]{3, 1};
      default -> new int[]{};
    };
  }

  public int checkDistance(int[] numberPosition, int[] fingerPosition) {
    int numberX = numberPosition[0];
    int numberY = numberPosition[1];
    int fingerX = fingerPosition[0];
    int fingerY = fingerPosition[1];

    return Math.abs(numberX - fingerX) + Math.abs(numberY - fingerY);
  }

  public String chooseShortDistance(
      int distanceBetweenLeftAndNumber, int distanceBetweenRightAndNumber) {
    return distanceBetweenLeftAndNumber < distanceBetweenRightAndNumber
        ? "L"
        : "R";
  }

  public String chooseHandUse(String handUse) {
    return handUse.equals("left")
        ? "L"
        : "R";
  }

  public int[] moveFingerPosition(int number) {
    return checkNumberPosition(number);
  }
}
