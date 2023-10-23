import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatesFromSortedArrayTest {
    private RemoveDuplicatesFromSortedArray1 test1;
    private RemoveDuplicatesFromSortedArray2 test2;

    @BeforeEach
    void setUp() {
        test1 = new RemoveDuplicatesFromSortedArray1();
        test2 = new RemoveDuplicatesFromSortedArray2();
    }

    @Test
    void solution1_1() {
        int[] numbers = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int output = test1.removeDuplicates(numbers);
        assertThat(output).isEqualTo(5);

        int[] deDuplicated = {0, 1, 2, 3, 4};
        for (int i = 0; i < output; i += 1) {
            assertThat(numbers[i]).isEqualTo(deDuplicated[i]);
        }
    }

    @Test
    void solution2_1() {
        int[] numbers = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int output = test2.removeDuplicates(numbers);
        assertThat(output).isEqualTo(5);

        int[] deDuplicated = {0, 1, 2, 3, 4};
        for (int i = 0; i < output; i += 1) {
            assertThat(numbers[i]).isEqualTo(deDuplicated[i]);
        }
    }

    @Test
    void solution2_2() {
        int[] numbers = {0};
        int output = test2.removeDuplicates(numbers);
        assertThat(output).isEqualTo(1);

        int[] deDuplicated = {0};
        for (int i = 0; i < output; i += 1) {
            assertThat(numbers[i]).isEqualTo(deDuplicated[i]);
        }
    }
}
