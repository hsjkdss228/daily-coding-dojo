import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {
    private Solution test;

    @BeforeEach
    void setUp() {
        test = new Solution();
    }

    @Test
    void solution() {
        String[][] adInfos = {
            {"A", "5", "20"},
            {"B", "3", "5"}
        };
        String[][] logs = {
            {"C", "A"},
            {"V", "B"},
            {"C", "B"}
        };
        assertThat(test.solution(adInfos, logs)).isEqualTo("A");
    }
}