import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PreQuestionTest {
    @Test
    void solution1() {
        PreQuestion question = new PreQuestion();
        int[] A = new int[]{1, 3, 4, 6, 1, 2};
        assertThat(question.solution(A)).isEqualTo(5);
    }

    @Test
    void solution2() {
        PreQuestion question = new PreQuestion();
        int[] A = new int[]{-1, -3};
        assertThat(question.solution(A)).isEqualTo(1);
    }

    @Test
    void solution3() {
        PreQuestion question = new PreQuestion();
        int[] A = new int[]{-1, 0};
        assertThat(question.solution(A)).isEqualTo(1);
    }

    @Test
    void solution4() {
        PreQuestion question = new PreQuestion();
        int[] A = new int[]{-1, -1, -1, -1, 1, 1, 1, 1};
        assertThat(question.solution(A)).isEqualTo(2);
    }
}
