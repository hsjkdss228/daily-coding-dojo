import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class SplitStringTest {
    private SplitString test;

    @BeforeEach
    void setUp() {
        test = new SplitString();
    }

    @Test
    void solution1_1() {
        String string = "abc1Addfggg4556b";
        int length = 6;
        assertThat(test.solution1(string, length))
            .isEqualTo(new String[]{"abc1Ad", "dfggg4", "556b"});
    }

    @Test
    void solution1_2() {
        String string = "abcdef123";
        int length = 3;
        assertThat(test.solution1(string, length))
            .isEqualTo(new String[]{"abc", "def", "123"});
    }

    @Test
    void solution2_1() {
        String string = "abc1Addfggg4556b";
        int length = 6;
        assertThat(test.solution2(string, length))
            .isEqualTo(new String[]{"abc1Ad", "dfggg4", "556b"});
    }

    @Test
    void solution2_2() {
        String string = "abcdef123";
        int length = 3;
        assertThat(test.solution2(string, length))
            .isEqualTo(new String[]{"abc", "def", "123"});
    }
}
