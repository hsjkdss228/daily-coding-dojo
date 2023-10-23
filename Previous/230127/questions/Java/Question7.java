public class Question7 {
    public static int[] solution(long a) {
        int[] counts = new int[10];

        String converted = Long.toString(a);
        for (int i = 0; i < converted.length(); i += 1) {
            int digit = Character.getNumericValue(converted.charAt(i));
            counts[digit] += 1;
        }

        return counts;
    }
}
