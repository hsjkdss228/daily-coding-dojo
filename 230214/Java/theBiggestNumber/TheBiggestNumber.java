import java.util.Arrays;

public class TheBiggestNumber {
    public String solution(int[] numbersRaw) {
        String[] numbers = Arrays.stream(numbersRaw)
            .mapToObj(Integer::toString)
            .toArray(String[]::new);

        for (int i = 0; i < numbers.length - 1; i += 1) {
            for (int j = i + 1; j < numbers.length; j += 1) {
                String previous = String.valueOf(numbers[i]);
                String next = String.valueOf(numbers[j]);

                int shorterLength
                    = Math.min(previous.length(), next.length());
                String bigger = compare(previous, next, shorterLength);
                String smaller = previous.equals(bigger)
                    ? next
                    : previous;
                numbers[i] = bigger;
                numbers[j] = smaller;
            }
        }

        if (isAllZero(numbers)) {
            return "0";
        }

        return join(numbers);
    }

    public String compare(String previous, String next, int shorterLength) {
//        for (int i = 0; i < shorterLength; i += 1) {
//            int previousDigit = Character.getNumericValue(previous.charAt(i));
//            int nextDigit = Character.getNumericValue(next.charAt(i));
//
////            System.out.println("자리수 순번: " + i);
////            System.out.println("앞에꺼 숫자: " + previousDigit);
////            System.out.println("뒤에꺼 숫자: " + nextDigit);
//
//            if (i + 1 == shorterLength && previousDigit == nextDigit) {
//                String shorter = previous.length() == shorterLength
//                    ? previous
//                    : next;
//                String longer = shorter.equals(previous)
//                    ? next
//                    : previous;
//                if (LongerNumberIsBigger(longer)) {
//                    return longer;
//                }
//                return shorter;
//            }
//            if (previousDigit == nextDigit) {
//                continue;
//            }
//            return previousDigit > nextDigit
//                ? previous
//                : next;
//        }
//
//        return previous;
        return Integer.parseInt(previous + next) < Integer.parseInt(next + previous)
            ? next
            : previous;
    }

    public boolean LongerNumberIsBigger(String longer) {
        int firstDigit = Character.getNumericValue(longer.charAt(0));
        for (int i = 1; i < longer.length(); i += 1) {
            int digit = Character.getNumericValue(longer.charAt(i));
            if (firstDigit == digit) {
                continue;
            }
            return firstDigit < digit;
        }
        return false;
    }

    public boolean isAllZero(String[] numbers) {
        boolean isAllZero = true;
        for (String number : numbers) {
            for (int i = 0; i < number.length(); i += 1) {
                char digit = number.charAt(i);
                if (digit != '0') {
                    isAllZero = false;
                    break;
                }
            }
            if (!isAllZero) {
                break;
            }
        }
        return isAllZero;
    }

    public String join(String[] numbers) {
        return String.join("", numbers);
    }
}
