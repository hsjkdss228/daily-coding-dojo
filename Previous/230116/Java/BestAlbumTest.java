import org.junit.jupiter.api.Test;

import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BestAlbumTest {
    @Test
    void initData() {
        BestAlbum test = new BestAlbum();

        String[] genres = new String[]{
            "classic", "pop", "classic", "classic", "pop"
        };
        int[] plays = new int[]{
            500, 600, 150, 800, 2500
        };
        test.initData(genres, plays);
        assertThat(test.genresAndPlaySums().get("classic"))
            .isEqualTo(1450);
        assertThat(test.genresAndPlaySums().get("pop"))
            .isEqualTo(3100);
        assertThat(test.genresAndIndices().get("classic").get(0))
            .isEqualTo(0);
        assertThat(test.genresAndIndices().get("classic").get(2))
            .isEqualTo(3);
        assertThat(test.genresAndIndices().get("pop").get(0))
            .isEqualTo(1);
        assertThat(test.genresAndIndices().get("pop").get(1))
            .isEqualTo(4);
        assertThat(test.genresAndPlays().get("classic").get(0))
            .isEqualTo(500);
        assertThat(test.genresAndPlays().get("classic").get(2))
            .isEqualTo(800);
        assertThat(test.genresAndPlays().get("pop").get(0))
            .isEqualTo(600);
        assertThat(test.genresAndPlays().get("pop").get(1))
            .isEqualTo(2500);
    }

    @Test
    void sortGenresAndPlaySums() {
        BestAlbum test = new BestAlbum();

        Map<String, Integer> genresAndPlaySums = Map.of(
            "jazz", 1200,
            "classic", 5000,
            "k-pop", 300,
            "j-pop", 2600
        );
        List<Map.Entry<String, Integer>> sortedGenresAndPlaySums
            = test.sortGenresAndPlaySums(genresAndPlaySums);
        assertThat(sortedGenresAndPlaySums.get(0).getKey())
            .isEqualTo("classic");
        assertThat(sortedGenresAndPlaySums.get(1).getKey())
            .isEqualTo("j-pop");
        assertThat(sortedGenresAndPlaySums.get(2).getKey())
            .isEqualTo("jazz");
        assertThat(sortedGenresAndPlaySums.get(3).getKey())
            .isEqualTo("k-pop");
    }

    @Test
    void collectIndicesAndPlays() {
        BestAlbum test = new BestAlbum();

        List<Integer> indices = List.of(0, 1);
        List<Integer> plays = List.of(300, 150);
        List<Map.Entry<Integer, Integer>> indicesAndPlays
            = test.collectIndicesAndPlays(indices, plays);
        assertThat(indicesAndPlays.get(0).getKey()).isEqualTo(0);
        assertThat(indicesAndPlays.get(1).getKey()).isEqualTo(1);
        assertThat(indicesAndPlays.get(0).getValue()).isEqualTo(300);
        assertThat(indicesAndPlays.get(1).getValue()).isEqualTo(150);
    }

    @Test
    void sortIndicesAndPlays1() {
        BestAlbum test = new BestAlbum();

        List<Map.Entry<Integer, Integer>> indicesAndPlays
            = List.of(
            new AbstractMap.SimpleEntry<>(2, 100),
            new AbstractMap.SimpleEntry<>(0, 2000),
            new AbstractMap.SimpleEntry<>(1, 200),
            new AbstractMap.SimpleEntry<>(3, 1750)
        );
        List<Map.Entry<Integer, Integer>> sortedIndicesAndPlays
            = test.sortIndicesAndPlays(indicesAndPlays);
        assertThat(sortedIndicesAndPlays.get(0).getValue())
            .isEqualTo(2000);
        assertThat(sortedIndicesAndPlays.get(3).getValue())
            .isEqualTo(100);
    }

    @Test
    void sortIndicesAndPlays2() {
        BestAlbum test = new BestAlbum();

        List<Map.Entry<Integer, Integer>> indicesAndPlays
            = List.of(
            new AbstractMap.SimpleEntry<>(0, 500),
            new AbstractMap.SimpleEntry<>(2, 150),
            new AbstractMap.SimpleEntry<>(3, 800)
        );
        List<Map.Entry<Integer, Integer>> sortedIndicesAndPlays
            = test.sortIndicesAndPlays(indicesAndPlays);
        assertThat(sortedIndicesAndPlays.get(0).getValue())
            .isEqualTo(800);
        assertThat(sortedIndicesAndPlays.get(1).getValue())
            .isEqualTo(500);
        assertThat(sortedIndicesAndPlays.get(2).getValue())
            .isEqualTo(150);
    }

    @Test
    void sortIndicesAndPlaysWithSamePlays1() {
        BestAlbum test = new BestAlbum();

        List<Map.Entry<Integer, Integer>> indicesAndPlays
            = List.of(
            new AbstractMap.SimpleEntry<>(2, 100),
            new AbstractMap.SimpleEntry<>(3, 2000),
            new AbstractMap.SimpleEntry<>(1, 2000),
            new AbstractMap.SimpleEntry<>(0, 2000)
        );
        List<Map.Entry<Integer, Integer>> sortedIndicesAndPlays
            = test.sortIndicesAndPlays(indicesAndPlays);
        assertThat(sortedIndicesAndPlays.get(0).getKey())
            .isEqualTo(0);
        assertThat(sortedIndicesAndPlays.get(1).getKey())
            .isEqualTo(1);
        assertThat(sortedIndicesAndPlays.get(2).getKey())
            .isEqualTo(3);
        assertThat(sortedIndicesAndPlays.get(3).getKey())
            .isEqualTo(2);
    }

    @Test
    void sortIndicesAndPlaysWithSamePlays2() {
        BestAlbum test = new BestAlbum();

        List<Map.Entry<Integer, Integer>> indicesAndPlays
            = List.of(
            new AbstractMap.SimpleEntry<>(0, 10),
            new AbstractMap.SimpleEntry<>(1, 50),
            new AbstractMap.SimpleEntry<>(2, 20000),
            new AbstractMap.SimpleEntry<>(3, 50),
            new AbstractMap.SimpleEntry<>(4, 20000)
        );
        List<Map.Entry<Integer, Integer>> sortedIndicesAndPlays
            = test.sortIndicesAndPlays(indicesAndPlays);
        assertThat(sortedIndicesAndPlays.get(0).getKey())
            .isEqualTo(2);
        assertThat(sortedIndicesAndPlays.get(1).getKey())
            .isEqualTo(4);
        assertThat(sortedIndicesAndPlays.get(2).getKey())
            .isEqualTo(1);
        assertThat(sortedIndicesAndPlays.get(3).getKey())
            .isEqualTo(3);
        assertThat(sortedIndicesAndPlays.get(4).getKey())
            .isEqualTo(0);
    }

    @Test
    void solution1() {
        BestAlbum test = new BestAlbum();

        String[] genres = new String[]{
            "classic", "pop", "classic", "classic", "pop"
        };
        int[] plays = new int[]{
            500, 600, 150, 800, 2500
        };
        assertThat(test.solution(genres, plays)).isEqualTo(
            new int[]{4, 1, 3, 0}
        );
    }

    @Test
    void solution2() {
        BestAlbum test = new BestAlbum();

        String[] genres = new String[]{
            "a", "a", "a", "a", "a"
        };
        int[] plays = new int[]{
            10, 50, 20000, 50, 20000
        };
        assertThat(test.solution(genres, plays)).isEqualTo(
            new int[]{2, 4}
        );
    }

    @Test
    void solution3() {
        BestAlbum test = new BestAlbum();

        String[] genres = new String[]{
            "a", "b", "c", "d", "e"
        };
        int[] plays = new int[]{
            10, 50, 20000, 49, 19999
        };
        assertThat(test.solution(genres, plays)).isEqualTo(
            new int[]{2, 4, 1, 3, 0}
        );
    }

    @Test
    void solution4() {
        BestAlbum test = new BestAlbum();

        String[] genres = new String[]{
            "a"
        };
        int[] plays = new int[]{
            10
        };
        assertThat(test.solution(genres, plays)).isEqualTo(
            new int[]{0}
        );
    }

    @Test
    void solution5() {
        BestAlbum test = new BestAlbum();

        String[] genres = new String[]{
            "a", "a", "b", "b", "c", "d", "d", "d", "d"
        };
        int[] plays = new int[]{
            10, 10, 5, 16, 5000, 5, 5, 5, 7
        };
        assertThat(test.solution(genres, plays)).isEqualTo(
            new int[]{4, 8, 5, 3, 2, 0, 1}
        );
    }
}
