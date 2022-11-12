import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RescueBoatTest {
    @Test
    void solutionCase1() {
        RescueBoat test = new RescueBoat();

        int[] weights = new int[]{70, 50, 80, 50};
        int limit = 100;
        assertThat(test.solution(weights, limit)).isEqualTo(3);
    }

    @Test
    void solutionCase2() {
        RescueBoat test = new RescueBoat();

        int[] weights = new int[]{70, 50, 80};
        int limit = 100;
        assertThat(test.solution(weights, limit)).isEqualTo(3);
    }
}
