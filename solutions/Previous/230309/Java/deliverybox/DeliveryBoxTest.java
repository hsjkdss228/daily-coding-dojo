import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DeliveryBoxTest {
    private DeliveryBox test;

    @BeforeEach
    void setUp() {
        test = new DeliveryBox();
    }

    @Test
    void solution1() {
        int[] orders = {4, 3, 1, 2, 5};
        assertThat(test.solution(orders)).isEqualTo(2);
    }

    @Test
    void solution2() {
        int[] orders = {5, 4, 3, 2, 1};
        assertThat(test.solution(orders)).isEqualTo(5);
    }

    @Test
    void solution3() {
        int[] orders = {1, 2, 4, 3, 5};
        assertThat(test.solution(orders)).isEqualTo(5);
    }
}
