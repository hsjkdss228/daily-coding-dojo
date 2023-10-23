import java.util.LinkedList;
import java.util.Queue;

public class Rotate1 {
    public void rotate(int[] numbers, int times) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = numbers.length - 1; i >= 0; i -= 1) {
            queue.add(numbers[i]);
        }

        for (int i = 0; i < times % numbers.length; i += 1) {
            int value = queue.poll();
            queue.add(value);
        }

        for (int i = numbers.length - 1; i >= 0; i -= 1) {
            numbers[i] = queue.poll();
        }
    }
}
