import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;

class Question1And2Test {
    private Question1And2 test;

    @BeforeEach
    void setUp() {
        test = new Question1And2();
    }

    @Test
    void sorted() {
        int[] scores = {70, 45, 63, 69, 77, 81, 33, 100, 75, 10};
        int[] sorted = {100, 81, 77, 75, 70, 69, 63, 45, 33, 10};
        assertThat(Arrays.stream(scores)
            .boxed()
            .sorted(Collections.reverseOrder())
            .mapToInt(score -> score)
            .toArray()).isEqualTo(sorted);
    }

    @Test
    void solution1() {
        int count = 10;
        int[] scores = {70, 45, 63, 69, 77, 81, 33, 100, 75, 10};
        String answer = "BCBBAACABC";
        assertThat(test.solution(count, scores)).isEqualTo(answer);
    }

    @Test
    void solution2() {
        int count = 13;
        int[] scores = {13, 12, 11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        String answer = "AAABBBBBBCCCC";
        assertThat(test.solution(count, scores)).isEqualTo(answer);
    }
}
