import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class BilliardTest {
    private Billiard test;

    @BeforeEach
    void setUp() {
        test = new Billiard();
    }

    @Test
    void toBeFlipped() {
        int startX = 3;
        int startY = 7;
        int endX = 7;
        int endY = 7;
        assertThat(test.notToBeFlipped(
            startX, startY, endX, endY, Billiard.StandardAxis.TOP
        )).isFalse();
    }

    @Test
    void notToBeFlipped() {
        int startX = 3;
        int startY = 7;
        int endX = 7;
        int endY = 7;
        assertThat(test.notToBeFlipped(
            startX, startY, endX, endY, Billiard.StandardAxis.RIGHT
        )).isTrue();
    }

    @Test
    void flipUp() {
        int height = 10;
        int width = 10;
        int endX = 3;
        int endY = 7;
        assertThat(test.flip(
            height, width, endX, endY, Billiard.StandardAxis.TOP
        )).isEqualTo(new int[]{3, 13});
    }

    @Test
    void flipDown() {
        int height = 10;
        int width = 10;
        int endX = 3;
        int endY = 7;
        assertThat(test.flip(
            height, width, endX, endY, Billiard.StandardAxis.BOTTOM
        )).isEqualTo(new int[]{3, -7});
    }

    @Test
    void flipLeft() {
        int height = 10;
        int width = 10;
        int endX = 3;
        int endY = 7;
        assertThat(test.flip(
            height, width, endX, endY, Billiard.StandardAxis.LEFT
        )).isEqualTo(new int[]{-3, 7});
    }

    @Test
    void flipRight() {
        int height = 10;
        int width = 10;
        int endX = 3;
        int endY = 7;
        assertThat(test.flip(
            height, width, endX, endY, Billiard.StandardAxis.RIGHT
        )).isEqualTo(new int[]{17, 7});
    }

    @Test
    void calculateDistance1() {
        int startX = 3;
        int startY = 7;
        int flippedEndX = 7;
        int flippedEndY = 13;
        assertThat(test.calculateDistance(
            startX, startY, flippedEndX, flippedEndY
        )).isEqualTo(52);
    }

    @Test
    void calculateDistance2() {
        int startX = 3;
        int startY = 7;
        int flippedEndX = 7;
        int flippedEndY = -7;
        assertThat(test.calculateDistance(
            startX, startY, flippedEndX, flippedEndY
        )).isEqualTo(212);
    }

    @Test
    void calculateDistances() {
        int height = 10;
        int width = 10;
        int startX = 3;
        int startY = 7;
        int endX = 7;
        int endY = 7;
        assertThat(test.calculateDistances(
            height, width, startX, startY, endX, endY
        )).isEqualTo(Map.of(
            Billiard.StandardAxis.LEFT, 100,
            Billiard.StandardAxis.TOP, 52,
            Billiard.StandardAxis.BOTTOM, 212
        ));
    }

    @Test
    void findMinimumDistance() {
        Map<Billiard.StandardAxis, Integer> axisAndDistances = Map.of(
            Billiard.StandardAxis.LEFT, 100,
            Billiard.StandardAxis.TOP, 52,
            Billiard.StandardAxis.BOTTOM, 212
        );
        assertThat(test.findMinimumDistance(axisAndDistances))
            .isEqualTo(52);
    }

    @Test
    void solution() {
        int height = 10;
        int width = 10;
        int startX = 3;
        int startY = 7;
        int[][] balls = {
            {7, 7},
            {2, 7},
            {7, 3},
        };
        int[] answer = {52, 37, 116};
        assertThat(test.solution(
            height, width, startX, startY, balls
        )).isEqualTo(answer);
    }
}
