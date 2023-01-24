import java.util.Stack;

public class Scoville {
    public int solution(int[] scovilles, int target) {
        Stack<Integer> scovillesChanged = new Stack<>();
        int count = 0;

        for (int i = scovilles.length - 1; i >= 0; i -= 1) {
            scovillesChanged.push(scovilles[i]);
        }

        while (scovillesChanged.peek() < target) {
            if (scovillesChanged.size() == 1) {
                return -1;
            }

            int smallest = scovillesChanged.pop();
            int secondSmallest = scovillesChanged.pop();

            int newScoville = smallest + (secondSmallest * 2);

            sortScovillesChanged(scovillesChanged, newScoville);

            count += 1;
        }

        return count;
    }

    public void sortScovillesChanged(Stack<Integer> scovillesChanged,
                                     int newScoville
    ) {
        Stack<Integer> tempForSort = new Stack<>();
        while (!scovillesChanged.isEmpty()
            && scovillesChanged.peek() < newScoville) {
            tempForSort.push(scovillesChanged.pop());
        }
        scovillesChanged.push(newScoville);
        while (!tempForSort.isEmpty()) {
            scovillesChanged.push(tempForSort.pop());
        }
    }
}
