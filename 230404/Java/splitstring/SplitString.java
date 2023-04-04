import java.util.ArrayList;
import java.util.List;

public class SplitString {
    public String[] solution1(String string, int length) {
        List<String> answer = new ArrayList<>();
        for (int start = 0; start < string.length(); start += length) {
            int end = Math.min(start + length, string.length());
            String part = string.substring(start, end);
            answer.add(part);
        }
        return answer.toArray(String[]::new);
    }

    public String[] solution2(String string, int length) {
        return string.split("(?<=\\G.{" + length + "})");
    }
}
