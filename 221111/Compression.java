import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Compression {
    public int[] solution(String message) {
        Map<String, Integer> dictionary = new HashMap<>();

        List<Integer> answer = new ArrayList<>();

        int dictionaryIndex = 1;
        for (char i = 'A'; i <= 'Z'; i += 1) {
            dictionary.put(String.valueOf(i), dictionaryIndex);
            dictionaryIndex += 1;
        }

        int index = 0;
        while (index < message.length()) {
            String w = "";
            while (index < message.length()) {
                if (!dictionary.containsKey(w + message.charAt(index))) {
                    break;
                }
                if (dictionary.containsKey(w + message.charAt(index))) {
                    w += message.charAt(index);
                }
                index += 1;
            }

            answer.add(dictionary.get(w));

            if (index < message.length()) {
                dictionary.put(w + message.charAt(index), dictionaryIndex);
                dictionaryIndex += 1;
            }
        }

        return answer.stream()
            .mapToInt(number -> number)
            .toArray();
    }
}
