import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Coating {
    public int solution(int wallLength, int rulerLength, int[] sections) {
        List<Integer> uncoatedSections = Arrays.stream(sections)
            .boxed()
            .collect(Collectors.toList());

        int coatingCount = 0;
        while (!uncoatedSections.isEmpty()) {
            int startingPoint = uncoatedSections.get(0);
            int endingPoint = startingPoint + rulerLength;
            while (!uncoatedSections.isEmpty()
                && uncoatedSections.get(0) < endingPoint) {
                uncoatedSections.remove(0);
            }
            coatingCount += 1;
        }

        return coatingCount;
    }
}
