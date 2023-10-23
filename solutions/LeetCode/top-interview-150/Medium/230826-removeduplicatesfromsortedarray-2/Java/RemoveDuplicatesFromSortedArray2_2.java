public class RemoveDuplicatesFromSortedArray2_2
    extends RemoveDuplicatesFromSortedArray2 {
    @Override
    public int removeDuplicates(int[] numbers) {
        if (numbers.length <= 2) {
            return numbers.length;
        }

        int indexReassigned = 2;

        for (int i = 2; i < numbers.length; i += 1) {
            // 값이 3개 이상 중복인 경우
            if (numbers[i] == numbers[indexReassigned - 1]
                && numbers[indexReassigned - 1] == numbers[indexReassigned - 2]) {
                continue;
            }

            // 값이 2개까지 중복인 경우
            if (numbers[i] == numbers[indexReassigned - 1]
                && numbers[indexReassigned - 1] != numbers[indexReassigned - 2]) {
                numbers[indexReassigned] = numbers[indexReassigned - 1];
                indexReassigned += 1;
                continue;
            }

            // 새로운 값이 조회되었을 경우
            if (numbers[i] != numbers[indexReassigned - 1]) {
                numbers[indexReassigned] = numbers[i];
                indexReassigned += 1;
            }
        }

        return indexReassigned;
    }
}
