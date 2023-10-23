import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TupleTest {
    @Test
    void setUp() {
        Tuple test = new Tuple();
        String sets = "{{1,2,3},{2,1},{1,2,4,3}}";
        List<String[]> sortedSets = List.of(
            new String[]{"2", "1"},
            new String[]{"1", "2", "3"},
            new String[]{"1", "2", "4", "3"}
        );
        assertThat(test.setUp(sets).get(0)).isEqualTo(sortedSets.get(0));
        assertThat(test.setUp(sets).get(1)).isEqualTo(sortedSets.get(1));
        assertThat(test.setUp(sets).get(2)).isEqualTo(sortedSets.get(2));
    }

    @Test
    void makeTuple() {
        Tuple test = new Tuple();
        List<String[]> sortedSets = List.of(
            new String[]{"2", "1"},
            new String[]{"1", "2", "3"},
            new String[]{"1", "2", "4", "3"}
        );
        int[] answer = new int[]{2, 1, 3, 4};
        assertThat(test.makeTuple(sortedSets)).isEqualTo(answer);
    }

    @Test
    void solution() {
        Tuple test = new Tuple();
        assertThat(test.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))
            .isEqualTo(new int[]{2, 1, 3, 4});
        assertThat(test.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}"))
            .isEqualTo(new int[]{2, 1, 3, 4});
        assertThat(test.solution("{{20,111},{111}}"))
            .isEqualTo(new int[]{111, 20});
        assertThat(test.solution("{{123}}"))
            .isEqualTo(new int[]{123});
        assertThat(test.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}"))
            .isEqualTo(new int[]{3, 2, 4, 1});
    }
}
