import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RemoveElementTest {
    private RemoveElement1 test1;
    private RemoveElement2 test2;

    @BeforeEach
    void setUp() {
        test1 = new RemoveElement1();
        test2 = new RemoveElement2();
    }

    @Test
    void initIndexMoved() {
        int[] numbers = {0, 1, 2, 2, 3, 0, 4, 2};
        int value = 2;
        assertThat(test1.initIndexMoved(numbers, value))
            .isEqualTo(6);
    }

    @Test
    void initIndexMoved2() {
        int[] numbers = {2, 2, 2};
        int value = 2;
        assertThat(test1.initIndexMoved(numbers, value))
            .isEqualTo(0);
    }

    public void assertNumberContains(List<Integer> expectedNumbers,
                                     int[] numbers,
                                     int count) {
        int[] numbersNotEqualToValue = Arrays.copyOfRange(numbers, 0, count);
        for (int number : numbersNotEqualToValue) {
            assertThat(expectedNumbers).contains(number);
        }
    }

    @Test
    void solution1_1() {
        int[] numbers = {0, 1, 2, 2, 3, 0, 4, 2};
        int value = 2;
        int count = test1.removeElement(numbers, value);
        assertThat(count).isEqualTo(5);

        assertNumberContains(
            List.of(0, 1, 4, 0, 3),
            numbers,
            count
        );
    }

    @Test
    void solution1_2() {
        int[] numbers = {2, 2, 2};
        int value = 2;
        int count = test1.removeElement(numbers, value);
        assertThat(count).isEqualTo(0);

        assertNumberContains(
            List.of(),
            numbers,
            count
        );
    }

    @Test
    void solution1_3() {
        int[] numbers = {0, 1, 2, 2, 2, 0, 4, 2};
        int value = 2;
        int count = test1.removeElement(numbers, value);
        assertThat(count).isEqualTo(4);

        assertNumberContains(
            List.of(0, 1, 4, 0),
            numbers,
            count
        );
    }

    @Test
    void solution1_4() {
        int[] numbers = {2, 1, 2, 2, 2, 0, 4, 2};
        int value = 2;
        int count = test1.removeElement(numbers, value);
        assertThat(count).isEqualTo(3);

        assertNumberContains(
            List.of(4, 1, 0),
            numbers,
            count
        );
    }

    @Test
    void solution1_5() {
        int[] numbers = {2, 1, 2, 2, 2, 0, 1, 3, 4, 2, 2, 2, 5, 4, 2};
        int value = 2;
        int count = test1.removeElement(numbers, value);
        assertThat(count).isEqualTo(7);

        assertNumberContains(
            List.of(4, 1, 5, 4, 3, 0, 1),
            numbers,
            count
        );
    }

    @Test
    void solution1_6() {
        int[] numbers = {2};
        int value = 2;
        int count = test1.removeElement(numbers, value);
        assertThat(count).isEqualTo(0);

        assertNumberContains(
            List.of(),
            numbers,
            count
        );
    }

    @Test
    void solution1_7() {
        int[] numbers = {};
        int value = 2;
        int count = test1.removeElement(numbers, value);
        assertThat(count).isEqualTo(0);

        assertNumberContains(
            List.of(),
            numbers,
            count
        );
    }

    @Test
    void solution2_1() {
        int[] numbers = {0, 1, 2, 2, 3, 0, 4, 2};
        int value = 2;
        int count = test2.removeElement(numbers, value);
        assertThat(count).isEqualTo(5);

        assertNumberContains(
            List.of(0, 1, 4, 0, 3),
            numbers,
            count
        );
    }

    @Test
    void solution2_2() {
        int[] numbers = {2, 2, 2};
        int value = 2;
        int count = test2.removeElement(numbers, value);
        assertThat(count).isEqualTo(0);

        assertNumberContains(
            List.of(),
            numbers,
            count
        );
    }

    @Test
    void solution2_3() {
        int[] numbers = {0, 1, 2, 2, 2, 0, 4, 2};
        int value = 2;
        int count = test2.removeElement(numbers, value);
        assertThat(count).isEqualTo(4);

        assertNumberContains(
            List.of(0, 1, 4, 0),
            numbers,
            count
        );
    }

    @Test
    void solution2_4() {
        int[] numbers = {2, 1, 2, 2, 2, 0, 4, 2};
        int value = 2;
        int count = test2.removeElement(numbers, value);
        assertThat(count).isEqualTo(3);

        assertNumberContains(
            List.of(4, 1, 0),
            numbers,
            count
        );
    }

    @Test
    void solution2_5() {
        int[] numbers = {2, 1, 2, 2, 2, 0, 1, 3, 4, 2, 2, 2, 5, 4, 2};
        int value = 2;
        int count = test2.removeElement(numbers, value);
        assertThat(count).isEqualTo(7);

        assertNumberContains(
            List.of(4, 1, 5, 4, 3, 0, 1),
            numbers,
            count
        );
    }

    @Test
    void solution2_6() {
        int[] numbers = {2};
        int value = 2;
        int count = test2.removeElement(numbers, value);
        assertThat(count).isEqualTo(0);

        assertNumberContains(
            List.of(),
            numbers,
            count
        );
    }

    @Test
    void solution2_7() {
        int[] numbers = {};
        int value = 2;
        int count = test2.removeElement(numbers, value);
        assertThat(count).isEqualTo(0);

        assertNumberContains(
            List.of(),
            numbers,
            count
        );
    }
}
