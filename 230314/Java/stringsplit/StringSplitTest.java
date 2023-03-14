import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringSplitTest {
    private StringSplit test;

    @BeforeEach
    void setUp() {
        test = new StringSplit();
    }

    @Test
    void solution1() {
        String string = "banana";
        assertThat(test.solution(string)).isEqualTo(3);
    }

    @Test
    void solution2() {
        String string = "abracadabra";
        assertThat(test.solution(string)).isEqualTo(6);
    }

    @Test
    void solution3() {
        String string = "aaabbaccccabba";
        assertThat(test.solution(string)).isEqualTo(3);
    }

    @Test
    void solution4() {
        String string = "aaaaaaaa";
        assertThat(test.solution(string)).isEqualTo(1);
    }
}
