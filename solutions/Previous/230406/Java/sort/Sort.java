import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Sort {
    public String solution(String string) {
        String[] alphabets = string.toLowerCase().split("");
        return Arrays.stream(alphabets)
            .sorted(Comparator.naturalOrder())
            .collect(Collectors.joining());
    }
}
