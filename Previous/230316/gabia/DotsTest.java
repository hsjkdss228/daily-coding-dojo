import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DotsTest {
    private Dots test;

    @BeforeEach
    void setUp() {
        test = new Dots();
    }

    @Test
    void solution() {
        int[] dots = {1, 3, 4, 6, 7, 10};
        int[] lines = {2, 2, 2, 2};
        assertThat(test.solution(dots, lines)).isEqualTo(4);
    }
}