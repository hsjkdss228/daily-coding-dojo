import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BracketConverterTest {

    private BracketConverter test;

    @BeforeEach
    void setUp() {
        test = new BracketConverter();
    }

    @Test
    void solution1() {
        assertThat(test.solution("(()())()")).isEqualTo("(()())()");
    }

    @Test
    void solution2() {
        assertThat(test.solution(")(")).isEqualTo("()");
    }

    @Test
    void solution3() {
        assertThat(test.solution("()))((()")).isEqualTo("()(())()");
    }
}
