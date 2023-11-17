import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class QueueEqualizerTest {
    private QueueEqualizer test;

    @BeforeEach
    void setUp() {
        test = new QueueEqualizer();
    }

    @Test
    void solution1() {
        int[] queue1 = {3, 2, 7, 2};
        int[] queue2 = {4, 6, 5, 1};
        assertThat(test.solution(queue1, queue2)).isEqualTo(2);
    }

    @Test
    void solution2() {
        int[] queue1 = {1, 2, 1, 2};
        int[] queue2 = {1, 10, 1, 2};
        assertThat(test.solution(queue1, queue2)).isEqualTo(7);
    }

    @Test
    void solution3() {
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};
        assertThat(test.solution(queue1, queue2)).isEqualTo(-1);
    }

    @Test
    void solution4() {
        int[] queue1 = {1, 1, 1, 1, 1};
        int[] queue2 = {1, 1, 1, 9, 1};
        assertThat(test.solution(queue1, queue2)).isEqualTo(12);
    }
}
