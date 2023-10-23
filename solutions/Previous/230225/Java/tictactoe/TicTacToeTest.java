import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TicTacToeTest {
    @Test
    void isValidNumberOfStones1() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "O.X",
            ".O.",
            "..X"
        };
        TicTacToe.StoneCount stoneCount = new TicTacToe.StoneCount(board);
        assertThat(test.isInvalidNumberOfStones(stoneCount)).isFalse();
    }

    @Test
    void isValidNumberOfStones2() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "...",
            ".O.",
            "..."
        };
        TicTacToe.StoneCount stoneCount = new TicTacToe.StoneCount(board);
        assertThat(test.isInvalidNumberOfStones(stoneCount)).isFalse();
    }

    @Test
    void isValidNumberOfStones3() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "...",
            "...",
            "..."
        };
        TicTacToe.StoneCount stoneCount = new TicTacToe.StoneCount(board);
        assertThat(test.isInvalidNumberOfStones(stoneCount)).isFalse();
    }

    @Test
    void isInvalidNumberOfStones1() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "...",
            "..X",
            "..."
        };
        TicTacToe.StoneCount stoneCount = new TicTacToe.StoneCount(board);
        assertThat(test.isInvalidNumberOfStones(stoneCount)).isTrue();
    }

    @Test
    void isInvalidNumberOfStones2() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "..O",
            "O.X",
            "..O"
        };
        TicTacToe.StoneCount stoneCount = new TicTacToe.StoneCount(board);
        assertThat(test.isInvalidNumberOfStones(stoneCount)).isTrue();
    }

    @Test
    void isOverBecauseOneSideWon1() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "OOO",
            "X.X",
            "..."
        };
        TicTacToe.StoneCount stoneCount = new TicTacToe.StoneCount(board);
        TicTacToe.WinningCaseCount winningCaseCount = new TicTacToe.WinningCaseCount(board);
        assertThat(
            test.isNotOverEvenThoughOneSideWon(winningCaseCount, stoneCount)
        ).isFalse();
    }

    @Test
    void isOverBecauseOneSideWon2() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "O.X",
            "OX.",
            "X.O"
        };
        TicTacToe.StoneCount stoneCount = new TicTacToe.StoneCount(board);
        TicTacToe.WinningCaseCount winningCaseCount = new TicTacToe.WinningCaseCount(board);
        assertThat(
            test.isNotOverEvenThoughOneSideWon(winningCaseCount, stoneCount)
        ).isFalse();
    }

    @Test
    void isNotOverEvenThoughOneSideWon1() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "OOO",
            "...",
            "XXX"
        };
        TicTacToe.StoneCount stoneCount = new TicTacToe.StoneCount(board);
        TicTacToe.WinningCaseCount winningCaseCount = new TicTacToe.WinningCaseCount(board);
        assertThat(
            test.isNotOverEvenThoughOneSideWon(winningCaseCount, stoneCount)
        ).isTrue();
    }

    @Test
    void isNotOverEvenThoughOneSideWon2() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "O.X",
            "OX.",
            "O.X"
        };
        TicTacToe.StoneCount stoneCount = new TicTacToe.StoneCount(board);
        TicTacToe.WinningCaseCount winningCaseCount = new TicTacToe.WinningCaseCount(board);
        assertThat(
            test.isNotOverEvenThoughOneSideWon(winningCaseCount, stoneCount)
        ).isTrue();
    }

    @Test
    void solutionValid1() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "O.X",
            ".O.",
            "..X"
        };
        assertThat(test.solution(board)).isEqualTo(1);
    }

    @Test
    void solutionValid2() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "X.O",
            "XO.",
            "X.O"
        };
        assertThat(test.solution(board)).isEqualTo(1);
    }

    @Test
    void solutionInvalid1() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "O.X",
            ".O.",
            "XXO"
        };
        assertThat(test.solution(board)).isEqualTo(0);
    }

    @Test
    void solution1() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "OOX",
            "OOX",
            "XXO"
        };
        assertThat(test.solution(board)).isEqualTo(1);
    }

    @Test
    void solution2() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "...",
            "...",
            "..."
        };
        assertThat(test.solution(board)).isEqualTo(1);
    }

    @Test
    void solution3() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "XXO",
            "OXX",
            "OOO"
        };
        assertThat(test.solution(board)).isEqualTo(1);
    }

    @Test
    void solution4() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "OXO",
            "XOX",
            "OXO"
        };
        assertThat(test.solution(board)).isEqualTo(1);
    }

    @Test
    void solution5() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "OOO",
            "OXX",
            "OXX"
        };
        assertThat(test.solution(board)).isEqualTo(1);
    }

    @Test
    void solution6() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            ".XX",
            "OXO",
            "XOO"
        };
        assertThat(test.solution(board)).isEqualTo(1);
    }

    @Test
    void solution7() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            "OXX",
            "OXO",
            "XOO"
        };
        assertThat(test.solution(board)).isEqualTo(0);
    }

    @Test
    void solution8() {
        TicTacToe test = new TicTacToe();

        String[] board = {
            ".OO",
            "XXX",
            ".OO"
        };
        assertThat(test.solution(board)).isEqualTo(0);
    }
}
