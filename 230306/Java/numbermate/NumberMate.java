import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class NumberMate {
    public String solution(String number1, String number2) {
        Map<Character, Integer> digitAndCounts = createDigitAndCounts(number1, number2);
        return createAnswer(digitAndCounts);
    }

    public Map<Character, Integer> createDigitAndCounts(String number1, String number2) {
        Map<Character, Integer> digitAndCounts1 = new HashMap<>();
        Map<Character, Integer> digitAndCounts2 = new HashMap<>();
        addDigitAndCounts(digitAndCounts1, number1);
        addDigitAndCounts(digitAndCounts2, number2);
        return selectDigitExistBothAndPutMinimumCount(digitAndCounts1, digitAndCounts2);
    }

    public void addDigitAndCounts(Map<Character, Integer> digitAndCounts, String number1) {
        for (int i = 0; i < number1.length(); i += 1) {
            char digit = number1.charAt(i);
            if (!digitAndCounts.containsKey(digit)) {
                digitAndCounts.put(digit, 1);
                continue;
            }
            digitAndCounts.replace(digit, digitAndCounts.get(digit) + 1);
        }
    }

    public Map<Character, Integer> selectDigitExistBothAndPutMinimumCount(Map<Character, Integer> digitAndCounts1,
                                                                          Map<Character, Integer> digitAndCounts2) {
        Map<Character, Integer> digitAndMinimumCount = new HashMap<>();
        for (char digit = '0'; digit <= '9'; digit += 1) {
            if (digitAndCounts1.containsKey(digit)
                && digitAndCounts2.containsKey(digit)) {
                int minimumCount = Math.min(
                    digitAndCounts1.get(digit),
                    digitAndCounts2.get(digit)
                );
                digitAndMinimumCount.put(digit, minimumCount);
            }
        }
        return digitAndMinimumCount;
    }

    public String createAnswer(Map<Character, Integer> digitAndCounts) {
        if (digitAndCounts.isEmpty()) {
            return "-1";
        }
        if (digitAndCounts.size() == 1
            && digitAndCounts.containsKey('0')) {
            return "0";
        }

        List<String> answer = new ArrayList<>();
        digitAndCounts.entrySet()
            .stream()
            .sorted((previous, next) -> next.getKey() - previous.getKey())
            .forEach(digitAndCount -> {
                String digit = digitAndCount.getKey().toString();
                int count = digitAndCount.getValue();
                IntStream.range(0, count)
                    .forEach(index -> answer.add(digit));
            });
        return String.join("", answer);
    }
}
