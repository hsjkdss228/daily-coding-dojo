import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Recommendation {
    public enum Option {
        SENTENCE_MATCH,
        WORD_MATCH;
    }

    public String[] solution(String[] histories,
                             String[][] rawOption,
                             String keyword) {
        List<String> answer = new ArrayList<>();
        Option option = decideOption(rawOption);

        Arrays.stream(histories)
            .forEach(history -> {
                if (option == Option.SENTENCE_MATCH
                    && history.equals(keyword)) {
                    answer.add(history);
                    return;
                }
                String[] words = history.split(" ");
                if (containsWord(words, keyword)) {
                    answer.add(history);
                }
            });

        return answer.toArray(String[]::new);
    }

    public Option decideOption(String[][] option) {
        return needWordMatch(option)
            ? Option.WORD_MATCH : Option.SENTENCE_MATCH;
    }

    public boolean needWordMatch(String[][] option) {
        return option.length != 0
            && option[0][1].equals("T");
    }

//        public boolean needSentenceMatch(String[][] option) {
//        return option.length == 0
//            || option[0][0].isBlank()
//            || option[0][1].equals("F");
//    }

    public boolean containsWord(String[] words, String keyword) {
        for (String word : words) {
            if (word.equals(keyword)) {
                return true;
            }
        }
        return false;
    }
}
