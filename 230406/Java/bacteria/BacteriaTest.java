import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BacteriaTest {
    private Bacteria test;

    @BeforeEach
    void setUp() {
        test = new Bacteria();
    }

    @Test
    void solution1() {
        int initialCount = 2;
        int hour = 10;
        assertThat(test.solution(initialCount, hour)).isEqualTo(2048);
    }

    @Test
    void solution2() {
        int initialCount = 7;
        int hour = 15;
        assertThat(test.solution(initialCount, hour)).isEqualTo(229376);
    }
}
