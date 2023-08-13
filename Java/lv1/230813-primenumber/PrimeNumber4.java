import java.util.HashSet;
import java.util.Set;

public class PrimeNumber4 {
    public int solution(int max) {
        Set<Integer> primeNumbers = new HashSet<>();
        Set<Integer> nonPrimeNumbers = new HashSet<>();

        primeNumbers.add(2);

        for (int number = 3; number <= max; number += 2) {
            if (nonPrimeNumbers.contains(number)) {
                continue;
            }

            primeNumbers.add(number);

            int squaredNumber = number;
            while (squaredNumber <= max) {
                squaredNumber *= number;
                nonPrimeNumbers.add(squaredNumber);
            }

            for (int primeNumber : primeNumbers) {
                int nonPrimeNumber = primeNumber * number;
                if (nonPrimeNumber <= max) {
                    nonPrimeNumbers.add(nonPrimeNumber);
                }
            }
        }

        return primeNumbers.size();
    }
}
