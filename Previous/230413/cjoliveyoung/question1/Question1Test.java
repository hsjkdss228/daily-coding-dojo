import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class Question1Test {
    private Question1 test;

    @BeforeEach
    void setUp() {
        test = new Question1();
    }

    @Test
    void nextNumber() {
        assertThat(test.nextNumber('8')).isEqualTo('9');
        assertThat(test.nextNumber('9')).isEqualTo('0');
    }

    @Test
    void eraseLastDigit() {
        assertThat(test.eraseLastDigit("12321")).isEqualTo("1232");
    }

    @Test
    void solution1() {
        assertThat(test.solution("12156")).isEqualTo(4);
    }

    @Test
    void solution2() {
        assertThat(test.solution("321")).isEqualTo(6);
    }

    @Test
    void solution3() {
        assertThat(test.solution("1234567")).isEqualTo(5);
    }

    @Test
    void solution4() {
        assertThat(test.solution("100")).isEqualTo(4);
    }

    @Test
    void solution5() {
        assertThat(test.solution("0")).isEqualTo(1);
    }

    @Test
    void solution6() {
        assertThat(test.solution("1")).isEqualTo(2);
    }

    @Test
    void solution7() {
        assertThat(test.solution("13")).isEqualTo(4);
    }
}
