import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SeesawMate {
    public long solution(int[] rawWeights) {
        Map<Integer, Integer> weights = new HashMap<>();
        for (int weight : rawWeights) {
            if (weights.containsKey(weight)) {
                weights.replace(weight, weights.get(weight) + 1);
                continue;
            }
            weights.put(weight, 1);
        }

        long count = 0;
        Set<Integer> checkedWeights = new HashSet<>();
        for (int base : weights.keySet()) {
            for (int other : weights.keySet()) {
                if (checkedWeights.contains(other)) {
                    continue;
                }
                if (base == other && weights.get(base) >= 2) {
                    count += pairsWithSameWeight(weights.get(base));
                    continue;
                }
                if (base != other && isMate(base, other)) {
                    count += (long) weights.get(base) * (long) weights.get(other);
                }
            }
            checkedWeights.add(base);
        }

        return count;
    }

    public long pairsWithSameWeight(int sameWeightCount) {
        long pairCount = 0;
        for (int i = 1; i < sameWeightCount; i += 1) {
            pairCount += i;
        }
        return pairCount;
    }

    public boolean isMate(int base, int other) {
        for (int i = 2; i <= 4; i += 1) {
            for (int j = 2; j <= 4; j += 1) {
                if (base * i == other * j) {
                    return true;
                }
            }
        }
        return false;
    }
}
