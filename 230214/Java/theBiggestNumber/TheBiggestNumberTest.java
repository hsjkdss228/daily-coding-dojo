import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TheBiggestNumberTest {
    @Test
    void compareDifferentNumberAndSameNumberOfDigits() {
        TheBiggestNumber test = new TheBiggestNumber();

        String previous = "9";
        String next = "8";
        int shorterLength = 1;
        assertThat(test.compare(previous, next, shorterLength))
            .isEqualTo(previous);
    }

    @Test
    void compareDifferentLastDigitAndSameNumberOfDigits() {
        TheBiggestNumber test = new TheBiggestNumber();

        String previous = "998";
        String next = "999";
        int shorterLength = 2;
        assertThat(test.compare(previous, next, shorterLength))
            .isEqualTo(next);
    }

    @Test
    void compareDifferentNumberOfDigits1() {
        TheBiggestNumber test = new TheBiggestNumber();

        String previous = "9";
        String next = "975";
        int shorterLength = 1;
        assertThat(test.compare(previous, next, shorterLength))
            .isEqualTo(previous);
    }

    @Test
    void joinNumbers() {
        TheBiggestNumber test = new TheBiggestNumber();

        String[] numbers = {"9", "997", "97531"};
        assertThat(test.join(numbers)).isEqualTo("999797531");
    }

    @Test
    void solution() {
        TheBiggestNumber test = new TheBiggestNumber();

        int[] numbers = {3, 30, 34, 5, 9};
        assertThat(test.solution(numbers)).isEqualTo("9534330");
    }
}
