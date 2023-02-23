import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardsTest {
    @Test
    void solutionYes() {
        Cards test = new Cards();

        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        assertThat(test.solution(cards1, cards2, goal))
            .isEqualTo("Yes");
    }

    @Test
    void solutionNo() {
        Cards test = new Cards();

        String[] cards1 = {"i", "water", "drink"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};
        assertThat(test.solution(cards1, cards2, goal))
            .isEqualTo("No");
    }
}
