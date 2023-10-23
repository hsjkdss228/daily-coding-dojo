import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonalRatingWrong {
    public int solution(int[][] scores) {
        if (unqualified(scores)) {
            return -1;
        }

        Map<Integer, Integer> indexAndScoreSumsMap = new HashMap<>();
        for (int index = 0; index < scores.length; index += 1) {
            int scoreSum = scores[index][0] + scores[index][1];
            indexAndScoreSumsMap.put(index, scoreSum);
        }
        List<Map.Entry<Integer, Integer>> indexAndScoreSumsList
            = new ArrayList<>(indexAndScoreSumsMap.entrySet());

        indexAndScoreSumsList.sort(Comparator.comparingInt(Map.Entry::getValue));

        Map.Entry<Integer, Integer> myIndexAndScoreSum
            = indexAndScoreSumsList.stream()
            .filter(indexAndScoreSum -> indexAndScoreSum.getKey().equals(0))
            .findFirst().get();

        Map.Entry<Integer, Integer> firstIndexAndScoreSumOfSameScoreSum
            = indexAndScoreSumsList.stream()
            .filter(indexAndScoreSum -> indexAndScoreSum
                .getValue().equals(myIndexAndScoreSum.getValue()))
            .findFirst().get();

        return indexAndScoreSumsList
            .indexOf(firstIndexAndScoreSumOfSameScoreSum);
    }

    public boolean unqualified(int[][] scores) {
        int[] myScores = scores[0];
        for (int i = 1; i < scores.length; i += 1) {
            if (myScores[0] < scores[i][0]
                && myScores[1] < scores[i][1]) {
                return true;
            }
        }
        return false;
    }
}
