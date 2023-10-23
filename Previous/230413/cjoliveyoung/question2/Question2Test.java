import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class Question2Test {
    private Question2 test;

    @BeforeEach
    void setUp() {
        test = new Question2();
    }

    @Test
    void convertToSet() {
        String[] stocks = {"AAA", "BCD", "AAAAA", "ZY"};
        assertThat(test.convertToSet(stocks)).isEqualTo(Set.of(
            "AAA", "BCD", "AAAAA", "ZY"
        ));
    }

    @Test
    void maxCountOfRisingPairs() {
        Map<Question2.RisingPair, Integer> risingPairsAndCounts = Map.of(
            Question2.RisingPair.of("AAA", "BBB"), 3,
            Question2.RisingPair.of("AAAA", "BB"), 12,
            Question2.RisingPair.of("A", "BCDEF"), 6
        );
        assertThat(test.maxCountOfRisingPairs(risingPairsAndCounts))
            .isEqualTo(12);
    }

    @Test
    void solution1() {
        String[] stockNamesOfKorea = {"AAA", "BCD", "AAAAA", "ZY"};
        String[] stockNamesOfUsa = {"AB", "AA", "TTTT"};
        String[] stocksRising = {
            "AB BCD AA AAA TTTT AAAAA",
            "BCD AAA",
            "AB AAA TTTT BCD",
            "AA AAAAA AB",
            "AAA AB BCD"
        };
        assertThat(test.solution(stockNamesOfKorea, stockNamesOfUsa, stocksRising))
            .isEqualTo(3);
    }

    @Test
    void solution2() {
        String[] stockNamesOfKorea = {"CCC", "BCDF"};
        String[] stockNamesOfUsa = {"XXXX"};
        String[] stocksRising = {
            "BCDF CCC",
            "XXXX"
        };
        assertThat(test.solution(stockNamesOfKorea, stockNamesOfUsa, stocksRising))
            .isEqualTo(0);
    }
}
