public class MatchingTable {
    public int solution(int participants, int number1, int number2) {
        int startRound = 1;
        int[] roundAndNumbers = new int[]{startRound, number1, number2};

        while (checkIfHaveToExecute(roundAndNumbers[1], roundAndNumbers[2])) {
            roundAndNumbers = executeRoundMatch(roundAndNumbers);
        }

        return roundAndNumbers[0];
    }

    public int[] executeRoundMatch(int[] roundAndNumbers) {
        int round = roundAndNumbers[0] + 1;

        if (roundAndNumbers[1] % 2 == 1) {
            roundAndNumbers[1] += 1;
        }
        if (roundAndNumbers[2] % 2 == 1) {
            roundAndNumbers[2] += 1;
        }

        return new int[]{
            round,
            roundAndNumbers[1] / 2,
            roundAndNumbers[2] / 2
        };
    }

    public boolean checkIfHaveToExecute(int number1, int number2) {
        if (Math.abs(number1 - number2) == 1
            && ((number1 > number2 && number1 % 2 == 0)
            || (number2 > number1 && number2 % 2 == 0))) {
            return false;
        }
        return true;
    }
}
