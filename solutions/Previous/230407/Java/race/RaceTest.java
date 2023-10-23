import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RaceTest {
    private Race test;

    @BeforeEach
    void setUp() {
        test = new Race();
    }

    @Test
    void solution() {
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = {"mumu", "kai", "mine", "soe", "poe"};

        assertThat(test.solution(players, callings)).isEqualTo(result);
    }
}
