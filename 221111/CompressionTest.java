import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CompressionTest {
    @Test
    void solution() {
        Compression test = new Compression();

        assertThat(test.solution("KAKAO"))
            .isEqualTo(new int[]{11, 1, 27, 15});
        assertThat(test.solution("TOBEORNOTTOBEORTOBEORNOT"))
            .isEqualTo(new int[]{20, 15, 2, 5, 15, 18,
                14, 15, 20, 27, 29, 31, 36, 30, 32, 34});
        assertThat(test.solution("ABABABABABABABAB"))
            .isEqualTo(new int[]{1, 2, 27, 29, 28, 31, 30});
    }
}
