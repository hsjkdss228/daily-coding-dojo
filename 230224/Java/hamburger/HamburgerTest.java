import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HamburgerTest {
    @Test
    void solution1() {
        Hamburger test = new Hamburger();

        int[] ingredients = {2, 1, 1, 2, 3, 1, 2, 3, 1};
        assertThat(test.solution(ingredients)).isEqualTo(2);
    }

    @Test
    void solution2() {
        Hamburger test = new Hamburger();

        int[] ingredients = {1, 3, 2, 1, 2, 1, 3, 1, 2};
        assertThat(test.solution(ingredients)).isEqualTo(0);
    }
}
