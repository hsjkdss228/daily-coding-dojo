import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class EnergyNeedWrongTest {
    @Test
    void isEnoughEnergy() {
        EnergyNeedWrong test = new EnergyNeedWrong();

        int currentEnergy1 = 100;
        int currentEnergy2 = 40;
        int currentEnergy3 = 20;
        List<int[]> dungeons = List.of(
            new int[]{80, 20},
            new int[]{50, 40},
            new int[]{30, 10}
        );

        assertThat(test.isEnoughEnergy(currentEnergy1, dungeons))
            .isTrue();
        assertThat(test.isEnoughEnergy(currentEnergy2, dungeons))
            .isTrue();
        assertThat(test.isEnoughEnergy(currentEnergy3, dungeons))
            .isFalse();
    }

    @Test
    void excludeDungeonsCannotVisit() {
        EnergyNeedWrong test = new EnergyNeedWrong();

        int currentEnergy = 60;
        List<int[]> dungeons = List.of(
            new int[]{80, 20},
            new int[]{50, 40},
            new int[]{30, 10}
        );
        List<int[]> dungeonsCanVisit
            = test.excludeDungeonsCannotVisit(currentEnergy, dungeons);
        assertThat(dungeonsCanVisit.size()).isEqualTo(2);
        assertThat(dungeonsCanVisit.get(0)[0]).isEqualTo(50);
        assertThat(dungeonsCanVisit.get(1)[0]).isEqualTo(30);
    }

    @Test
    void findDungeonIndexToVisit() {
        EnergyNeedWrong test = new EnergyNeedWrong();

        List<int[]> dungeons = List.of(
            new int[]{80, 20},
            new int[]{70, 50},
            new int[]{60, 30},
            new int[]{50, 10},
            new int[]{40, 30}
        );
        assertThat(test.findDungeonIndexToVisit(dungeons))
            .isEqualTo(0);
    }

    @Test
    void solution1() {
        EnergyNeedWrong test = new EnergyNeedWrong();

        int energy = 80;
        int[][] dungeons = new int[][]{
            new int[]{80, 20},
            new int[]{50, 40},
            new int[]{30, 10},
        };
        assertThat(test.solution(energy, dungeons)).isEqualTo(3);
    }

    @Test
    void solution2() {
        EnergyNeedWrong test = new EnergyNeedWrong();

        int energy = 80;
        int[][] dungeons = new int[][]{
            new int[]{80, 30},
            new int[]{50, 20},
            new int[]{30, 10},
        };
        assertThat(test.solution(energy, dungeons)).isEqualTo(3);
    }

    @Test
    void solution3() {
        EnergyNeedWrong test = new EnergyNeedWrong();

        int energy = 80;
        int[][] dungeons = new int[][]{
            new int[]{70, 60},
            new int[]{50, 10},
            new int[]{30, 1},
        };
        assertThat(test.solution(energy, dungeons)).isEqualTo(2);
    }

    @Test
    void solution4() {
        EnergyNeedWrong test = new EnergyNeedWrong();

        int energy = 80;
        int[][] dungeons = new int[][]{
            new int[]{80, 1},
            new int[]{50, 5},
            new int[]{30, 10},
            new int[]{30, 10},
            new int[]{30, 10},
        };
        assertThat(test.solution(energy, dungeons)).isEqualTo(5);
    }
}