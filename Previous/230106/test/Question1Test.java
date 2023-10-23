import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Question1Test {
    @Test
    void solutionCase1() {
        Question1 question1 = new Question1();
        int[] A = new int[]{1, 1, 2, 2, 3};
        int K = 3;
        assertThat(question1.solution(A, K)).isTrue();
    }

    @Test
    void solutionCase2() {
        Question1 question1 = new Question1();
        int[] A = new int[]{1, 1, 3};
        int K = 2;
        assertThat(question1.solution(A, K)).isFalse();
    }

    @Test
    void test1() {
        Question1 question1 = new Question1();
        int[] A = new int[]{1, 1, 1, 1, 1};
        int K = 2;
        assertThat(question1.solution(A, K)).isFalse();
    }

    @Test
    void test2() {
        Question1 question1 = new Question1();
        int[] A = new int[]{1, 1, 2, 2, 3, 4};
        int K = 3;
        assertThat(question1.solution(A, K)).isTrue();
    }

    @Test
    void test3() {
        Question1 question1 = new Question1();
        int[] A = new int[]{1, 2, 3, 4, 5, 6};
        int K = 3;
        assertThat(question1.solution(A, K)).isTrue();
    }

    @Test
    void test4() {
        Question1 question1 = new Question1();
        int[] A = new int[]{1, 2, 3, 4, 5, 6};
        int K = 6;
        assertThat(question1.solution(A, K)).isTrue();
    }

    @Test
    void test5() {
        Question1 question1 = new Question1();
        int[] A = new int[]{1, 2, 3, 4, 5, 6};
        int K = 7;
        assertThat(question1.solution(A, K)).isFalse();
    }

    @Test
    void test6() {
        Question1 question1 = new Question1();
        int[] A = new int[]{1, 2, 4, 5, 6};
        int K = 2;
        assertThat(question1.solution(A, K)).isTrue();
    }

    @Test
    void test7() {
        Question1 question1 = new Question1();
        int[] A = new int[]{1, 3, 4};
        int K = 1;
        assertThat(question1.solution(A, K)).isTrue();
    }
}
