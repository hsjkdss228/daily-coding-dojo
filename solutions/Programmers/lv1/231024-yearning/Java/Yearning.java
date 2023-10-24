import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Yearning {
    public int[] solution(String[] names, int[] yearnings, String[][] photos) {
        Map<String, Integer> nameToYearnings = pair(names, yearnings);

        return calculateYearningScore(nameToYearnings, photos);
    }

    private Map<String, Integer> pair(String[] names, int[] yearnings) {
        return IntStream.range(0, names.length)
            .boxed()
            .collect(Collectors.toMap(
                index -> names[index],
                index -> yearnings[index]
            ));
    }

    private int[] calculateYearningScore(Map<String, Integer> nameToYearnings,
                                         String[][] photos) {
        return Arrays.stream(photos)
            .map(photo -> Arrays.stream(photo)
                .map(name -> nameToYearnings.getOrDefault(name, 0))
                .toList()
                .stream()
                .reduce(0, Integer::sum))
            .mapToInt(value -> value)
            .toArray();
    }
}
