public class NQueen {
  public int[] decidePuttingPosition(char[][] board) {
    for (int x = 0; x < board.length; x += 1) {
      for (int y = 0; y < board[x].length; y += 1) {
        if (board[x][y] == 'O') {
          return new int[]{x, y};
        }
      }
    }

    return null;
  }

  public char[][] putQueen(char[][] board, int[] position) {
    int positionX = position[0];
    int positionY = position[1];

    board[positionY][positionX] = 'Q';

    for (int x = positionX + 1; x < board[positionY].length; x += 1) {
      board[positionY][x] = 'X';
    }

    for (int y = positionY + 1; y < board.length; y += 1) {
      board[y][positionX] = 'X';
      board[y][y] = 'X';
    }

    return board;
  }
}
