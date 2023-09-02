import java.util.HashMap;
import java.util.Map;

public class MajorityElement2 {
    public int majorityElement(int[] numbers) {
        Map<Integer, Integer> elementAndCounts = new HashMap<>();

        for (int number : numbers) {
            if (elementAndCounts.containsKey(number)) {
                elementAndCounts.put(number, elementAndCounts.get(number) + 1);
                continue;
            }
            elementAndCounts.put(number, 1);
        }

        int majority = 0;
        int count = 0;
        for (Map.Entry<Integer, Integer> elementAndCount : elementAndCounts.entrySet()) {
            if (elementAndCount.getValue() > count) {
                count = elementAndCount.getValue();
                majority = elementAndCount.getKey();
            }
        }
        return majority;
    }
}
