import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class KeyboardTest {
    private Keyboard test;

    @BeforeEach
    void setUp() {
        test = new Keyboard();
    }

    @Test
    void mapMinimumCounts() {
        String[] keymap = {"ABACD", "BCEFD"};
        Map<Character, Integer> alphabetAndCount = Map.of(
            'A', 1,
            'B', 1,
            'C', 2,
            'D', 5,
            'E', 3,
            'F', 4
        );
        assertThat(test.mapMinimumCounts(keymap))
            .isEqualTo(alphabetAndCount);
    }

    @Test
    void countTargets() {
        Map<Character, Integer> alphabetAndCount = Map.of(
            'A', 1,
            'B', 1,
            'C', 2,
            'D', 5,
            'E', 3,
            'F', 4
        );
        String[] targets = {"ABCD", "AABB"};
        assertThat(test.countTargets(alphabetAndCount, targets))
            .isEqualTo(new int[]{9, 4});
    }

    @Test
    void solution1() {
        String[] keymap = {"ABACD", "BCEFD"};
        String[] targets = {"ABCD", "AABB"};
        assertThat(test.solution(keymap, targets))
            .isEqualTo(new int[]{9, 4});
    }

    @Test
    void solution2() {
        String[] keymap = {"AA"};
        String[] targets = {"B"};
        assertThat(test.solution(keymap, targets))
            .isEqualTo(new int[]{-1});
    }

    @Test
    void solution3() {
        String[] keymap = {"AGZ", "BSSS"};
        String[] targets = {"ASA","BGZ"};
        assertThat(test.solution(keymap, targets))
            .isEqualTo(new int[]{4, 6});
    }
}
