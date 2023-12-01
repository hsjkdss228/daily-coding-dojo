public class BracketConverter {
    public String solution(String balancedBrackets) {
        return process(balancedBrackets);
    }

    private boolean isOpener(char bracket) {
        return bracket == '(';
    }

    private String process(String brackets) {
        if (brackets.equals("")) {
            return "";
        }

        String[] twoBalancedBrackets = separateTwoBalancedBrackets(brackets);
        String first = twoBalancedBrackets[0];
        String second = twoBalancedBrackets[1];

        StringBuilder stringBuilder = new StringBuilder();

        if (isCorrectBrackets(first)) {
            stringBuilder.append(first);
            stringBuilder.append(process(second));
            return stringBuilder.toString();
        }

        stringBuilder.append('(');
        stringBuilder.append(process(second));
        stringBuilder.append(')');
        String firstSliced = sliceFirstAndLastIndex(first);
        String firstFlipped = flip(firstSliced);
        stringBuilder.append(firstFlipped);
        return stringBuilder.toString();
    }

    private String[] separateTwoBalancedBrackets(String brackets) {
        String[] twoBalancedBrackets = new String[2];

        StringBuilder stringBuilder = new StringBuilder();

        int openerCount = 0;
        int closerCount = 0;

        for (int index = 0; index < brackets.length(); index += 1) {
            char bracket = brackets.charAt(index);
            stringBuilder.append(bracket);
            if (isOpener(bracket)) {
                openerCount += 1;
            } else {
                closerCount += 1;
            }

            if (closerCount >= 1 && openerCount == closerCount) {
                twoBalancedBrackets[0] = stringBuilder.toString();
                twoBalancedBrackets[1] = index == brackets.length() - 1
                    ? ""
                    : brackets.substring(index + 1);
                break;
            }
        }

        return twoBalancedBrackets;
    }

    private boolean isCorrectBrackets(String brackets) {
        int bracketCheckCount = 0;

        for (int index = 0; index < brackets.length(); index += 1) {
            char bracket = brackets.charAt(index);
            if (isOpener(bracket)) {
                bracketCheckCount += 1;
            } else {
                bracketCheckCount -= 1;
            }

            if (bracketCheckCount < 0) {
                return false;
            }
        }

        return true;
    }

    private String sliceFirstAndLastIndex(String brackets) {
        return brackets.substring(1, brackets.length() - 1);
    }

    private String flip(String brackets) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int index = 0; index < brackets.length(); index += 1) {
            char bracket = brackets.charAt(index);
            if (isOpener(bracket)) {
                stringBuilder.append(')');
            } else {
                stringBuilder.append('(');
            }
        }

        return stringBuilder.toString();
    }
}
