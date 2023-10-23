public class RemoveDuplicatesFromSortedArray2_3
    extends RemoveDuplicatesFromSortedArray2 {
    @Override
    public int removeDuplicates(int[] numbers) {
        if (numbers.length <= 2) {
            return numbers.length;
        }

        int indexReassigned = 2;

        for (int i = 2; i < numbers.length; i += 1) {
            if (numbers[i] != numbers[indexReassigned - 2]) {
                numbers[indexReassigned] = numbers[i];
                indexReassigned += 1;
            }
        }

        return indexReassigned;
    }
}
