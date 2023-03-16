import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BabblingTest {
    private Babbling test;

    @BeforeEach
    void setUp() {
        test = new Babbling();
    }

    @Test
    void checkIfMatches1() {
        String word = "ayaye";
        int index = 0;
        String babbling = "aya";
        assertThat(test.checkIfMatches(word, index, babbling)).isTrue();
    }

    @Test
    void checkIfMatches2() {
        String word = "yemawoo";
        int index = 2;
        String babbling = "ma";
        assertThat(test.checkIfMatches(word, index, babbling)).isTrue();
    }

    @Test
    void checkIfNotMatches1() {
        String word = "ayaye";
        int index = 3;
        String babbling = "aya";
        assertThat(test.checkIfMatches(word, index, babbling)).isFalse();
    }

    @Test
    void checkIfNotMatches2() {
        String word = "yemawoo";
        int index = 4;
        String babbling = "ye";
        assertThat(test.checkIfMatches(word, index, babbling)).isFalse();
    }

    @Test
    void solution() {
        String[] babbling = {"aya", "yee", "u", "maa"};
        assertThat(test.solution(babbling)).isEqualTo(1);
    }
}
