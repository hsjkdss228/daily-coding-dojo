import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeNumberTest {
    private PrimeNumber6 test;

    @BeforeEach()
    void setUp() {
        test = new PrimeNumber6();
    }

    @Test
    void solution1() {
        assertThat(test.solution(10)).isEqualTo(4);
    }

    @Test
    void solution2() {
        assertThat(test.solution(5)).isEqualTo(3);
    }

    @Test
    void solutionContainTwo() {
        assertThat(test.solution(2)).isEqualTo(1);
    }

    @Test
    void solution3() {
        assertThat(test.solution(37)).isEqualTo(12);
    }

    @Test
    void solution4() {
        assertThat(test.solution(100)).isEqualTo(25);
    }
}
