import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FindingDigitTest {
    private FindingDigit test;

    @BeforeEach
    void setUp() {
        test = new FindingDigit();
    }

    @Test
    void solution1() {
        int number = 29183;
        int digit = 1;
        assertThat(test.solution(number, digit)).isEqualTo(3);
    }

    @Test
    void solution2() {
        int number = 232443;
        int digit = 4;
        assertThat(test.solution(number, digit)).isEqualTo(4);
    }

    @Test
    void solution3() {
        int number = 123456;
        int digit = 7;
        assertThat(test.solution(number, digit)).isEqualTo(-1);
    }
}
