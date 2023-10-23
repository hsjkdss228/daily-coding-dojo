import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Dots {
    public int solution(int[] dots, int[] lines) {
        List<Integer> dotsList = Arrays.stream(dots)
            .boxed()
            .collect(Collectors.toList());
        List<Integer> linesList = Arrays.stream(lines)
            .boxed()
            .collect(Collectors.toList());

        int answer = 0;
        while (!linesList.isEmpty()) {
            for (int i = 0; i < dotsList.size(); i += 1) {

            }
            int length = dotsList.get(1) - dotsList.get(0);
            for (int j = 0; j < linesList.size(); j += 1) {
                int line = linesList.get(j);
                if (length <= line) {
                    dotsList.remove(0);
                    dotsList.remove(1);
                    linesList.remove(j);
                    answer += 1;
                    break;
                }
            }
        }

        return answer;
    }
}
