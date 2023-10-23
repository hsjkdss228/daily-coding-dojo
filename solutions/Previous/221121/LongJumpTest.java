import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LongJumpTest {
    @Test
    void solution() {
        LongJump test = new LongJump();

        assertThat(test.solution(4)).isEqualTo(5);
        assertThat(test.solution(5)).isEqualTo(8);
        assertThat(test.solution(3)).isEqualTo(3);
    }
}
