import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Tangerine {
    public int solution(int sum, int[] tangerines) {
        Map<Integer, Integer> sizeAndCounts = new HashMap<>();

        for (int size : tangerines) {
            if (!sizeAndCounts.containsKey(size)) {
                sizeAndCounts.put(size, 1);
                continue;
            }
             sizeAndCounts.replace(size, sizeAndCounts.get(size) + 1);
        }

        List<Integer> values = sizeAndCounts.values()
            .stream()
            .sorted((prev, next) -> next - prev)
            .collect(Collectors.toList());

        int countSum = 0;
        int sizeCount = 0;
        for (int count : values) {
            countSum += count;
            sizeCount += 1;
            if (countSum >= sum) {
                return sizeCount;
            }
        }

        return sizeCount;
    }
}
