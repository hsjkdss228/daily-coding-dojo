import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class JaccardSimilarityTest {
    @Test
    void solution() {
        JaccardSimilarity test = new JaccardSimilarity();

        assertThat(test.solution("FRANCE", "french")).isEqualTo(16384);
        assertThat(test.solution("E=M*C^2", "e=m*c^2")).isEqualTo(65536);
        assertThat(test.solution("=*^", "=*^")).isEqualTo(65536);
    }

    @Test
    void sliceWord() {
        JaccardSimilarity test = new JaccardSimilarity();

        assertThat(test.sliceWord("france")).isEqualTo(
            List.of("fr", "ra", "an", "nc", "ce")
        );
        assertThat(test.sliceWord("france ")).isEqualTo(
            List.of("fr", "ra", "an", "nc", "ce")
        );
        assertThat(test.sliceWord("france +")).isEqualTo(
            List.of("fr", "ra", "an", "nc", "ce")
        );
        assertThat(test.sliceWord("+++")).isEqualTo(
            List.of()
        );
    }
}
