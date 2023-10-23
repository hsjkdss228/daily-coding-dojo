import java.util.Stack;

public class BracketRotation {
    public int solution(String brackets) {
        int answer = 0;

        for (int i = 0; i < brackets.length(); i += 1) {
            if (isValid(brackets)) {
                answer += 1;
            }
            brackets = String.format("%s%s", brackets.substring(1), brackets.charAt(0));
        }

        return answer;
    }

    private boolean isValid(String brackets) {
        Stack<Character> stack = new Stack<>();

        for (char bracket : brackets.toCharArray()) {
            switch (bracket) {
                case '[', '{', '(' -> {
                    stack.push(bracket);
                }
                case ']' -> {
                    if (isValid(stack, '[')) {
                        return false;
                    }
                }
                case '}' -> {
                    if (isValid(stack, '{')) {
                        return false;
                    }
                }
                case ')' -> {
                    if (isValid(stack, '(')) {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }

    private boolean isValid(Stack<Character> stack, char bracket) {
        if (!stack.isEmpty() && stack.peek() == bracket) {
            stack.pop();
            return false;
        }
        return true;
    }
}
