import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConsecutiveNumbersTest {
    private ConsecutiveNumbers test;

    @BeforeEach
    void setUp() {
        test = new ConsecutiveNumbers();
    }

    @Test
    void solution1() {
        int count = 3;
        int total = 12;
        assertThat(test.solution(count, total))
            .isEqualTo(new int[]{3, 4, 5});
    }

    @Test
    void solution2() {
        int count = 5;
        int total = 15;
        assertThat(test.solution(count, total))
            .isEqualTo(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    void solution3() {
        int count = 4;
        int total = 14;
        assertThat(test.solution(count, total))
            .isEqualTo(new int[]{2, 3, 4, 5});
    }

    @Test
    void solution4() {
        int count = 5;
        int total = 5;
        assertThat(test.solution(count, total))
            .isEqualTo(new int[]{-1, 0, 1, 2, 3});
    }
}
