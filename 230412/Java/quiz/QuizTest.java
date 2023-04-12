import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QuizTest {
    private Quiz test;

    @BeforeEach
    void setUp() {
        test = new Quiz();
    }

    @Test
    void solution1() {
        String[] expressions = {
            "3 - 4 = -3",
            "5 + 6 = 11"
        };
        String[] result = {"X", "O"};
        assertThat(test.solution(expressions)).isEqualTo(result);
    }

    @Test
    void solution2() {
        String[] expressions = {
            "19 - 6 = 13",
            "5 + 66 = 71",
            "5 - 15 = 63",
            "3 - 1 = 2"
        };
        String[] result = {"O", "O", "X", "O"};
        assertThat(test.solution(expressions)).isEqualTo(result);
    }
}
