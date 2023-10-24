import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class YearningTest {
    private Yearning test;

    @BeforeEach
    void setUp() {
        test = new Yearning();
    }

    @Test
    void solution1() {
        String[] names = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photos = {
            {"may", "kein", "kain", "radi"},
            {"may", "kein", "brin", "deny"},
            {"kon", "kain", "may", "coni"}
        };

        assertThat(test.solution(names, yearning, photos))
            .isEqualTo(new int[]{19, 15, 6});
    }

    @Test
    void solution2() {
        String[] names = {"kali", "mari", "don"};
        int[] yearning = {11, 1, 55};
        String[][] photos = {
            {"kali", "mari", "don"},
            {"pony", "tom", "teddy"},
            {"con", "mona", "don"}
        };

        assertThat(test.solution(names, yearning, photos))
            .isEqualTo(new int[]{67, 0, 55});
    }

    @Test
    void solution3() {
        String[] names = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photos = {
            {"may"},
            {"kein", "deny", "may"},
            {"kon", "coni"}
        };

        assertThat(test.solution(names, yearning, photos))
            .isEqualTo(new int[]{5, 15, 0});
    }
}
