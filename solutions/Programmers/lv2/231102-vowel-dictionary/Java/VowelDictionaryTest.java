import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class VowelDictionaryTest {
    private VowelDictionaryRecursive test;

    @BeforeEach
    void setUp() {
        test = new VowelDictionaryRecursive();
    }

    @Test
    void solution1() {
        String word = "AAAAE";
        assertThat(test.solution(word)).isEqualTo(6);
    }

    @Test
    void solution2() {
        String word = "AAAE";
        assertThat(test.solution(word)).isEqualTo(10);
    }

    @Test
    void solution3() {
        String word = "I";
        assertThat(test.solution(word)).isEqualTo(1563);
    }

    @Test
    void solution4() {
        String word = "EIO";
        assertThat(test.solution(word)).isEqualTo(1189);
    }
}
