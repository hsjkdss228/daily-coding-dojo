import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RotateTest {
    private Rotate2 test;

    @BeforeEach
    void setUp() {
        test = new Rotate2();
    }

    @Test
    void solution1() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        int times = 3;
        test.rotate(numbers, times);
        assertThat(numbers).isEqualTo(new int[]{5, 6, 7, 1, 2, 3, 4});
    }

    @Test
    void solution2() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        int times = 14;
        test.rotate(numbers, times);
        assertThat(numbers).isEqualTo(new int[]{1, 2, 3, 4, 5, 6, 7});
    }

    @Test
    void reverse() {
        int[] numbers = {1, 2, 3, 4, 5, 6, 7};
        int left = 0;
        int right = numbers.length - 1;
        test.reverse(numbers, left, right);
        assertThat(numbers).isEqualTo(new int[]{7, 6, 5, 4, 3, 2, 1});
    }
}
