import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Yearning {
    public int[] solution(String[] names, int[] yearnings, String[][] photos) {
        Map<String, Integer> nameAndYearnings = pair(names, yearnings);
        return calculateScores(nameAndYearnings, photos);
    }

    public Map<String, Integer> pair(String[] names, int[] yearnings) {
        Map<String, Integer> nameAndYearnings = new HashMap<>();
        IntStream.range(0, names.length)
            .forEach(i -> nameAndYearnings.put(names[i], yearnings[i]));
        return nameAndYearnings;
    }

    public int[] calculateScores(Map<String, Integer> nameAndYearnings,
                                 String[][] photos) {
        int[] scores = new int[photos.length];
        IntStream.range(0, photos.length)
            .forEach(i -> {
                int sum = 0;
                String[] photo = photos[i];
                for (String name : photo) {
                    if (nameAndYearnings.containsKey(name)) {
                        sum += nameAndYearnings.get(name);
                    }
                }
//                int sum = Arrays.stream(photos[i])
//                    .reduce(0, (score, name) -> {
//                        return nameAndYearnings.containsKey(name)
//                            ? score + nameAndYearnings.get(name)
//                            : score;
//                    })
//                    .get();
                scores[i] = sum;
            });
        return scores;
    }
}
