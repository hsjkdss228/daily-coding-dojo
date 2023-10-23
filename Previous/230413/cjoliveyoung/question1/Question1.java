public class Question1 {
    public int solution(String number) {
        int count = 0;
        String typing = "";

        for (int index = 0; index < number.length(); index += 1) {
            if (alreadyTyped(index, typing)) {
                continue;
            }

            char digit = number.charAt(index);
            typing += digit;
            count += 1;
            if (digit != '0') {
                typing += nextNumber(digit);
            }

            if (!isLastIndex(index, number)) {
                char lastTypedDigit = typing.charAt(typing.length() - 1);
                char nextDigit = number.charAt(index + 1);
                if (lastTypedDigit != nextDigit) {
                    typing = eraseLastDigit(typing);
                    count += 1;
                }
                continue;
            }
            if (isLastIndex(index, number) && digit != '0') {
                typing = eraseLastDigit(typing);
                count += 1;
            }
        }

        return count;
    }

    public boolean alreadyTyped(int index, String typing) {
        return index >= 1 && index == typing.length() - 1;
    }

    public char nextNumber(char digit) {
        return digit == '9' ? '0' : (char) (digit + 1);
    }

    public boolean isLastIndex(int index, String number) {
        return index == number.length() - 1;
    }

    public String eraseLastDigit(String typing) {
        return typing.substring(0, typing.length() - 1);
    }
}
