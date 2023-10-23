import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RescueBoat {
    public int solution(int[] weights, int limit) {
        List<Integer> sorted = sort(weights);

        int answer = 0;

//        while (!sorted.isEmpty()) {
//            int addedWeight = removeFromHighest(sorted, limit);
//            addedWeight = removeFromLowest(sorted, addedWeight, limit);
//            answer += 1;
//        }



        return answer;
    }

    public List<Integer> sort(int[] weights) {
        Arrays.sort(weights);

        List<Integer> listedWeights = new ArrayList<>();
        Arrays.stream(weights)
            .sorted()
        ;

        return listedWeights;
    }

//    public int removeFromHighest(List<Integer> weights, int limit) {
//        int addedWeight = 0;
//
//        while (addedWeight < limit
//            && !weights.isEmpty()
//            && addedWeight + weights.get(weights.size() - 1) <= 100) {
//            addedWeight += weights.remove(weights.size() - 1);
//        }
//
//        return addedWeight;
//    }
//
//    public int removeFromLowest(List<Integer> weights,
//                                int addedWeight,
//                                int limit) {
//        while (addedWeight < limit
//            && !weights.isEmpty()
//            && addedWeight + weights.get(0) <= 100) {
//            addedWeight += weights.remove(0);
//        }
//
//        return addedWeight;
//    }
}
