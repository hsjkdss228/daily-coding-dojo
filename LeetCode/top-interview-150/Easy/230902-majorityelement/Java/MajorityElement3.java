public class MajorityElement3 {
    public int majorityElement(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }

        int majority = numbers[0];
        int count = 0;

        for (int number : numbers) {
            if (count == 0) {
                majority = number;
                count += 1;
                continue;
            }
            if (count > 0) {
                count = (majority == number) ? count + 1 : count - 1;
            }
        }
        return majority;
    }
}
