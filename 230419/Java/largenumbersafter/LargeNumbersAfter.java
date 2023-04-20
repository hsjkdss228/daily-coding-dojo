import java.util.Stack;

public class LargeNumbersAfter {
    public int[] solution(int[] numbers) {
        Stack<Integer> uncheckedIndices = new Stack<>();
        int[] answer = new int[numbers.length];

        for (int index = 0; index < numbers.length; index += 1) {
            if (uncheckedIndices.isEmpty()) {
                uncheckedIndices.push(index);
                continue;
            }

            int current = numbers[index];
            while (!uncheckedIndices.isEmpty()
                && isLargerThan(current, numbers[uncheckedIndices.peek()])) {
                int uncheckedIndex = uncheckedIndices.pop();
                answer[uncheckedIndex] = current;
            }

            uncheckedIndices.push(index);
        }

        while (!uncheckedIndices.isEmpty()) {
            int uncheckedIndex = uncheckedIndices.pop();
            answer[uncheckedIndex] = -1;
        }

        return answer;
    }

    private boolean isLargerThan(int current, int unchecked) {
        return current > unchecked;
    }
}
