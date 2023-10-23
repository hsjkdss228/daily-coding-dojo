import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PaperCuttingTest {
    private PaperCutting test;

    @BeforeEach
    void setUp() {
        test = new PaperCutting();
    }

    @Test
    void solution1() {
        int width = 2;
        int height = 2;
        assertThat(test.solution(width, height)).isEqualTo(3);
    }

    @Test
    void solution2() {
        int width = 2;
        int height = 5;
        assertThat(test.solution(width, height)).isEqualTo(9);
    }

    @Test
    void solution3() {
        int width = 1;
        int height = 1;
        assertThat(test.solution(width, height)).isEqualTo(0);
    }
}
