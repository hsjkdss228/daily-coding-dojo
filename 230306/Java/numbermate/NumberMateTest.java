import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class NumberMateTest {
    private NumberMate test;

    @BeforeEach
    void setUp() {
        test = new NumberMate();
    }

    @Test
    void createDigitAndCounts() {
        String number1 = "5525";
        String number2 = "1255";
        assertThat(test.createDigitAndCounts(number1, number2))
            .isEqualTo(Map.of(
                '2', 1,
                '5', 2
            ));
    }

    @Test
    void createAnswer() {
        Map<Character, Integer> digitAndCounts = Map.of(
            '2', 1,
            '5', 2
        );
        assertThat(test.createAnswer(digitAndCounts))
            .isEqualTo("552");
    }

    @Test
    void createNoAnswer() {
        Map<Character, Integer> digitAndCounts = Map.of();
        assertThat(test.createAnswer(digitAndCounts))
            .isEqualTo("-1");
    }

    @Test
    void createZeroAnswer() {
        Map<Character, Integer> digitAndCounts = Map.of(
            '0', 5
        );
        assertThat(test.createAnswer(digitAndCounts))
            .isEqualTo("0");
    }
}
