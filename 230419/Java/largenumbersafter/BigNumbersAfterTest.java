import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BigNumbersAfterTest {
    private BigNumbersAfter test;

    @BeforeEach
    void setUp() {
        test = new BigNumbersAfter();
    }

    @Test
    void solution1() {
        int[] numbers = {2, 3, 3, 5};
        int[] result = {3, 5, 5, -1};
        assertThat(test.solution(numbers)).isEqualTo(result);
    }

    @Test
    void solution2() {
        int[] numbers = {9, 1, 5, 3, 6, 2};
        int[] result = {-1, 5, 6, 6, -1, -1};
        assertThat(test.solution(numbers)).isEqualTo(result);
    }

    @Test
    void solution3() {
        int[] numbers = {1, 2, 3, 4, 5, 6};
        int[] result = {2, 3, 4, 5, 6, -1};
        assertThat(test.solution(numbers)).isEqualTo(result);
    }

    @Test
    void solution4() {
        int[] numbers = {6, 5, 4, 3, 2, 1};
        int[] result = {-1, -1, -1, -1, -1, -1};
        assertThat(test.solution(numbers)).isEqualTo(result);
    }

    @Test
    void solution5() {
        int[] numbers = {2, 1, 4, 4, 6, 1};
        int[] result = {4, 4, 6, 6, -1, -1};
        assertThat(test.solution(numbers)).isEqualTo(result);
    }

    @Test
    void solution6() {
        int[] numbers = {2, 1, 4, 1, 6, 1, 8, 1};
        int[] result = {4, 4, 6, 6, 8, 8, -1, -1};
        assertThat(test.solution(numbers)).isEqualTo(result);
    }

    @Test
    void solution7() {
        int[] numbers = {2, 1, 8, 1, 6, 1, 12, 1};
        int[] result = {8, 8, 12, 6, 12, 12, -1, -1};
        assertThat(test.solution(numbers)).isEqualTo(result);
    }

    @Test
    void solution8() {
        int[] numbers = {8, 1, 2, 9};
        int[] result = {9, 2, 9, -1};
        assertThat(test.solution(numbers)).isEqualTo(result);
    }
}
