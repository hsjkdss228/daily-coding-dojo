import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PlayingAloneTest {
    private PlayingAlone test;

    @BeforeEach
    void setUp() {
        test = new PlayingAlone();
    }

    @Test
    void mapOf() {
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        assertThat(test.mapOf(cards)).isEqualTo(Map.of(
            1, 8,
            2, 6,
            3, 3,
            4, 7,
            5, 2,
            6, 5,
            7, 1,
            8, 4
        ));
    }

    @Test
    void countBoxesInGroup() {
        Map<Integer, Integer> boxAndCardNumbers = new HashMap<>();
        boxAndCardNumbers.put(1, 8);
        boxAndCardNumbers.put(2, 6);
        boxAndCardNumbers.put(3, 3);
        boxAndCardNumbers.put(4, 7);
        boxAndCardNumbers.put(5, 2);
        boxAndCardNumbers.put(6, 5);
        boxAndCardNumbers.put(7, 1);
        boxAndCardNumbers.put(8, 4);
        List<Integer> boxesCounts = new ArrayList<>();

        test.countBoxesInGroup(boxAndCardNumbers, boxesCounts);
        assertThat(boxesCounts).hasSize(3);
        boxesCounts.sort(Collections.reverseOrder());
        assertThat(boxesCounts.get(0)).isEqualTo(4);
        assertThat(boxesCounts.get(1)).isEqualTo(3);
        assertThat(boxesCounts.get(2)).isEqualTo(1);
    }

    @Test
    void solution() {
        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};
        assertThat(test.solution(cards)).isEqualTo(12);
    }
}
