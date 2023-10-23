import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RankingTest {
    private Ranking test;

    @BeforeEach
    void setUp() {
        test = new Ranking();
    }

    @Test
    void solution1() {
        int userCountToShow = 3;
        String[] userScores = {
            "aa 100", "bb 200", "cc 150", "dd 100",
            "aa 120", "cc 300", "bb 110"
        };
        assertThat(test.solution(userCountToShow, userScores))
            .isEqualTo(4);
    }

    @Test
    void solution2() {
        int userCountToShow = 3;
        String[] userScores = {
            "aa 100", "bb 200", "aa 200", "bb 150",
            "cc 50", "cc 200"
        };
        assertThat(test.solution(userCountToShow, userScores))
            .isEqualTo(3);
    }

    @Test
    void solution3() {
        int userCountToShow = 2;
        String[] userScores = {
            "bb 200", "aa 100", "cc 150", "pp 120"
        };
        assertThat(test.solution(userCountToShow, userScores))
            .isEqualTo(3);
    }
}