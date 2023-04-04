import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PushingStringTest {
    private PushingString test;

    @BeforeEach
    void setUp() {
        test = new PushingString();
    }

    @Test
    void change() {
        String string = "hello";
        assertThat(test.change(string)).isEqualTo("ohell");
    }

    @Test
    void solution1() {
        String original = "hello";
        String target = "ohell";
        assertThat(test.solution(original, target)).isEqualTo(1);
    }

    @Test
    void solution2() {
        String original = "apple";
        String target = "elppa";
        assertThat(test.solution(original, target)).isEqualTo(-1);
    }

    @Test
    void solution3() {
        String original = "atat";
        String target = "tata";
        assertThat(test.solution(original, target)).isEqualTo(1);
    }

    @Test
    void solution4() {
        String original = "abc";
        String target = "abc";
        assertThat(test.solution(original, target)).isEqualTo(0);
    }
}
