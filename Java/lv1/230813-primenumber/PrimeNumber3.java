import java.util.HashSet;
import java.util.Set;

public class PrimeNumber3 {
    public int solution(int max) {
        Set<Integer> primeNumbers = new HashSet<>();

        primeNumbers.add(2);

        for (int number = 3; number <= max; number += 2) {
            boolean isPrimeNumber = true;

            for (int primeNumber : primeNumbers) {
                if (number % primeNumber == 0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            if (isPrimeNumber) {
                primeNumbers.add(number);
            }
        }

        return primeNumbers.size();
    }
}
