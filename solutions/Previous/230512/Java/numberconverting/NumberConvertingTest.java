import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NumberConvertingTest {
    private NumberConverting test;

    @BeforeEach
    void setUp() {
        test = new NumberConverting();
    }

    @Test
    void solution1() {
        int x = 10;
        int y = 40;
        int n = 5;
        assertThat(test.solution(x, y, n)).isEqualTo(2);
    }

    @Test
    void solution2() {
        int x = 10;
        int y = 40;
        int n = 30;
        assertThat(test.solution(x, y, n)).isEqualTo(1);
    }

    @Test
    void solution3() {
        int x = 2;
        int y = 5;
        int n = 4;
        assertThat(test.solution(x, y, n)).isEqualTo(-1);
    }
}
