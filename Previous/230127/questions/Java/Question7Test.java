import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Question7Test {
    @Test
    void solution() {
        long digits = 133355555000L;
        assertThat(Question7.solution(digits))
            .isEqualTo(new int[]{3, 1, 0, 3, 0, 5, 0, 0, 0, 0});
    }
}