import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FoodFightTest {
    private FoodFight test;

    @BeforeEach
    void setUp() {
        test = new FoodFight();
    }

    @Test
    void solution1() {
        int[] foods = {1, 3, 4, 6};
        assertThat(test.solution(foods)).isEqualTo("1223330333221");
    }

    @Test
    void solution2() {
        int[] foods = {1, 7, 1, 2};
        assertThat(test.solution(foods)).isEqualTo("111303111");
    }
}
