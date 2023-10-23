import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Question2Test {
    @Test
    void solution1() {
        Question2 question2 = new Question2();
        int[] A = new int[]{4, 6, 2, 2, 6, 6, 1};
        assertThat(question2.solution(A)).isEqualTo(4);
    }

    @Test
    void solution2() {
        Question2 question2 = new Question2();
        int[] A = new int[]{4, 6, 5, 2, 6, 6, 1, 1, 1, 1, 5, 1};
        assertThat(question2.solution(A)).isEqualTo(8);
    }

    @Test
    void solution3() {
        Question2 question2 = new Question2();
        int[] A = new int[]{4, 6, 5, 2, 1, 6, 6, 1, 1, 1, 1, 5, 1, 1, 1, 1};
        assertThat(question2.solution(A)).isEqualTo(11);
    }
}
