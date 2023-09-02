import java.util.HashMap;
import java.util.Map;

public class MajorityElement1 {
    public int majorityElement(int[] numbers) {
        Map<Integer, Integer> elementAndCounts = new HashMap<>();

        for (int number : numbers) {
            if (elementAndCounts.containsKey(number)) {
                elementAndCounts.put(number, elementAndCounts.get(number) + 1);
                continue;
            }
            elementAndCounts.put(number, 1);
        }

        return elementAndCounts.entrySet()
            .stream()
            .min((previous, next) -> next.getValue() - previous.getValue())
            .get()
            .getKey();
    }
}
