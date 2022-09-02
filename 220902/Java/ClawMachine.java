// 문제 해결 과정
// 아래 과정을 moves의 모든 숫자들에 대해 순차적으로 수행한다.
//   1. moves에서 숫자를 하나 가져온다.
//   2. board[0~4][숫자 - 1]만큼 돌면서 0이 아닌 숫자를 찾으면  (숫자 - 1인 이유: 인덱스니까!)
//      그 숫자를 다른 List에 넣고 board에서 찾은 위치에는 그 숫자 대신 0을 재할당
//   3. List에서 앞엣놈랑 방금 List에 넣은 놈이랑 같은지 검사한다. ([size - 2] ?= [size - 1])
//      같다? 방금 List에 넣은 놈이랑 앞엣놈을 제거하고, 제거한 인형 숫자 변수에 + 2
// 제거한 인형 숫자 변수를 반환한다.

import java.util.ArrayList;
import java.util.List;

public class ClawMachine {
  public int solution(int[][] board, int[] moves) {
    int length = board.length;

    List<Integer> pickedThings = new ArrayList<>();

    int removedCount = 0;

    for (int column : moves) {
      for (int i = 0; i < length; i += 1) {
        int picked = board[i][column - 1];

        if (picked != 0) {
          pickedThings.add(picked);

          board[i][column - 1] = 0;

          break;
        }
      }

      int lastIndex = pickedThings.size() - 1;

      if (lastIndex >= 1 &&
          pickedThings.get(lastIndex).equals(pickedThings.get(lastIndex - 1))) {
        pickedThings.remove(lastIndex);
        lastIndex -= 1;
        pickedThings.remove(lastIndex);

        removedCount += 2;
      }
    }

    return removedCount;
  }
}
