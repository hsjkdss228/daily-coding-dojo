import org.junit.jupiter.api.Test;

import java.math.MathContext;

import static org.assertj.core.api.Assertions.assertThat;

class MatchingTableTest {
    @Test
    void executeRoundMatch() {
        MatchingTable test = new MatchingTable();

        int round = 1;
        int number1 = 4;
        int number2 = 7;
        int[] roundAndNumbers = new int[]{round, number1, number2};

        roundAndNumbers = test.executeRoundMatch(roundAndNumbers);

        assertThat(roundAndNumbers[0]).isEqualTo(2);
        assertThat(roundAndNumbers[1]).isEqualTo(2);
        assertThat(roundAndNumbers[2]).isEqualTo(4);
    }

    @Test
    void checkIfHaveToExecuteNextRoundWhenTrue() {
        MatchingTable test = new MatchingTable();

        int number1 = 4;
        int number2 = 5;
        assertThat(test.checkIfHaveToExecute(number1, number2))
            .isEqualTo(true);
    }

    @Test
    void checkIfHaveToExecuteNextRoundWhenFalse() {
        MatchingTable test = new MatchingTable();

        int number1 = 1;
        int number2 = 2;
        assertThat(test.checkIfHaveToExecute(number1, number2))
            .isEqualTo(false);

    }

    @Test
    void solution() {
        MatchingTable test = new MatchingTable();

        assertThat(test.solution(8, 4, 7)).isEqualTo(3);
    }
}
