import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SameWordTest {
    @Test
    void solution1() {
        SameWord test = new SameWord();

        String word = "banana";
        assertThat(test.solution(word)).isEqualTo(
            new int[]{-1, -1, -1, 2, 2, 2}
        );
    }

    @Test
    void solution2() {
        SameWord test = new SameWord();

        String word = "foobar";
        assertThat(test.solution(word)).isEqualTo(
            new int[]{-1, -1, 1, -1, -1, -1}
        );
    }
}
