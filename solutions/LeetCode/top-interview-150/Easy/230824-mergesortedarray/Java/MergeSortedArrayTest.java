import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MergeSortedArrayTest {
    private MergeSortedArray1 test1;
    private MergeSortedArray2 test2;

    @BeforeEach
    void setUp() {
        test1 = new MergeSortedArray1();
        test2 = new MergeSortedArray2();
    }

    @Test
    void combine() {
        int[] numbers1 = {1, 2, 3, 0, 0, 0};
        int[] numbers2 = {2, 5, 6};
        int length1 = 3;
        int length2 = 3;
        test1.combine(numbers1, numbers2, length1, length2);
        assertThat(numbers1)
            .isEqualTo(new int[]{1, 2, 3, 2, 5, 6});
    }

    @Test
    void solution1() {
        int[] numbers1 = {1, 2, 3, 0, 0, 0};
        int length1 = 3;
        int[] numbers2 = {2, 5, 6};
        int length2 = 3;
        test1.merge(numbers1, length1, numbers2, length2);
        assertThat(numbers1)
            .isEqualTo(new int[]{1, 2, 2, 3, 5, 6});
    }

    @Test
    void solution2() {
        int[] numbers1 = {1, 2, 3, 0, 0, 0};
        int length1 = 3;
        int[] numbers2 = {2, 5, 6};
        int length2 = 3;
        test2.merge(numbers1, length1, numbers2, length2);
        assertThat(numbers1)
            .isEqualTo(new int[]{1, 2, 2, 3, 5, 6});
    }
}
