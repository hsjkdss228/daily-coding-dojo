public class FindingDigit {
    public int solution(int number, int digit) {
        String numberString = String.valueOf(number);
        char digitChar = Character.forDigit(digit, 10);
        for (int i = 0; i < numberString.length(); i += 1) {
            int digitWithSpecificPlace = numberString.charAt(i);
            if (digitWithSpecificPlace == digitChar) {
                int place = i + 1;
                return place;
            }
        }
        return -1;
    }
}
