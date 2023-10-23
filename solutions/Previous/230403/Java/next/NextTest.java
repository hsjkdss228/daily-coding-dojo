import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextTest {
    private Next test;

    @BeforeEach
    void setUp() {
        test = new Next();
    }

    @Test
    void solution1() {
        int[] common = {1, 2, 3, 4};
        assertThat(test.solution(common)).isEqualTo(5);
    }

    @Test
    void solution2() {
        int[] common = {2, 4, 8};
        assertThat(test.solution(common)).isEqualTo(16);
    }

    @Test
    void solution3() {
        int[] common = {2, -4, 8};
        assertThat(test.solution(common)).isEqualTo(-16);
    }

    @Test
    void solution4() {
        int[] common = {4, 3, 2, 1, 0, -1};
        assertThat(test.solution(common)).isEqualTo(-2);
    }

    @Test
    void solution5() {
        int[] common = {8, 5, 2, -1};
        assertThat(test.solution(common)).isEqualTo(-4);
    }

    @Test
    void solution6() {
        int[] common = {0, 4, 8};
        assertThat(test.solution(common)).isEqualTo(12);
    }
}
