import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DevelopPeriodTest {
    @Test
    void solution1() {
        DevelopPeriod test = new DevelopPeriod();

        int[] progresses = new int[]{93, 30, 55};
        int[] speeds = new int[]{1, 30, 5};
        assertThat(test.solution(progresses, speeds))
            .isEqualTo(new int[]{2, 1});
    }

    @Test
    void solution2() {
        DevelopPeriod test = new DevelopPeriod();

        int[] progresses = new int[]{95, 90, 99, 99, 80, 99};
        int[] speeds = new int[]{1, 1, 1, 1, 1, 1};
        assertThat(test.solution(progresses, speeds))
            .isEqualTo(new int[]{1, 3, 2});
    }
}
