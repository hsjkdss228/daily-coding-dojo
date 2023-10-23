import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MatrixMultiplicationTest {
    @Test
    void rowLength() {
        int[][] array = new int[][]{
            new int[]{1, 4},
            new int[]{3, 2},
            new int[]{4, 1}
        };
        assertThat(array.length).isEqualTo(3);
        assertThat(array[0].length).isEqualTo(2);
    }

    @Test
    void solution() {
        MatrixMultiplication matrixMultiplication = new MatrixMultiplication();
        int[][] array1 = new int[][]{
            {1, 4},
            {3, 2},
            {4, 1}
        };
        int[][] array2 = new int[][]{
            {3, 3},
            {3, 3}
        };
        matrixMultiplication.solution(array1, array2);
    }
}
