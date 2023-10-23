public class Question8 {
    public int solution(String s, String w) {
        String[] words = s.split(" ");

        for (int i = 0; i < words.length; i += 1) {
            if (words[i].equals(w)) {
                return i + 1;
            }
        }

        return 0;
    }
}
