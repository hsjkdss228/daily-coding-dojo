import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SortTest {
    private Sort test;

    @BeforeEach
    void setUp() {
        test = new Sort();
    }

    @Test
    void toLowercase() {
        assertThat("ABC".toLowerCase()).isEqualTo("abc");
    }

    @Test
    void solution1() {
        assertThat(test.solution("Bcad")).isEqualTo("abcd");
    }

    @Test
    void solution2() {
        assertThat(test.solution("heLLo")).isEqualTo("ehllo");
    }

    @Test
    void solution3() {
        assertThat(test.solution("Python")).isEqualTo("hnopty");
    }
}
