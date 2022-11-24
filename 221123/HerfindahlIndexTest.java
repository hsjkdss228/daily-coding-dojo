import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HerfindahlIndexTest {
    @Test
    void solutionCase1() {
        HerfindahlIndex test = new HerfindahlIndex();
        int[] citations = new int[]{3, 0, 6, 1, 5};
        assertThat(test.solution(citations)).isEqualTo(3);
    }

    @Test
    void solutionCase2() {
        HerfindahlIndex test = new HerfindahlIndex();
        int[] citations = new int[]{0, 1, 2, 3, 4};
        assertThat(test.solution(citations)).isEqualTo(2);
    }

    @Test
    void solutionCase3() {
        HerfindahlIndex test = new HerfindahlIndex();
        int[] citations = new int[]{46, 328, 8344, 164, 1};
        assertThat(test.solution(citations)).isEqualTo(4);
    }
}
