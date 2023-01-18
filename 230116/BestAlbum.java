import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BestAlbum {
    private Map<Integer, String> indexAndGenres = new HashMap<>();
    private Map<Integer, Integer> indexAndPlays = new HashMap<>();
    private Map<String, Integer> genresAndPlaySums = new HashMap<>();
    private List<Map.Entry<String, Integer>> sortedGenresAndPlaySums = new ArrayList<>();
    private List<Integer> indices = new ArrayList<>();

    public int[] solution(String[] genres, int[] plays) {
        setIndexAndGenresPlays(genres, plays);
        setGenresAndPlaySums(genres, plays);

        sortGenres(genresAndPlaySums);
        addIndices(sortedGenresAndPlaySums);

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

    public Map<String, Integer> genresAndPlaySums() {
        return genresAndPlaySums;
    }

    public List<Map.Entry<String, Integer>> sortedGenresAndPlaySums() {
        return sortedGenresAndPlaySums;
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
            if (!genresAndPlaySums.containsKey(genres[i])) {
                genresAndPlaySums.put(
                    genres[i],
                    plays[i]
                );
                continue;
            }
            genresAndPlaySums.put(
                genres[i],
                genresAndPlaySums.get(genres[i]) + plays[i]
            );
        }
    }

    public void sortGenres(
        Map<String, Integer> genresAndPlaySums
    ) {


        for (Map.Entry<String, Integer> genreAndPlaySum
            : genresAndPlaySums.entrySet()) {
            System.out.println("뽑아온 것: " + genreAndPlaySum.getKey() +
                ", " + genreAndPlaySum.getValue());

            if (sortedGenresAndPlaySums.isEmpty()) {
                sortedGenresAndPlaySums.add(genreAndPlaySum);
                continue;
            }

            for (int i = 0; i < sortedGenresAndPlaySums.size(); i += 1) {
                System.out.println("있는 것: " + sortedGenresAndPlaySums.get(i).getKey() +
                    ", " + sortedGenresAndPlaySums.get(i).getValue());

                if (sortedGenresAndPlaySums.get(i).getValue()
                    > genreAndPlaySum.getValue()) {
                    continue;
                }

                sortedGenresAndPlaySums.add(genreAndPlaySum);
                i += 1;
            }
        }
    }

    public void addIndices(
        List<Map.Entry<String, Integer>> sortedGenresAndPlaySums
    ) {
        // 넣을 장르마다 반복
        for (Map.Entry<String, Integer> genreAndPlaySum : sortedGenresAndPlaySums) {
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
                System.out.println("이번에 뽑아온 장르는 곡이 하나만 있었다.");
                indices.add(indexAndSelectedPlays.get(0).getKey());
                continue;
            }

            List<Map.Entry<Integer, Integer>> selectedIndicesAndPlays
                = selectIndiceAndPlays(indexAndSelectedPlays);

            Map.Entry<Integer, Integer> selectedIndexAndPlay1
                = selectedIndicesAndPlays.get(0);
            Map.Entry<Integer, Integer> selectedIndexAndPlay2
                = selectedIndicesAndPlays.get(1);

            Integer selectedIndex1 = selectedIndexAndPlay1.getKey();
            Integer selectedIndex2 = selectedIndexAndPlay2.getKey();
            Integer selectedPlay1 = selectedIndexAndPlay1.getValue();
            Integer selectedPlay2 = selectedIndexAndPlay2.getValue();

            System.out.println("Index And Play 1: " +
                selectedIndex1 + ", " +
                selectedPlay1
            );
            System.out.println("Index And Play 2: " +
                selectedIndex2 + ", " +
                selectedPlay2
            );

            // 두 곡의 재생 횟수가 같으면 index가 작은 쪽을 먼저 push
            if (selectedPlay1.equals(selectedPlay2)) {
                int first = Math.min(selectedIndex1, selectedIndex2);
                int second = Math.max(selectedIndex1, selectedIndex2);
                indices.add(first);
                indices.add(second);
                continue;
            }

            // edge case에 해당되지 않으면 두 곡의 재생 횟수를 비교해서
            // 큰 쪽을 먼저 push
            indices.add(
                selectedPlay1 > selectedPlay2
                    ? selectedIndex1
                    : selectedIndex2
            );
            indices.add(
                selectedPlay1 > selectedPlay2
                    ? selectedIndex2
                    : selectedIndex1
            );
        }
    }

    public List<Map.Entry<Integer, Integer>> selectIndiceAndPlays(
        List<Map.Entry<Integer, Integer>> indexAndSelectedPlays
    ) {
        // 내림차순 정렬을 의도했으나 정렬되지 않았음
//        indexAndSelectedPlays.sort((previous, next) -> {
//            Integer previousPlays = previous.getValue();
//            Integer nextPlays = next.getValue();
//            return previousPlays.compareTo(nextPlays);
//        });

        List<Map.Entry<Integer, Integer>> selectedIndicesAndPlays
            = new ArrayList<>();

        for (Map.Entry<Integer, Integer> newIndexAndSelectedPlay
            : indexAndSelectedPlays) {
            System.out.println("새로 뽑아온 것: " +
                newIndexAndSelectedPlay.getKey() + ", " +
                newIndexAndSelectedPlay.getValue()
            );

            if (selectedIndicesAndPlays.isEmpty()
                || selectedIndicesAndPlays.size() == 1) {
                selectedIndicesAndPlays.add(newIndexAndSelectedPlay);
                continue;
            }

            for (int i = 0; i < selectedIndicesAndPlays.size(); i += 1) {
                if ((
                    newIndexAndSelectedPlay.getValue()
                        > selectedIndicesAndPlays.get(i).getValue()
                ) || (
                    newIndexAndSelectedPlay.getValue()
                        .equals(selectedIndicesAndPlays.get(i).getValue())
                        && newIndexAndSelectedPlay.getKey()
                        < selectedIndicesAndPlays.get(i).getKey()
                )) {
                    System.out.println("i: " + i);
                    System.out.println("바꿀 기존 것: " +
                        selectedIndicesAndPlays.get(i).getKey() + ", " +
                        selectedIndicesAndPlays.get(i).getValue()
                    );
                    selectedIndicesAndPlays.set(i, newIndexAndSelectedPlay);
                }
            }
        }

        return selectedIndicesAndPlays;
    }
}
