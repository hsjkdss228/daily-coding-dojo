public class MergeSortedArray2 {
    public void merge(int[] numbers1,
                      int length1,
                      int[] numbers2,
                      int length2) {
        int[] numbers1Copied = new int[length1];
        System.arraycopy(numbers1, 0, numbers1Copied, 0, length1);

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < numbers1.length; i += 1) {
            if (index1 == length1) {
                numbers1[i] = numbers2[index2];
                index2 += 1;
                continue;
            }
            if (index2 == length2) {
                numbers1[i] = numbers1Copied[index1];
                index1 += 1;
                continue;
            }

            boolean numbers1IsSmall = numbers1Copied[index1] < numbers2[index2];
            numbers1[i] = numbers1IsSmall ? numbers1Copied[index1] : numbers2[index2];
            if (numbers1IsSmall) {
                index1 += 1;
                continue;
            }
            index2 += 1;
        }
    }
}
