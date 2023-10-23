public class Babbling {
    public int solution(String[] babbling) {
        int pronounceableWords = 0;

        for (String word : babbling) {
            int index = 0;
            String last = "";
            boolean pronounceable = true;

            while (index < word.length()) {
                if (index > word.length() - 2) {
                    pronounceable = false;
                    break;
                }
                if (checkIfMatches(word, index, "ye")
                    && !last.equals("ye")) {
                    index += 2;
                    last = "ye";
                    continue;
                }
                if (checkIfMatches(word, index, "ma")
                    && !last.equals("ma")) {
                    index += 2;
                    last = "ma";
                    continue;
                }
                if (index > word.length() - 3) {
                    pronounceable = false;
                    break;
                }
                if (checkIfMatches(word, index, "aya")
                    && !last.equals("aya")) {
                    index += 3;
                    last = "aya";
                    continue;
                }
                if (checkIfMatches(word, index, "woo")
                    && !last.equals("woo")) {
                    index += 3;
                    last = "woo";
                    continue;
                }
                pronounceable = false;
                break;
            }

            if (pronounceable) {
                pronounceableWords += 1;
            }
        }

        return pronounceableWords;
    }

    public boolean checkIfMatches(String word, int index, String babbling) {
        for (int i = 0; i < babbling.length(); i += 1) {
            char characterOfWord = word.charAt(i + index);
            char characterOfBabbling = babbling.charAt(i);
            if (characterOfWord != characterOfBabbling) {
                return false;
            }
        }
        return true;
    }
}
