public class TicTacToe {
    public static class StoneCount {
        private int o;
        private int x;

        public StoneCount(String[] board) {
            for (String row : board) {
                for (int i = 0; i < row.length(); i += 1) {
                    char stone = row.charAt(i);
                    if (stone == 'O') {
                        o += 1;
                        continue;
                    }
                    if (stone == 'X') {
                        x += 1;
                    }
                }
            }
        }

        public int o() {
            return o;
        }

        public int x() {
            return x;
        }
    }

    public static class WinningCaseCount {
        private int o;
        private int x;

        public WinningCaseCount(String[] board) {
            countRows(board);
            countColumns(board);
            countDiagonals(board);
        }

        public void countRows(String[] board) {
            for (String row : board) {
                if (row.equals("OOO")) {
                    o += 1;
                    continue;
                }
                if (row.equals("XXX")) {
                    x += 1;
                }
            }
        }

        public void countColumns(String[] board) {
            for (int columnIndex = 0; columnIndex <= 2; columnIndex += 1) {
                if (board[0].charAt(columnIndex) == 'O'
                    && board[1].charAt(columnIndex) == 'O'
                    && board[2].charAt(columnIndex) == 'O') {
                    o += 1;
                    continue;
                }
                if (board[0].charAt(columnIndex) == 'X'
                    && board[1].charAt(columnIndex) == 'X'
                    && board[2].charAt(columnIndex) == 'X') {
                    x += 1;
                }
            }
        }

        public void countDiagonals(String[] board) {
            if (board[0].charAt(0) == 'O'
                && board[1].charAt(1) == 'O'
                && board[2].charAt(2) == 'O') {
                o += 1;
            }
            if (board[0].charAt(0) == 'X'
                && board[1].charAt(1) == 'X'
                && board[2].charAt(2) == 'X') {
                x += 1;
            }
            if (board[0].charAt(2) == 'O'
                && board[1].charAt(1) == 'O'
                && board[2].charAt(0) == 'O') {
                o += 1;
            }
            if (board[0].charAt(2) == 'X'
                && board[1].charAt(1) == 'X'
                && board[2].charAt(0) == 'X') {
                x += 1;
            }
        }

        public int o() {
            return o;
        }

        public int x() {
            return x;
        }
    }

    public int solution(String[] board) {
        StoneCount stoneCount = new StoneCount(board);
        WinningCaseCount winningCaseCount = new WinningCaseCount(board);

        if (isInvalidNumberOfStones(stoneCount)) {
            return 0;
        }
        if (isNotOverEvenThoughOneSideWon(winningCaseCount, stoneCount)) {
            return 0;
        }
        return 1;
    }

    public boolean isInvalidNumberOfStones(StoneCount stoneCount) {
        return (stoneCount.o() - stoneCount.x() >= 2)
            || (stoneCount.x() - stoneCount.o() >= 1);
    }

    public boolean isNotOverEvenThoughOneSideWon(WinningCaseCount winningCaseCount,
                                                 StoneCount stoneCount) {
        if (winningCaseCount.o() == 2
            && winningCaseCount.x() == 0
            && stoneCount.o() == 5
            && stoneCount.x() == 4) {
            return false;
        }
        if ((winningCaseCount.o() == 0 && winningCaseCount.x() == 0)) {
            return false;
        }
        if (!((winningCaseCount.o() == 1 && winningCaseCount.x() == 0)
            || (winningCaseCount.x() == 1 && winningCaseCount.o() == 0))) {
            return true;
        }
        if ((winningCaseCount.x() == 1 && winningCaseCount.o() == 0)
            && stoneCount.o() > stoneCount.x()) {
            return true;
        }
        if ((winningCaseCount.o() == 1 && winningCaseCount.x() == 0)
            && (stoneCount.o() == stoneCount.x())) {
            return true;
        }
        if (winningCaseCount.o() == 0
            && winningCaseCount.x() == 1
            && stoneCount.o() == 5
            && stoneCount.x() == 4) {
            return true;
        }
        return false;
    }
}
