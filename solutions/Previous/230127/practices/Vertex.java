import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Vertex {
    public int[] solution(int[][] vertices) {
        Map<Integer, Integer> xPositionsAndCounts = new HashMap<>();
        Map<Integer, Integer> yPositionsAndCounts = new HashMap<>();

        for (int[] vertex : vertices) {
            if (xPositionsAndCounts.containsKey(vertex[0])) {
                xPositionsAndCounts.replace(
                    vertex[0],
                    xPositionsAndCounts.get(vertex[0]) + 1
                );
            }
            if (yPositionsAndCounts.containsKey(vertex[1])) {
                yPositionsAndCounts.replace(
                    vertex[1],
                    yPositionsAndCounts.get(vertex[1]) + 1
                );
            }

            if (!xPositionsAndCounts.containsKey(vertex[0])) {
                xPositionsAndCounts.put(vertex[0], 1);
            }
            if (!yPositionsAndCounts.containsKey(vertex[1])) {
                yPositionsAndCounts.put(vertex[1], 1);
            }
        }

        int[] answer = new int[2];

        Set<Map.Entry<Integer, Integer>> xPositionAndCountPairs
            = xPositionsAndCounts.entrySet();
        for (Map.Entry<Integer, Integer> xPositionAndCountPair
            : xPositionAndCountPairs) {
            if (xPositionAndCountPair.getValue() == 1) {
                answer[0] = xPositionAndCountPair.getKey();
            }
        }

        Set<Map.Entry<Integer, Integer>> yPositionAndCountPairs
            = yPositionsAndCounts.entrySet();
        for (Map.Entry<Integer, Integer> yPositionAndCountPair
            : yPositionAndCountPairs) {
            if (yPositionAndCountPair.getValue() == 1) {
                answer[1] = yPositionAndCountPair.getKey();
            }
        }

        return answer;
    }
}
