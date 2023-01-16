import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BestAlbum {
    private Map<Integer, String> indexAndGenres = new HashMap<>();
    private Map<Integer, Integer> indexAndPlays = new HashMap<>();
    private Map<String, Integer> genreAndPlaySums = new HashMap<>();

    public int[] solution(String[] genres, int[] plays) {
        setIndexAndGenresPlays(genres, plays);
        setGenresAndPlaySums(genres, plays);

        List<Map.Entry<String, Integer>> sortedGenres = sortGenres(genreAndPlaySums);

        int[] answer = {};
        return answer;
    }

    public Map<Integer, String> indexAndGenres() {
        return indexAndGenres;
    }

    public Map<Integer, Integer> indexAndPlays() {
        return indexAndPlays;
    }

    public Map<String, Integer> genreAndPlaySums() {
        return genreAndPlaySums;
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

    public List<Map.Entry<String, Integer>> sortGenres(Map<String, Integer> genreAndPlaySums) {
        List<Map.Entry<String, Integer>> sortedGenres
            = new ArrayList<>(genreAndPlaySums.entrySet());
        sortedGenres.sort((previous, next) -> next.getValue().compareTo(previous.getValue()));
        return sortedGenres;
    }
}
