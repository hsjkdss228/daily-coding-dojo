import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatesFromSortedArrayTest {
    private RemoveDuplicatesFromSortedArray2_1 test1;
    private RemoveDuplicatesFromSortedArray2_2 test2;
    private RemoveDuplicatesFromSortedArray2_3 test3;

    @BeforeEach
    void setUp() {
        test1 = new RemoveDuplicatesFromSortedArray2_1();
        test2 = new RemoveDuplicatesFromSortedArray2_2();
        test3 = new RemoveDuplicatesFromSortedArray2_3();
    }

    void judge(RemoveDuplicatesFromSortedArray2 test,
               int[] numbers,
               int expectedCount,
               int[] deDuplicated) {
        int count = test.removeDuplicates(numbers);
        assertThat(count).isEqualTo(expectedCount);
        for (int i = 0; i < count; i += 1) {
            assertThat(numbers[i]).isEqualTo(deDuplicated[i]);
        }
    }

    @Test
    void solution1_1() {
        int[] numbers = {1, 1, 1, 2, 2, 3};
        int expectedCount = 5;
        int[] deDuplicated = {1, 1, 2, 2, 3};
        judge(test1, numbers, expectedCount, deDuplicated);
    }

    @Test
    void solution1_2() {
        int[] numbers = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int expectedCount = 7;
        int[] deDuplicated = {0, 0, 1, 1, 2, 3, 3};
        judge(test1, numbers, expectedCount, deDuplicated);
    }

    @Test
    void solution2_1() {
        int[] numbers = {1, 1, 1, 2, 2, 3};
        int expectedCount = 5;
        int[] deDuplicated = {1, 1, 2, 2, 3};
        judge(test2, numbers, expectedCount, deDuplicated);
    }

    @Test
    void solution2_2() {
        int[] numbers = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int expectedCount = 7;
        int[] deDuplicated = {0, 0, 1, 1, 2, 3, 3};
        judge(test2, numbers, expectedCount, deDuplicated);
    }

    @Test
    void solution2_3() {
        int[] numbers = {1};
        int expectedCount = 1;
        int[] deDuplicated = {1};
        judge(test2, numbers, expectedCount, deDuplicated);
    }

    @Test
    void solution2_4() {
        int[] numbers = {1, 1};
        int expectedCount = 2;
        int[] deDuplicated = {1, 1};
        judge(test2, numbers, expectedCount, deDuplicated);
    }

    @Test
    void solution2_5() {
        int[] numbers = {1, 2};
        int expectedCount = 2;
        int[] deDuplicated = {1, 2};
        judge(test2, numbers, expectedCount, deDuplicated);
    }
    
    @Test
    void solution3_1() {
        int[] numbers = {1, 1, 1, 2, 2, 3};
        int expectedCount = 5;
        int[] deDuplicated = {1, 1, 2, 2, 3};
        judge(test3, numbers, expectedCount, deDuplicated);
    }

    @Test
    void solution3_2() {
        int[] numbers = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        int expectedCount = 7;
        int[] deDuplicated = {0, 0, 1, 1, 2, 3, 3};
        judge(test3, numbers, expectedCount, deDuplicated);
    }

    @Test
    void solution3_3() {
        int[] numbers = {1};
        int expectedCount = 1;
        int[] deDuplicated = {1};
        judge(test3, numbers, expectedCount, deDuplicated);
    }

    @Test
    void solution3_4() {
        int[] numbers = {1, 1};
        int expectedCount = 2;
        int[] deDuplicated = {1, 1};
        judge(test3, numbers, expectedCount, deDuplicated);
    }

    @Test
    void solution3_5() {
        int[] numbers = {1, 2};
        int expectedCount = 2;
        int[] deDuplicated = {1, 2};
        judge(test3, numbers, expectedCount, deDuplicated);
    }
}
