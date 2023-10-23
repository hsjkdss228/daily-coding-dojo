import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SevenTest {
    private Seven test;

    @BeforeEach
    void setUp() {
        test = new Seven();
    }

    @Test
    void solution1_1() {
        int[] array = {7, 77, 17};
        assertThat(test.solution1(array)).isEqualTo(4);
    }

    @Test
    void solution1_2() {
        int[] array = {10, 29};
        assertThat(test.solution1(array)).isEqualTo(0);
    }

    @Test
    void solution2_1() {
        int[] array = {7, 77, 17};
        assertThat(test.solution2(array)).isEqualTo(4);
    }

    @Test
    void solution2_2() {
        int[] array = {10, 29};
        assertThat(test.solution2(array)).isEqualTo(0);
    }
}
