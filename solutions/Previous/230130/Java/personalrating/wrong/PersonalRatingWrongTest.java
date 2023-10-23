import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonalRatingWrongTest {
    @Test
    void unqualified() {
        PersonalRatingWrong test = new PersonalRatingWrong();

        int[][] scores = new int[][]{
            new int[]{2, 2},
            new int[]{3, 4},
            new int[]{1, 1}
        };
        assertThat(test.unqualified(scores)).isTrue();
    }

    @Test
    void qualified() {
        PersonalRatingWrong test = new PersonalRatingWrong();

        int[][] scores = new int[][]{
            new int[]{3, 4},
            new int[]{2, 2},
            new int[]{1, 1}
        };
        assertThat(test.unqualified(scores)).isFalse();
    }

    @Test
    void solution() {
        PersonalRatingWrong test = new PersonalRatingWrong();

        int[][] scores = new int[][]{
            new int[]{2, 2},
            new int[]{1, 4},
            new int[]{3, 2},
            new int[]{3, 2},
            new int[]{2, 1}
        };
        assertThat(test.solution(scores)).isEqualTo(4);
    }
}
