import java.util.Arrays;

public class MergeSortedArray1 {
    public void merge(int[] numbers1,
                      int length1,
                      int[] numbers2,
                      int length2) {
        // numbers1의 나머지 공간에 number2를 삽입.
        combine(numbers1, numbers2, length1, length2);

        Arrays.sort(numbers1);
    }

    public void combine(int[] numbers1,
                        int[] numbers2,
                        int length1,
                        int length2) {
        for (int i = 0; i < length2; i += 1) {
            numbers1[length1 + i] = numbers2[i];
        }
    }
}
