public class RemoveDuplicatesFromSortedArray2 {
    public int removeDuplicates(int[] numbers) {
        int indexToReassign = 1;

        for (int i = 1; i < numbers.length; i += 1) {
            if (numbers[indexToReassign - 1] == numbers[i]) {
                continue;
            }

            numbers[indexToReassign] = numbers[i];
            indexToReassign += 1;
        }

        return indexToReassign;
    }
}
