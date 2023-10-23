import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class ConsecutiveNumbers {
    public int[] solution(int count, int total) {
        List<Integer> answer = new LinkedList<>();
        IntStream.range(0, count)
            .forEach(answer::add);

        int min = answer.get(0);
        int max = answer.get(answer.size() - 1);
        int sum = answer.stream()
            .reduce(Integer::sum)
            .get();
        while (sum != total) {
            if (sum < total) {
                max += 1;
                sum = sum - answer.remove(0) + max;
                answer.add(max);
                continue;
            }
            min -= 1;
            sum = sum - answer.remove(answer.size() - 1) + min;
            answer.add(0, min);
        }

        return answer.stream()
            .mapToInt(value -> value)
            .toArray();
    }
}
