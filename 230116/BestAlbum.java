import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BestAlbum {
    private Map<Integer, String> indexAndGenres = new HashMap<>();
    private Map<Integer, Integer> indexAndPlays = new HashMap<>();
    private Map<String, Integer> genreAndPlaySums = new HashMap<>();
    private List<Map.Entry<String, Integer>> sortedGenres = new ArrayList<>();
    private List<Integer> indices = new ArrayList<>();

    public int[] solution(String[] genres, int[] plays) {
        setIndexAndGenresPlays(genres, plays);
        setGenresAndPlaySums(genres, plays);

        sortGenres(genreAndPlaySums);

        addIndices();

        return indices.stream()
            .mapToInt(index -> index)
            .toArray();
    }

    public Map<Integer, String> indexAndGenres() {
        return indexAndGenres;
    }

    public Map<Integer, Integer> indexAndPlays() {
        return indexAndPlays;
    }

    public List<Map.Entry<String, Integer>> sortedGenres() {
        return sortedGenres;
    }

    public Map<String, Integer> genreAndPlaySums() {
        return genreAndPlaySums;
    }

    public List<Integer> indices() {
        return indices;
    }

    public void setIndexAndGenresPlays(String[] genres, int[] plays) {
        for (int i = 0; i < genres.length; i += 1) {
            indexAndGenres.put(i, genres[i]);
            indexAndPlays.put(i, plays[i]);
        }
    }

    public void setGenresAndPlaySums(String[] genres, int[] plays) {
        for (int i = 0; i < genres.length; i += 1) {
            if (!genreAndPlaySums.containsKey(genres[i])) {
                genreAndPlaySums.put(
                    genres[i],
                    plays[i]
                );
                continue;
            }
            genreAndPlaySums.put(
                genres[i],
                genreAndPlaySums.get(genres[i]) + plays[i]
            );
        }
    }

    public void sortGenres(
        Map<String, Integer> genreAndPlaySums
    ) {
        sortedGenres = new ArrayList<>(genreAndPlaySums.entrySet());
        // 오름차순 정렬
        sortedGenres.sort((previous, next) ->
            next.getValue().compareTo(previous.getValue())
        );
    }

    public void addIndices() {
        for (Map.Entry<String, Integer> genreAndPlaySum : sortedGenres) {
            String genre = genreAndPlaySum.getKey();

            Set<Map.Entry<Integer, String>> indexAndSelectedGenres
                = indexAndGenres.entrySet().stream()
                .filter(indexAndGenre -> indexAndGenre.getValue().equals(genre))
                .collect(Collectors.toSet());
            List<Map.Entry<Integer, Integer>> indexAndSelectedPlays
                = new ArrayList<>();
            indexAndSelectedGenres.forEach(indexAndSelectedGenre -> {
                Integer index = indexAndSelectedGenre.getKey();
                indexAndSelectedPlays.add(
                    Map.entry(index, indexAndPlays.get(index))
                );
            });

            // 장르의 곡이 하나만 있으면 index를 그냥 추가
            if (indexAndSelectedPlays.size() == 1) {
                indices.add(indexAndSelectedPlays.get(0).getKey());
                continue;
            }

            sortPlays(indexAndSelectedPlays);

            Map.Entry<Integer, Integer> selectedIndexAndPlay1
                = indexAndSelectedPlays.get(0);
            Map.Entry<Integer, Integer> selectedIndexAndPlay2
                = indexAndSelectedPlays.get(1);

            Integer selectedIndex1 = selectedIndexAndPlay1.getKey();
            Integer selectedIndex2 = selectedIndexAndPlay2.getKey();
            Integer selectedPlay1 = selectedIndexAndPlay1.getValue();
            Integer selectedPlay2 = selectedIndexAndPlay2.getValue();

            System.out.println("selectedIndex1: " + selectedIndex1);
            System.out.println("selectedIndex2: " + selectedIndex2);
            System.out.println("selectedPlay1: " + selectedPlay1);
            System.out.println("selectedPlay2: " + selectedPlay2);

            // 추가할 두 곡의 재생 횟수가 같으면 index가 작은 쪽을 먼저 push
            if (selectedPlay1.equals(selectedPlay2)) {
                int first = Math.min(selectedIndex1, selectedIndex2);
                int second = Math.max(selectedIndex1, selectedIndex2);
                indices.add(first);
                indices.add(second);
                continue;
            }

            // edge case에 해당되지 않으면 선택된 index 순서대로 push
            indices.add(selectedIndex1);
            indices.add(selectedIndex2);
        }
    }

    public void sortPlays(
        List<Map.Entry<Integer, Integer>> indexAndSelectedPlays
    ) {
        // 내림차순 정렬
        indexAndSelectedPlays.sort((previous, next) -> {
            Integer previousPlays = previous.getValue();
            Integer nextPlays = next.getValue();
            return previousPlays.compareTo(nextPlays);
        });
    }
}
