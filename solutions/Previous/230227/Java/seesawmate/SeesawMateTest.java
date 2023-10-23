import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class SeesawMateTest {
    private SeesawMate test;

    @BeforeEach
    void setUp() {
        test = new SeesawMate();
    }

    @Test
    void pairsWithSameWeight() {
        int sameWeightCount = 5;
        assertThat(test.pairsWithSameWeight(sameWeightCount)).isEqualTo(10);
    }

    @Test
    void isMate1() {
        int base = 100;
        int other = 100;
        assertThat(test.isMate(base, other)).isTrue();
    }

    @Test
    void isMate2() {
        int base = 360;
        int other = 270;
        assertThat(test.isMate(base, other)).isTrue();
    }

    @Test
    void isMate3() {
        int base = 180;
        int other = 360;
        assertThat(test.isMate(base, other)).isTrue();
    }

    @Test
    void isNotMate() {
        int base = 100;
        int other = 270;
        assertThat(test.isMate(base, other)).isFalse();
    }

    @Test
    void solution1() {
        int[] weights = {100, 180, 360, 100, 270};
        assertThat(test.solution(weights)).isEqualTo(4);
    }
}
