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
        assertThat(test.genreAndPlaySums().get("classic")).isEqualTo(1450);
        assertThat(test.genreAndPlaySums().get("pop")).isEqualTo(3100);
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
        List<Map.Entry<String, Integer>> sortedGenres
            = test.sortGenres(genreAndPlaySums);
        assertThat(sortedGenres.get(0).getKey()).isEqualTo("classic");
        assertThat(sortedGenres.get(1).getKey()).isEqualTo("j-pop");
        assertThat(sortedGenres.get(2).getKey()).isEqualTo("jazz");
        assertThat(sortedGenres.get(3).getKey()).isEqualTo("k-pop");
    }
}
