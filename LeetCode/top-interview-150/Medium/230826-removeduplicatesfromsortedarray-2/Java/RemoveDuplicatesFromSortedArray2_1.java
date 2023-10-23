public class RemoveDuplicatesFromSortedArray2_1
    extends RemoveDuplicatesFromSortedArray2 {
    @Override
    public int removeDuplicates(int[] numbers) {
        if (numbers.length == 1) {
            return 1;
        }

        int indexReassigned = 1;
        int value = numbers[0];
        int valueCount = 1;

        for (int i = 1; i < numbers.length; i += 1) {
            // 값이 3개 이상 중복인 경우
            if (numbers[i] == value && valueCount >= 2) {
                continue;
            }

            // 값이 2개까지 중복인 경우
            if (numbers[i] == value && valueCount < 2) {
                numbers[indexReassigned] = value;
                indexReassigned += 1;
                valueCount += 1;
                continue;
            }

            // 새로운 값이 조회되었을 경우
            if (numbers[i] != value) {
                value = numbers[i];
                numbers[indexReassigned] = value;
                indexReassigned += 1;
                valueCount = 1;
            }
        }

        return indexReassigned;
    }
}
