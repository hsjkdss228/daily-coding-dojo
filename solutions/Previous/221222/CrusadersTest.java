import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CrusadersTest {
    @Test
    void divisorCountWithHalf() {
        Crusaders test = new Crusaders();

        int index = 8;
        assertThat(test.divisorCount(index)).isEqualTo(4);
    }

    @Test
    void divisorCountWithoutHalf() {
        Crusaders test = new Crusaders();

        int index = 7;
        assertThat(test.divisorCount(index)).isEqualTo(2);
    }

    @Test
    void divisorCountWithUnder2() {
        Crusaders test = new Crusaders();

        int index1 = 1;
        assertThat(test.divisorCount(index1)).isEqualTo(1);

        int index2 = 2;
        assertThat(test.divisorCount(index2)).isEqualTo(2);
    }

    @Test
    void compareWithLimit() {
        Crusaders test = new Crusaders();

        int divisorsCount = 3;
        int limit = 5;
        int power = 2;

        assertThat(test.compareWithLimit(divisorsCount, limit, power))
            .isEqualTo(3);
    }

    @Test
    void compareWithLimitWithExceedingLimit() {
        Crusaders test = new Crusaders();

        int divisorsCount = 5;
        int limit = 3;
        int power = 2;

        assertThat(test.compareWithLimit(divisorsCount, limit, power))
            .isEqualTo(2);
    }

    @Test
    void solutionCase1() {
        Crusaders test = new Crusaders();

        int number = 5;
        int limit = 3;
        int power = 2;

        assertThat(test.solution(number, limit, power)).isEqualTo(10);
    }

    @Test
    void solutionCase2() {
        Crusaders test = new Crusaders();

        int number = 10;
        int limit = 3;
        int power = 2;

        assertThat(test.solution(number, limit, power)).isEqualTo(21);
    }
}
