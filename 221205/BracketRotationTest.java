import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BracketRotationTest {
    @Test
    void solutionCase1() {
        BracketRotation test = new BracketRotation();

        String brackets = "[](){}";
        assertThat(test.solution(brackets)).isEqualTo(3);
    }

    @Test
    void solutionCase2() {
        BracketRotation test = new BracketRotation();

        String brackets = "[)(]";
        assertThat(test.solution(brackets)).isEqualTo(0);
    }
}
