import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SmallerSubstringTest {
    private SmallerSubstring test;

    @BeforeEach
    void setUp() {
        test = new SmallerSubstring();
    }

    @Test
    void parseLong() {
        assertThrows(NumberFormatException.class, () -> {
            Integer.parseInt("111111111111111111");
        });
        assertDoesNotThrow(() -> Long.parseLong("111111111111111111"));
    }

    @Test
    void substring() {
        assertThat("3141592".substring(0, 3)).isEqualTo("314");
    }

    @Test
    void substringWithIndexOutOfBounds() {
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            "3141592".substring(5, 8);
        });
    }

    @Test
    void parseIntStartsWith0() {
        assertThat(Integer.parseInt("02")).isEqualTo(2);
    }

    @Test
    void solution1() {
        String string1 = "3141592";
        String string2 = "271";
        assertThat(test.solution(string1, string2)).isEqualTo(2);
    }

    @Test
    void solution2() {
        String string1 = "500220839878";
        String string2 = "7";
        assertThat(test.solution(string1, string2)).isEqualTo(8);
    }

    @Test
    void solution3() {
        String string1 = "10203";
        String string2 = "15";
        assertThat(test.solution(string1, string2)).isEqualTo(3);
    }

    @Test
    void solution4() {
        String string1 = "102";
        String string2 = "102";
        assertThat(test.solution(string1, string2)).isEqualTo(1);
    }

    @Test
    void solution5() {
        String string1 = "1000";
        String string2 = "10";
        assertThat(test.solution(string1, string2)).isEqualTo(3);
    }

    @Test
    void solution6() {
        String string1 = "987654";
        String string2 = "12345";
        assertThat(test.solution(string1, string2)).isEqualTo(0);
    }
}
