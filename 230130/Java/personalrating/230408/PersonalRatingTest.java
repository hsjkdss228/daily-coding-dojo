import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PersonalRatingTest {
    private PersonalRating test;

    @BeforeEach
    void setUp() {
        test = new PersonalRating();
    }

//    @Test
//    void createScores() {
//        PersonalRating.Score myScore = PersonalRating.Score.of(2, 2);
//        int[][] rawScores = {
//            {2, 2},
//            {1, 4},
//            {3, 2},
//            {3, 2},
//            {2, 1},
//        };
//        List<PersonalRating.Score> scores = List.of(
//            PersonalRating.Score.of(2, 2),
//            PersonalRating.Score.of(1, 4),
//            PersonalRating.Score.of(3, 2),
//            PersonalRating.Score.of(3, 2)
//        );
//        assertThat(test.createScores(rawScores, myScore)).isEqualTo(scores);
//    }

    @Test
    void sortScores() {
        List<PersonalRating.Score> scores = new ArrayList<>(List.of(
            PersonalRating.Score.of(2, 2),
            PersonalRating.Score.of(1, 4),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(2, 1)
        ));
        test.sortScores(scores);
        assertThat(scores).isEqualTo(List.of(
            PersonalRating.Score.of(1, 4),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(2, 2),
            PersonalRating.Score.of(2, 1)
        ));
    }

    @Test
    void excludeIfConditionNotMet() {
        List<PersonalRating.Score> scores = new ArrayList<>(List.of(
            PersonalRating.Score.of(1, 4),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(2, 2),
            PersonalRating.Score.of(2, 1)
        ));
        test.excludeIfConditionNotMet(scores);
        assertThat(scores).isEqualTo(List.of(
            PersonalRating.Score.of(1, 4),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(2, 2)
        ));
    }

    @Test
    void noDuplicateRatingsFirst() {
        List<PersonalRating.Score> scores = List.of(
            PersonalRating.Score.of(1, 6),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(2, 2)
        );
        PersonalRating.Score myScore = scores.get(0);
        int myIndex = scores.indexOf(myScore);
        assertThat(test.noDuplicateRatings(scores, myIndex, myScore)).isTrue();
    }

    @Test
    void noDuplicateRatingsLast() {
        List<PersonalRating.Score> scores = List.of(
            PersonalRating.Score.of(1, 4),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(2, 2)
        );
        PersonalRating.Score myScore = scores.get(3);
        int myIndex = scores.indexOf(myScore);
        assertThat(test.noDuplicateRatings(scores, myIndex, myScore)).isTrue();
    }

    @Test
    void calculateDuplicateRatings() {
        List<PersonalRating.Score> scores = List.of(
            PersonalRating.Score.of(1, 5),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(3, 2),
            PersonalRating.Score.of(2, 2)
        );
        PersonalRating.Score myScore = scores.get(2);
        int myIndex = scores.indexOf(myScore);
        assertThat(test.calculateDuplicateRatings(scores, myIndex, myScore))
            .isEqualTo(2);
    }

    @Test
    void solution1() {
        int[][] scores = {
            {2, 2},
            {1, 4},
            {3, 2},
            {3, 2},
            {2, 1},
        };
        int rating = 4;
        assertThat(test.solution(scores)).isEqualTo(rating);
    }

    @Test
    void solution2() {
        int[][] scores = {
            {1, 1},
            {1, 1},
            {1, 1},
            {1, 1},
            {1, 1}
        };
        int rating = 1;
        assertThat(test.solution(scores)).isEqualTo(rating);
    }

    @Test
    void solution3() {
        int[][] scores = {
            {3, 1},
            {1, 4},
            {2, 3},
            {2, 3},
            {1, 5},
            {1, 0},
            {1, 0}
        };
        int rating = 5;
        assertThat(test.solution(scores)).isEqualTo(rating);
    }

    @Test
    void solution4() {
        int[][] scores = {
            {2, 2},
            {2, 2},
            {2, 3},
            {3, 2}
        };
        int rating = 3;
        assertThat(test.solution(scores)).isEqualTo(rating);
    }

    @Test
    void solution5() {
        int[][] scores = {
            {1, 1},
            {2, 2},
            {2, 3},
            {3, 2}
        };
        int rating = -1;
        assertThat(test.solution(scores)).isEqualTo(rating);
    }

    @Test
    void solution6() {
        int[][] scores = {
            {1, 1}
        };
        int rating = 1;
        assertThat(test.solution(scores)).isEqualTo(rating);
    }

    @Test
    void solution7() {
        int[][] scores = {
            {12, 1},
            {11, 12},
            {10, 24},
            {9, 26},
            {8, 28},
            {7, 30},
            {6, 32}
        };
        int rating = 7;
        assertThat(test.solution(scores)).isEqualTo(rating);
    }
}