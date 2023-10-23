import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BestAlbumTest {
    @Test
    void setIndexAndGenresPlays() {
        BestAlbum test = new BestAlbum();

        String[] genres = new String[]{
            "classic", "pop", "classic", "classic", "pop"
        };
        int[] plays = new int[]{
            500, 600, 150, 800, 2500
        };
        test.setIndexAndGenresPlays(genres, plays);
        assertThat(test.indexAndGenres().get(0)).isEqualTo("classic");
        assertThat(test.indexAndGenres().get(1)).isEqualTo("pop");
        assertThat(test.indexAndGenres().get(2)).isEqualTo("classic");
    }

    @Test
    void setGenresAndPlaySums() {
        BestAlbum test = new BestAlbum();

        String[] genres = new String[]{
            "classic", "pop", "classic", "classic", "pop"
        };
        int[] plays = new int[]{
            500, 600, 150, 800, 2500
        };
        test.setGenresAndPlaySums(genres, plays);
        assertThat(test.genresAndPlaySums().get("classic")).isEqualTo(1450);
        assertThat(test.genresAndPlaySums().get("pop")).isEqualTo(3100);
    }

    @Test
    void sortGenres() {
        BestAlbum test = new BestAlbum();

        Map<String, Integer> genreAndPlaySums = Map.of(
            "jazz", 1200,
            "classic", 5000,
            "k-pop", 300,
            "j-pop", 2600
        );
        test.sortGenres(genreAndPlaySums);
        List<Map.Entry<String, Integer>> sortedGenres
            = test.sortedGenresAndPlaySums();
        assertThat(sortedGenres.get(0).getKey()).isEqualTo("classic");
        assertThat(sortedGenres.get(1).getKey()).isEqualTo("j-pop");
        assertThat(sortedGenres.get(2).getKey()).isEqualTo("jazz");
        assertThat(sortedGenres.get(3).getKey()).isEqualTo("k-pop");
    }

//    @Test
//    void addIndices() {
//        BestAlbum test = new BestAlbum();
//
//        String[] genres = new String[]{
//            "classic", "pop", "classic", "classic", "pop"
//        };
//        int[] plays = new int[]{
//            500, 600, 150, 800, 2500
//        };
//        Map<String, Integer> genreAndPlaySums = Map.of(
//            "classic", 1450,
//            "pop", 3100
//        );
//        test.setIndexAndGenresPlays(genres, plays);
//        test.setGenresAndPlaySums(genres, plays);
//        test.sortGenres(genreAndPlaySums);
//        test.addIndices();
//        List<Integer> indices = test.indices();
//        assertThat(indices.get(0)).isEqualTo(4);
//        assertThat(indices.get(1)).isEqualTo(1);
//        assertThat(indices.get(2)).isEqualTo(3);
//        assertThat(indices.get(3)).isEqualTo(0);
//    }

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
