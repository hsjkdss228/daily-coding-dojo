import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AddingDigitsTest {
    @Test
    void split() {
        String number = "1214";
        String[] digits = {"1", "2", "1", "4"};
        assertThat(number.split("")).isEqualTo(digits);
    }
}
