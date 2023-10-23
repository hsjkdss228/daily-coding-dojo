import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Question8Test {
    @Test
    void solution() {
        Question8 test = new Question8();

        String message = "old macdonald had a farm";
        String target1 = "a";
        assertThat(test.solution(message, target1)).isEqualTo(4);

        String target2 = "old";
        assertThat(test.solution(message, target2)).isEqualTo(1);

        String target3 = "the";
        assertThat(test.solution(message, target3)).isEqualTo(0);
    }
}