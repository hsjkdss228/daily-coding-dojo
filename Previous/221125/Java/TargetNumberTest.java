import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TargetNumberTest {
    @Test
    void solution() {
        TargetNumber test = new TargetNumber();
        int[] numbers = new int[]{1, 1, 1, 1, 1};
        int target = 3;
        assertThat(test.solution(numbers, target)).isEqualTo(5);
    }
}
