public class LargeNumbersAfter {
    public int[] solution(int[] numbers) {
        int[] largesAfter = new int[numbers.length];
        largesAfter[largesAfter.length - 1] = -1;
        int currentLargest = largesAfter[largesAfter.length - 1];

        for (int index = largesAfter.length - 2; index >= 0; index -= 1) {
            int current = numbers[index];
            int nextIndex = index + 1;
            int next = numbers[nextIndex];
            int largeNext = largesAfter[nextIndex];

            int large = putLargeAfter(
                largesAfter,
                index, current, next, largeNext,
                currentLargest
            );
            currentLargest = Math.max(large, currentLargest);
        }

        return largesAfter;
    }

    private int putLargeAfter(int[] largesAfter,
                              int currentIndex, int current,
                              int next, int largeNext,
                              int currentLargest) {
        if (current < next) {
            largesAfter[currentIndex] = next;
            return largesAfter[currentIndex];
        }

        // if (current >= next) &&
        if (largeNext == -1) {
            largesAfter[currentIndex] = -1;
            return largesAfter[currentIndex];
        }

        // if (current >= next && largeNext != 1) &&
        if (current < largeNext) {
            largesAfter[currentIndex] = largeNext;
            return largesAfter[currentIndex];
        }

        // if (current >= next && largeNext != 1 && current >= largeNext)
        if (current < currentLargest) {
            largesAfter[currentIndex] = currentLargest;
            return largesAfter[currentIndex];
        }

        largesAfter[currentIndex] = -1;
        return largesAfter[currentIndex];
    }
}
