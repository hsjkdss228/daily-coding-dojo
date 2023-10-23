import java.util.Stack;

public class Cards {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Stack<String> unusedCards1 = new Stack<>();
        Stack<String> unusedCards2 = new Stack<>();
        Stack<String> remainedGoal = new Stack<>();

        pushWords(cards1, unusedCards1);
        pushWords(cards2, unusedCards2);
        pushWords(goal, remainedGoal);

        while (!remainedGoal.isEmpty()) {
            String target = remainedGoal.pop();
            if (!unusedCards1.isEmpty()
                && unusedCards1.peek().equals(target)) {
                unusedCards1.pop();
                continue;
            }
            if (!unusedCards2.isEmpty()
                && unusedCards2.peek().equals(target)) {
                unusedCards2.pop();
                continue;
            }
            return "No";
        }

        return "Yes";
    }

    public void pushWords(String[] array, Stack<String> stack) {
        for (int i = array.length - 1; i >= 0; i -= 1) {
            stack.push(array[i]);
        }
    }
}
