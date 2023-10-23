public class SmallerSubstring {
    public int solution(String string1, String string2) {
        int count = 0;

        long number2 = Long.parseLong(string2);
        for (int i = 0; i <= string1.length() - string2.length(); i += 1) {
            String substring = string1.substring(i, i + string2.length());
            long number1 = Long.parseLong(substring);
            if (number1 <= number2) {
                count += 1;
            }
        }

        return count;
    }
}
