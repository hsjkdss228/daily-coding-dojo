import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DiscountTest {
    private Discount test;

    @BeforeEach
    void setUp() {
        test = new Discount();
    }

    @Test
    void solution1() {
        String[] wants = {"banana", "apple", "rice", "pork", "pot"};
        int[] numbers = {3, 2, 2, 2, 1};
        String[] discounts = {
            "chicken", "apple", "apple", "banana", "rice",
            "apple", "pork", "banana", "pork", "rice",
            "pot", "banana", "apple", "banana"
        };
        assertThat(test.solution(wants, numbers, discounts)).isEqualTo(3);
    }

    @Test
    void solution2() {
        String[] wants = {"apple"};
        int[] numbers = {10};
        String[] discounts = {
            "banana", "banana", "banana", "banana", "banana",
            "banana", "banana", "banana", "banana", "banana"
        };
        assertThat(test.solution(wants, numbers, discounts)).isEqualTo(0);
    }
}
