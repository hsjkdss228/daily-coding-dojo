import java.util.HashSet;
import java.util.Set;

public class PrimeNumber5 {
    public int solution(int max) {
        Set<Integer> primeNumbers = new HashSet<>();
        Set<Integer> nonPrimeNumbers = new HashSet<>();

        for (int number = 3; number <= max; number += 2) {
            if (nonPrimeNumbers.contains(number)) {
                continue;
            }

            primeNumbers.add(number);

            int multiple = number;
            int multiplier = 2;
            while (multiple <= max) {
                multiple = number * multiplier;
                nonPrimeNumbers.add(multiple);
                multiplier += 1;
            }
        }

        // 2는 여기에 포함
        return primeNumbers.size() + 1;
    }
}

