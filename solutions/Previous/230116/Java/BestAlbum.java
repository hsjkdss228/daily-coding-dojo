import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BestAlbum {
    private Map<String, Integer> genresAndPlaySums = new HashMap<>();
    private Map<String, List<Integer>> genresAndIndices = new HashMap<>();
    private Map<String, List<Integer>> genresAndPlays = new HashMap<>();

    public int[] solution(String[] genres, int[] plays) {
        initData(genres, plays);

        List<Map.Entry<String, Integer>> sortedGenresAndPlaySums
            = sortGenresAndPlaySums(genresAndPlaySums);
        List<String> sortedGenres = sortedGenresAndPlaySums.stream()
            .map(Map.Entry::getKey)
            .collect(Collectors.toList());

        List<Integer> answer = new ArrayList<>();
        for (String genre : sortedGenres) {
            List<Integer> indices = genresAndIndices.get(genre);
            List<Integer> playsWithGenre = genresAndPlays.get(genre);

            List<Map.Entry<Integer, Integer>> indicesAndPlays
                = collectIndicesAndPlays(indices, playsWithGenre);
            List<Map.Entry<Integer, Integer>> sortedIndicesAndPlays
                = sortIndicesAndPlays(indicesAndPlays);

            answer.add(sortedIndicesAndPlays.get(0).getKey());
            if (sortedIndicesAndPlays.size() >= 2) {
                answer.add(sortedIndicesAndPlays.get(1).getKey());
            }
        }

        return answer.stream()
            .mapToInt(value -> value)
            .toArray();
    }

    public void initData(String[] genres, int[] plays) {
        for (int i = 0; i < genres.length; i += 1) {
            if (!genresAndPlaySums.containsKey(genres[i])) {
                genresAndPlaySums.put(genres[i], plays[i]);
                List<Integer> indices = new ArrayList<>();
                indices.add(i);
                genresAndIndices.put(genres[i], indices);
                List<Integer> playsWithGenre = new ArrayList<>();
                playsWithGenre.add(plays[i]);
                genresAndPlays.put(genres[i], playsWithGenre);
                continue;
            }

            genresAndPlaySums.put(
                genres[i],
                genresAndPlaySums.get(genres[i]) + plays[i]
            );
            genresAndIndices.get(genres[i]).add(i);
            genresAndPlays.get(genres[i]).add(plays[i]);
        }
    }

    public List<Map.Entry<String, Integer>> sortGenresAndPlaySums(
        Map<String, Integer> genresAndPlaySums
    ) {
        return genresAndPlaySums.entrySet().stream()
            .sorted((previous, next) -> (
                next.getValue().compareTo(previous.getValue())
            ))
            .collect(Collectors.toList());
    }

    public List<Map.Entry<Integer, Integer>> collectIndicesAndPlays(
        List<Integer> indices,
        List<Integer> playsWithGenre) {
        List<Map.Entry<Integer, Integer>> indicesAndPlays
            = new ArrayList<>();

        for (int i = 0; i < indices.size(); i += 1) {
            indicesAndPlays.add(
                new AbstractMap.SimpleEntry<>(
                    indices.get(i),
                    playsWithGenre.get(i)
                )
            );
        }

        return indicesAndPlays;
    }

    public List<Map.Entry<Integer, Integer>> sortIndicesAndPlays(
        List<Map.Entry<Integer, Integer>> indicesAndPlays
    ) {
        return indicesAndPlays.stream()
            .sorted((previous, next) -> (
                next.getValue().compareTo(previous.getValue())
            ))
            .sorted((previous, next) -> {
                if (next.getValue().equals(previous.getValue())) {
                    return previous.getKey().compareTo(next.getKey());
                }

                return next.getValue().compareTo(previous.getValue());
            })
            .collect(Collectors.toList());
    }

    public Map<String, Integer> genresAndPlaySums() {
        return genresAndPlaySums;
    }

    public Map<String, List<Integer>> genresAndIndices() {
        return genresAndIndices;
    }

    public Map<String, List<Integer>> genresAndPlays() {
        return genresAndPlays;
    }
}
