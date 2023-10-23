import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddTwoNumbersTest {
    private AddTwoNumbers test;

    @BeforeEach
    void setUp() {
        test = new AddTwoNumbers();
    }

    @Test
    void solution1() {
        int[] numbers = new int[]{2, 1, 3, 4, 1};
        int[] result = new int[]{2, 3, 4, 5, 6, 7};
        assertThat(test.solution(numbers)).isEqualTo(result);
    }

    @Test
    void solution2() {
        int[] numbers = new int[]{5, 0, 2, 7};
        int[] result = new int[]{2, 5, 7, 9, 12};
        assertThat(test.solution(numbers)).isEqualTo(result);
    }
}
