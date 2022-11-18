import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

// 전체 과정 중 일부분을 먼저 구현한 뒤, 일부분을 전체로 확대시켜 보는 과정을 시도
//
// 1. 퀸을 놓을 자리를 결정한다.
// 2. 빈 판에 퀸 하나를 배치한다. 퀸이 있는 자리, 새 퀸을 놓을 수 없는 자리를 표시한다.

class NQueenTest {
  @Test
  void decidePuttingPositionCase1() {
    NQueen test = new NQueen();

    char[][] board = {
        {'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O'}
    };

    int[] position = test.decidePuttingPosition(board);

    assertThat(position).isEqualTo(new int[]{0, 0});
  }

  @Test
  void putQueenCase1() {
    NQueen test = new NQueen();

    int n = 4;
    char[][] board = {
        {'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O'},
        {'O', 'O', 'O', 'O'}
    };
    int[] position = new int[]{0, 0};

    board = test.putQueen(board, position);

    assertThat(board).isDeepEqualTo(new char[][]{
        {'Q', 'X', 'X', 'X'},
        {'X', 'X', 'O', 'O'},
        {'X', 'O', 'X', 'O'},
        {'X', 'O', 'O', 'X'}
    });
  }
}