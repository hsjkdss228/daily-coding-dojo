import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Keyboard {
    public int[] solution(String[] keymap, String[] targets) {
        Map<Character, Integer> alphabetAndCounts = mapMinimumCounts(keymap);
        return countTargets(alphabetAndCounts, targets);
    }

    public Map<Character, Integer> mapMinimumCounts(String[] keymap) {
        Map<Character, Integer> alphabetAndCounts = new HashMap<>();
        Arrays.stream(keymap)
            .forEach(key -> IntStream.range(0, key.length())
                .forEach(index -> {
                    char alphabet = key.charAt(index);
                    int pushedCount = index + 1;
                    if (alphabetAndCounts.containsKey(alphabet)
                        && alphabetAndCounts.get(alphabet) > pushedCount) {
                        alphabetAndCounts.replace(alphabet, pushedCount);
                        return;
                    }
                    if (alphabetAndCounts.containsKey(alphabet)
                        && alphabetAndCounts.get(alphabet) <= pushedCount) {
                        return;
                    }
                    alphabetAndCounts.put(alphabet, pushedCount);
                }));
        return alphabetAndCounts;
    }

    public int[] countTargets(Map<Character, Integer> alphabetAndCounts,
                              String[] targets) {
        return Arrays.stream(targets)
            .map(target -> IntStream.range(0, target.length())
                .reduce(0, (sum, index) -> {
                    char alphabet = target.charAt(index);
                    if (sum == -1) {
                        return sum;
                    }
                    if (!alphabetAndCounts.containsKey(alphabet)) {
                        return -1;
                    }
                    return sum + alphabetAndCounts.get(alphabet);
                }))
            .mapToInt(count -> count)
            .toArray();
    }
}
