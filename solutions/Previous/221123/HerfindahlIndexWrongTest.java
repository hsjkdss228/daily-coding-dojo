import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HerfindahlIndexWrongTest {
    @Test
    void sort() {
        HerfindahlIndexWrong test = new HerfindahlIndexWrong();
        int[] citations = new int[]{3, 0, 6, 1, 5};
        assertThat(test.sort(citations)).isEqualTo(new Integer[]{6, 5, 3, 1, 0});
    }

    @Test
    void countNumberOfCitation() {
        HerfindahlIndexWrong test = new HerfindahlIndexWrong();
        Integer[] citations = new Integer[]{6, 5, 3, 3, 0};
        Integer citation = 3;
        assertThat(test.countNumberOfCitation(citations, citation))
            .isEqualTo(4);
    }

    @Test
    void countSameNumberOfCitation() {
        HerfindahlIndexWrong test = new HerfindahlIndexWrong();
        Integer[] citations = new Integer[]{6, 5, 3, 3, 0};
        Integer citation = 3;
        assertThat(test.countSameNumberOfCitation(citations, citation))
            .isEqualTo(2);
    }

    @Test
    void solutionCase1() {
        HerfindahlIndexWrong test = new HerfindahlIndexWrong();
        int[] citations = new int[]{3, 0, 6, 1, 5};
        assertThat(test.solution(citations)).isEqualTo(3);
    }

    @Test
    void solutionCase2() {
        HerfindahlIndexWrong test = new HerfindahlIndexWrong();
        int[] citations = new int[]{3, 0, 6, 3, 5};
        assertThat(test.solution(citations)).isEqualTo(3);
    }

    @Test
    void solutionCase3() {
        HerfindahlIndexWrong test = new HerfindahlIndexWrong();
        int[] citations = new int[]{3, 0, 3, 3, 1};
        assertThat(test.solution(citations)).isEqualTo(3);
    }

    @Test
    void solutionCase4() {
        HerfindahlIndexWrong test = new HerfindahlIndexWrong();
        int[] citations = new int[]{0, 1, 2, 3, 4};
        assertThat(test.solution(citations)).isEqualTo(2);
    }

    @Test
    void solutionCase5() {
        HerfindahlIndexWrong test = new HerfindahlIndexWrong();
        int[] citations = new int[]{46, 328, 8344, 164, 1};
        assertThat(test.solution(citations)).isEqualTo(4);
    }
}
