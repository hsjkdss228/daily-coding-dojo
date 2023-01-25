import java.util.PriorityQueue;
import java.util.Queue;

public class Scoville {
    public int solution(int[] scovilles, int target) {
        Queue<Integer> scovillesChanged = new PriorityQueue<>();
        int count = 0;

        for (int scoville : scovilles) {
            scovillesChanged.add(scoville);
        }

        while (scovillesChanged.peek() < target) {
            if (scovillesChanged.size() == 1) {
                return -1;
            }

            int smallest = scovillesChanged.remove();
            int secondSmallest = scovillesChanged.remove();
            int newScoville = smallest + (secondSmallest * 2);
            scovillesChanged.add(newScoville);
            count += 1;
        }

        return count;
    }
}
