import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MajorityElementTest {
    private MajorityElement3 test;

    @BeforeEach
    void setUp() {
        test = new MajorityElement3();
    }

    @Test
    void solution1() {
        int[] numbers = {3, 2, 3};
        assertThat(test.majorityElement(numbers)).isEqualTo(3);
    }

    @Test
    void solution2() {
        int[] numbers = {2, 2, 1, 1, 1, 2, 2};
        assertThat(test.majorityElement(numbers)).isEqualTo(2);
    }

    @Test
    void solution3() {
        int[] numbers = {4, 1, 4, 4, 4, 3, 2, 6, 4, 4, 7};
        assertThat(test.majorityElement(numbers)).isEqualTo(4);
    }
}
