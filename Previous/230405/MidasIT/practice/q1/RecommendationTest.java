import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RecommendationTest {
    private Recommendation test;

    @BeforeEach
    void setUp() {
        test = new Recommendation();
    }
    @Test
    void solution() {
        String[] histories = {
            "hello i am david",
            "hello kail",
            "hi tina"
        };
        String[][] option = {
            {"W", "T"}
        };
        String keyword = "hello";

        String[] answer = {
            "hello i am david",
            "hello kail"
        };
        assertThat(test.solution(histories, option, keyword))
            .isEqualTo(answer);
    }
}
