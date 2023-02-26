import java.util.HashMap;
import java.util.Map;

public class SameWord {
    public int[] solution(String word) {
        int[] answer = new int[word.length()];

        Map<Character, Integer> recentIndices = new HashMap<>();
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet += 1) {
            recentIndices.put(alphabet, -1);
        }

        for (int index = 0; index < word.length(); index += 1) {
            char alphabet = word.charAt(index);
            Integer recentIndex = recentIndices.get(alphabet);
            answer[index] = recentIndex == -1
                ? -1
                : index - recentIndex;
            recentIndices.replace(alphabet, index);
        }

        return answer;
    }
}
