import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Question3Test {
    private Question3 test;

    @BeforeEach
    void setUp() {
        test = new Question3();
    }

    @Test
    void solution1() {
        int count = 7;
        int[] scores = {81, 77, 70, 69, 69, 45, 33};
        String answer = "AABCCCC";
        assertThat(test.solution(count, scores)).isEqualTo(answer);
    }

    @Test
    void solution2() {
        int count = 14;
        int[] scores = {
            100, 100, 100, 100, 100, 100, 100,
            90,
            80, 80, 80, 80, 80, 80
        };
        String answer = "BBBBBBBBCCCCCC";
        assertThat(test.solution(count, scores)).isEqualTo(answer);
    }
}