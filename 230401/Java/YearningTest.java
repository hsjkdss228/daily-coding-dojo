import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class YearningTest {
    private Yearning test;

    @BeforeEach
    void setUp() {
        test = new Yearning();
    }

    @Test
    void pair() {
        String[] names = {"may", "kein", "kain", "radi"};
        int[] yearnings = {5, 10, 1, 3};
        assertThat(test.pair(names, yearnings))
            .isEqualTo(Map.of(
                "may", 5,
                "kein", 10,
                "kain", 1,
                "radi", 3
            ));
    }

    @Test
    void calculateScores() {
        Map<String, Integer> nameAndYearnings = Map.of(
            "may", 5,
            "kein", 10,
            "kain", 1,
            "radi", 3
        );
        String[][] photos = {
            {"may", "kein", "kain", "radi"},
            {"may", "kein", "brin", "deny"},
            {"kon", "kain", "may", "coni"}
        };
        int[] scores = {19, 15, 6};
        assertThat(test.calculateScores(nameAndYearnings, photos))
            .isEqualTo(scores);
    }

    @Test
    void solution() {
        String[] names = {"may", "kein", "kain", "radi"};
        int[] yearnings = {5, 10, 1, 3};
        String[][] photos = {
            {"may", "kein", "kain", "radi"},
            {"may", "kein", "brin", "deny"},
            {"kon", "kain", "may", "coni"}
        };
        int[] answer = {19, 15, 6};
        assertThat(test.solution(names, yearnings, photos))
            .isEqualTo(answer);
    }
}
