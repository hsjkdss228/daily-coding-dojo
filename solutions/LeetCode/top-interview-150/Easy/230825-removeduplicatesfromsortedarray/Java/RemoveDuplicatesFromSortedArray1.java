public class RemoveDuplicatesFromSortedArray1 {
    public int removeDuplicates(int[] numbers) {
        int indexToReassign = 1;

        int value = numbers[0];
        for (int i = 1; i < numbers.length; i += 1) {
            if (value == numbers[i]) {
                continue;
            }

            value = numbers[i];
            numbers[indexToReassign] = value;
            indexToReassign += 1;
        }

        return indexToReassign;
    }
}
