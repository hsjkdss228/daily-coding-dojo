import java.util.ArrayList;
import java.util.List;

public class NewUsername {
    private List<String> words = new ArrayList<>();

    public String solution(String newUsername) {
        initialize(newUsername);

        phase1();
        phase2();
        phase3();
        phase4();
        phase5();
        phase6();
        phase7();

        return String.join("", words);
    }

    public String words() {
        return String.join("", words);
    }

    public void initialize(String newUsername) {
        for (int i = 0; i < newUsername.length(); i += 1) {
            String word = Character.toString(newUsername.charAt(i));
            words.add(word);
        }
    }

    public void phase1() {
        words.replaceAll(String::toLowerCase);
    }

    public void phase2() {
        List<String> temp = new ArrayList<>();

        for (String word : words) {
            char character = word.charAt(0);

            if ((character >= '0' && character <= '9')
                || (character >= 'a' && character <= 'z')
                || (character == '-')
                || (character == '_')
                || (character == '.')) {
                temp.add(word);
            }
        }

        words = temp;
    }

    public void phase3() {
        List<String> temp = new ArrayList<>();

        temp.add(words.get(0));

        for (int i = 1; i < words.size(); i += 1) {
            if (words.get(i - 1).equals(".") && words.get(i).equals(".")) {
                continue;
            }

            temp.add(words.get(i));
        }

        words = temp;
    }

    public void phase4() {
        if (words.size() == 0) {
            return;
        }

        if (words.get(words.size() - 1).equals(".")) {
            words.remove(words.size() - 1);
        }
        if (words.size() == 0) {
            return;
        }

        if (words.get(0).equals(".")) {
            words.remove(0);
        }
    }

    public void phase5() {
        if (words.size() == 0) {
            words.add("a");
        }
    }

    public void phase6() {
        List<String> temp = new ArrayList<>();

        if (words.size() < 16) {
            return;
        }

        for (int i = 0; i <= 14; i += 1) {
            temp.add(words.get(i));
        }

        if (temp.get(14).equals(".")) {
            temp.remove(14);
        }

        words = temp;
    }

    public void phase7() {
        if (words.size() <= 2) {
            while (words.size() < 3) {
                String word = words.get(words.size() - 1);
                words.add(word);
            }
        }
    }
}
