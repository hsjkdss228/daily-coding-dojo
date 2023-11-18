import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PrimeNumberCounterTest {

    private PrimeNumberCounter test;

    @BeforeEach
    void setUp() {
        test = new PrimeNumberCounter();
    }

    @Test
    void toKNaryString() {
        assertThat(test.toKNaryNumber(13, 3)).isEqualTo("111");
        assertThat(test.toKNaryNumber(13, 8)).isEqualTo("15");
    }

    @Test
    void split1() {
        assertThat(test.split("211020101011"))
            .isEqualTo(new String[]{"211", "2", "1", "1", "11"});
    }

    @Test
    void split2() {
        assertThat(test.split("2110000011"))
            .isEqualTo(new String[]{"211", "", "", "", "", "11"});
    }

    @Test
    void split3() {
        assertThat(test.split("202641"))
            .isEqualTo(new String[]{"2", "2641"});
    }

    @Test
    void isPrimeNumber1() {
        assertThat(test.isPrimeNumber(1)).isFalse();
    }

    @Test
    void isPrimeNumber2() {
        assertThat(test.isPrimeNumber(2)).isTrue();
    }

    @Test
    void isPrimeNumber16() {
        assertThat(test.isPrimeNumber(16)).isFalse();
    }

    @Test
    void isPrimeNumber17() {
        assertThat(test.isPrimeNumber(17)).isTrue();
    }

    @Test
    void isPrimeNumber331() {
        assertThat(test.isPrimeNumber(331)).isTrue();
    }

    @Test
    void isPrimeNumber2641() {
        assertThat(test.isPrimeNumber(2641)).isFalse();
    }

    @Test
    void countPrimeNumbers1() {
        assertThat(test.countPrimeNumbers(new String[]{})).isEqualTo(0);
    }

    @Test
    void countPrimeNumbers2() {
        assertThat(test.countPrimeNumbers(new String[]{"2", "2641"})).isEqualTo(1);
    }

    @Test
    void solution1() {
        assertThat(test.solution(437674, 3)).isEqualTo(3);
    }

    @Test
    void solution2() {
        assertThat(test.solution(110011, 10)).isEqualTo(2);
    }

    @Test
    void solution3() {
        assertThat(test.solution(1, 3)).isEqualTo(0);
    }

    @Test
    void solution4() {
        assertThat(test.solution(2, 3)).isEqualTo(1);
    }

    @Test
    void solution5() {
        assertThat(test.solution(9, 10)).isEqualTo(0);
    }

    @Test
    void solution6() {
        assertThat(test.solution(1_000_000, 9)).isEqualTo(0);
    }

    @Test
    void solution7() {
        assertThat(test.solution(34_623, 7)).isEqualTo(1);
    }

    @Test
    void solution8() {
        assertThat(test.solution(1_000_000, 10)).isEqualTo(0);
    }
}
