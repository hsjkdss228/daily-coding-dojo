public class RemoveElement1 {
    public int removeElement(int[] numbers, int value) {
        int index = 0;
        int indexMoved = initIndexMoved(numbers, value);

        if (numbers.length == 0) {
            return 0;
        }

        int temp = 0;
        while (index < indexMoved) {

            if (numbers[index] == value) {
                temp = numbers[indexMoved];
                numbers[indexMoved] = numbers[index];
                numbers[index] = temp;
                while (numbers[indexMoved] == value) {
                    indexMoved -= 1;
                }
            }
            index += 1;
        }

        return numbers[index] == value ? index : index + 1;
    }

    public int initIndexMoved(int[] numbers, int value) {
        for (int i = numbers.length - 1; i >= 0; i -= 1) {
            if (numbers[i] != value) {
                return i;
            }
        }
        return 0;
    }
}
