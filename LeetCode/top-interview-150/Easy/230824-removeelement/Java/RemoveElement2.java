public class RemoveElement2 {
    public int removeElement(int[] numbers, int value) {
        int indexToReassign = 0;

        for (int i = 0; i < numbers.length; i += 1) {
            if (numbers[i] != value) {
                numbers[indexToReassign] = numbers[i];
                indexToReassign += 1;
            }
        }

        return indexToReassign;
    }
}
