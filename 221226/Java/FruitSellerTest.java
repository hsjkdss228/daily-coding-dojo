import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class FruitSellerTest {
    @Test
    void sortInDescendingOrder() {
        FruitSeller test = new FruitSeller();

        Integer[] scores = new Integer[]{3, 7, 5, 9, 1, 2};
        test.sortInDescendingOrder(scores);
        assertThat(scores)
            .isEqualTo(new Integer[]{9, 7, 5, 3, 2, 1});
    }

    @Test
    void solutionCase1() {
        FruitSeller test = new FruitSeller();

        int k = 3;
        int numberInBox = 4;
        int[] scores = new int[]{1, 2, 3, 1, 2, 3, 1};
        assertThat(test.solution(k, numberInBox, scores))
            .isEqualTo(8);
    }

    @Test
    void solutionCase2() {
        FruitSeller test = new FruitSeller();

        int k = 4;
        int numberInBox = 3;
        int[] scores = new int[]{4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};
        assertThat(test.solution(k, numberInBox, scores))
            .isEqualTo(33);
    }
}
