public class PrimeNumber2 {
    public int solution(int max) {
        int answer = 1;

        for (int number = 3; number <= max; number += 2) {
            for (int i = 3; i <= number; i += 2) {
                if (i == number && number % i == 0) {
                    answer += 1;
                }

                if (number % i == 0) {
                    break;
                }
            }
        }

        return answer;
    }
}
