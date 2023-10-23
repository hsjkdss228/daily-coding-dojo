import java.util.ArrayList;
import java.util.List;

public class LargeNumbersAfterTimeout {
    public int[] solution(int[] numbers) {
        int[] result = new int[numbers.length];
        List<Integer> largesAfter = new ArrayList<>();
        result[result.length - 1] = -1;
        largesAfter.add(numbers[numbers.length - 1]);
        int currentLargest = result[result.length - 1];

        for (int index = result.length - 2; index >= 0; index -= 1) {
            int current = numbers[index];
            int nextIndex = index + 1;
            int next = numbers[nextIndex];
            int largeNext = result[nextIndex];
            int previousIndex = index - 1;
            int previous = previousIndex >= 0 ? numbers[previousIndex] : -1;

            int large = process(
                result, largesAfter,
                index, current, next, largeNext, previous,
                currentLargest
            );
            currentLargest = Math.max(large, currentLargest);
        }

        return result;
    }

    private int process(int[] results, List<Integer> largesAfter,
                        int currentIndex, int current,
                        int next, int largeNext, int previous,
                        int currentLargest) {
        if (current < next) {
            return putResult(
                results, largesAfter, currentIndex, next,
                current, previous
            );
        }

        // if (current >= next) &&
        if (largeNext == -1) {
            return putResult(
                results, largesAfter, currentIndex, -1,
                current, previous
            );
        }

        // if (current >= next && largeNext != 1) &&
        if (current < largeNext) {
            return putResult(
                results, largesAfter, currentIndex, largeNext,
                current, previous
            );
        }

        // if (current >= next && largeNext != 1 && current >= largeNext)
        if (current < currentLargest) {
            int foundLargeAfter = findLargeAfter(current, largesAfter);
            return putResult(
                results, largesAfter, currentIndex, foundLargeAfter,
                current, previous
            );
        }

        return putResult(
            results, largesAfter, currentIndex, -1,
            current, previous
        );
    }

    private int putResult(int[] results, List<Integer> largesAfter,
                          int currentIndex, int result,
                          int current, int previous) {
        results[currentIndex] = result;
        putLargesAfter(largesAfter, current, previous);
        return results[currentIndex];
    }

    public void putLargesAfter(List<Integer> largesAfter,
                               int current, int previous) {
        if (current > previous) {
            largesAfter.add(0, current);
        }
    }

    private int findLargeAfter(int current, List<Integer> largesAfter) {
        for (int largeAfter : largesAfter) {
            if (largeAfter > current) {
                return largeAfter;
            }
        }
        return -1;
    }
}
