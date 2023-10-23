import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class EnergyNeedWrong {
    public int solution(int energy, int[][] dungeons) {
        int currentEnergy = energy;
        List<int[]> dungeonsConvertedToList = Arrays.stream(dungeons)
            .collect(Collectors.toList());

        int answer = 0;

        while (isEnoughEnergy(currentEnergy, dungeonsConvertedToList)) {
            List<int[]> dungeonsCanVisit = excludeDungeonsCannotVisit(
                currentEnergy,
                dungeonsConvertedToList
            );

            int dungeonIndexToVisit = findDungeonIndexToVisit(dungeonsCanVisit);

            System.out.println("foundIndex: " + dungeonIndexToVisit);
            System.out.println("최소 필요 피로도: " + dungeonsCanVisit.get(dungeonIndexToVisit)[0]);
            System.out.println("소모 피로도: " + dungeonsCanVisit.get(dungeonIndexToVisit)[1]);
            System.out.println();

            answer += 1;
            currentEnergy -= dungeonsCanVisit.get(dungeonIndexToVisit)[1];
            dungeonsCanVisit.remove(dungeonIndexToVisit);
            dungeonsConvertedToList = dungeonsCanVisit;
        }

        return answer;
    }

    public boolean isEnoughEnergy(int currentEnergy,
                                  List<int[]> dungeons) {
        for (int[] dungeon : dungeons) {
            if (dungeon[0] <= currentEnergy) {
                return true;
            }
        }

        return false;
    }

    public List<int[]> excludeDungeonsCannotVisit(int currentEnergy,
                                                  List<int[]> dungeons) {
        return dungeons.stream()
            .filter(dungeon -> dungeon[0] <= currentEnergy)
            .collect(Collectors.toList());
    }

    public int findDungeonIndexToVisit(List<int[]> dungeonsCanVisit) {
        int index = 0;
        int highestEnergyNeed = Integer.MIN_VALUE;

        for (int i = 0; i < dungeonsCanVisit.size(); i += 1) {
            if (dungeonsCanVisit.get(i)[0] > highestEnergyNeed) {
                index = i;
                highestEnergyNeed = dungeonsCanVisit.get(i)[0];
            }
        }

        return index;
    }
}
