import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EnergyNeedTest {
    @Test
    void solution() {
        EnergyNeed test = new EnergyNeed();

        int energy = 80;
        int[][] dungeons = new int[][]{
            new int[]{80, 20},
            new int[]{50, 40},
            new int[]{30, 10},
        };
        assertThat(test.solution(energy, dungeons)).isEqualTo(3);
    }
}
