import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PersonalityTypesTest {
    private PersonalityTypes test;

    @BeforeEach
    void setUp() {
        test = new PersonalityTypes();
    }

    @Test
    void solution1() {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        assertThat(test.solution(survey, choices)).isEqualTo("TCMA");
    }

    @Test
    void solution2() {
        String[] survey = {"TR", "RT", "TR"};
        int[] choices = {7, 1, 3};
        assertThat(test.solution(survey, choices)).isEqualTo("RCJA");
    }

    @Test
    void solution3() {
        String[] survey = {"CF"};
        int[] choices = {7};
        assertThat(test.solution(survey, choices)).isEqualTo("RFJA");
    }
}
