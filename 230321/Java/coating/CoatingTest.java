import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CoatingTest {
    private Coating test;

    @BeforeEach
    void setUp() {
        test = new Coating();
    }

    @Test
    void solution1() {
        int wallLength = 8;
        int rulerLength = 4;
        int[] sections = {2, 3, 6};
        assertThat(test.solution(wallLength, rulerLength, sections))
            .isEqualTo(2);
    }

    @Test
    void solution2() {
        int wallLength = 5;
        int rulerLength = 4;
        int[] sections = {1, 3};
        assertThat(test.solution(wallLength, rulerLength, sections))
            .isEqualTo(1);
    }

    @Test
    void solution3() {
        int wallLength = 5;
        int rulerLength = 1;
        int[] sections = {1, 2, 3, 4, 5};
        assertThat(test.solution(wallLength, rulerLength, sections))
            .isEqualTo(5);
    }
}
