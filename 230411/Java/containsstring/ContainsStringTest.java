import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ContainsStringTest {
    private ContainsString test;

    @BeforeEach
    void setUp() {
        test = new ContainsString();
    }

    @Test
    void solution1() {
        String string1 = "ab6CDE443fgh22iJKlmn1o";
        String string2 = "6CD";
        assertThat(test.solution(string1, string2)).isTrue();
    }

    @Test
    void solution2() {
        String string1 = "ppprrrogrammers";
        String string2 = "pppp";
        assertThat(test.solution(string1, string2)).isFalse();
    }

    @Test
    void solution3() {
        String string1 = "AbcAbcA";
        String string2 = "AAA";
        assertThat(test.solution(string1, string2)).isFalse();
    }

    @Test
    void solution4() {
        String string1 = "p";
        String string2 = "p";
        assertThat(test.solution(string1, string2)).isTrue();
    }

    @Test
    void solution5() {
        String string1 = "pappap";
        String string2 = "ppap";
        assertThat(test.solution(string1, string2)).isTrue();
    }
}
