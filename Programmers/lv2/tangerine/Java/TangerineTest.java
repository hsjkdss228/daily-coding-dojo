import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TangerineTest {
    private Tangerine test;

    @BeforeEach
    void setUp() {
        test = new Tangerine();
    }

    @Test
    void solution1() {
        int sum = 6;
        int[] tangerines = {1, 3, 2, 5, 4, 5, 2, 3};
        assertThat(test.solution(sum, tangerines)).isEqualTo(3);
    }

    @Test
    void solution2() {
        int sum = 4;
        int[] tangerines = {1, 3, 2, 5, 4, 5, 2, 3};
        assertThat(test.solution(sum, tangerines)).isEqualTo(2);
    }

    @Test
    void solution3() {
        int sum = 2;
        int[] tangerines = {1, 1, 1, 1, 2, 2, 2, 3};
        assertThat(test.solution(sum, tangerines)).isEqualTo(1);
    }
}
