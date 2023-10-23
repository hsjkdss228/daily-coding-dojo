public class EnergyNeed {
    private int answer = 0;

    public int solution(int energy, int[][] dungeons) {
        for (int startIndex = 0;
             startIndex < dungeons.length;
             startIndex += 1
        ) {
            int visitCount = 0;

//            System.out.println("start Index: " + startIndex);
            visitDungeon(
                startIndex,
                new boolean[dungeons.length],
                dungeons,
                "",
                energy,
                visitCount
            );
        }

        return answer;
    }

    public void visitDungeon(int indexToVisit,
                            boolean[] visitedDungeons,
                            int[][] dungeons,
                            String visitOrder,
                            int currentEnergy,
                            int visitCount
    ) {
        boolean isVisitedDungeon = visitedDungeons[indexToVisit];
        if (isVisitedDungeon
            || dungeons[indexToVisit][0] > currentEnergy) {
//            System.out.println("stopped that case");
            return;
        }

        visitedDungeons[indexToVisit] = true;
        visitCount += 1;
        currentEnergy -= dungeons[indexToVisit][1];
        visitOrder += indexToVisit;

        if (answer < visitCount) {
            answer = visitCount;
        }

        boolean visitFinished = true;
        for (boolean visited : visitedDungeons) {
            if (!visited) {
                visitFinished = false;
                break;
            }
        }
        if (visitFinished) {
//            System.out.println("visit finished");
//            System.out.println("visit order: " + visitOrder);
//            System.out.println();
            return;
        }

//        System.out.println("visited dungeons: " + Arrays.toString(visitedDungeons));

        for (int newIndexToVisit = 0;
             newIndexToVisit < dungeons.length;
             newIndexToVisit += 1
        ) {
//            System.out.println("visit " + newIndexToVisit + " dungeon");
            visitDungeon(
                newIndexToVisit,
                visitedDungeons.clone(),
                dungeons,
                visitOrder,
                currentEnergy,
                visitCount
            );
        }
    }
}
