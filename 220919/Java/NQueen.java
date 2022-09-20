public class NQueen {
  int answer = 0;

  public int solution(int length) {
    int[] placedPositionX = new int[length];
    int[] placedPositionY = new int[length];

    for (int i = 0; i < length; i += 1) {
      placedPositionX[0] = 0;
      placedPositionY[0] = i;

      putQueen(placedPositionX, placedPositionY, 1, length);
    }

    return answer;
  }

  public void putQueen(int[] placedPositionX,
                       int[] placedPositionY,
                       int count, int length) {
    if (count == length) {
      answer += 1;
      return;
    }

    for (int i = 0; i < length; i += 1) {
      int newPositionX = count;
      int newPositionY = i;
      boolean isPossibleCase = true;

      for (int j = 0; j < count; j += 1) {
        int previousPositionX = placedPositionX[j];
        int previousPositionY = placedPositionY[j];

        if (previousPositionY == newPositionY) {
          isPossibleCase = false;
          break;
        }

        if (Math.abs(newPositionX - previousPositionX)
            == Math.abs(newPositionY - previousPositionY)) {
          isPossibleCase = false;
          break;
        }
      }

      if (isPossibleCase) {
        placedPositionX[count] = newPositionX;
        placedPositionY[count] = newPositionY;

        putQueen(placedPositionX, placedPositionY, count + 1, length);
      }
    }
  }
}
