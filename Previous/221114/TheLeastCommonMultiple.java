import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheLeastCommonMultiple {
    public int solution(int[] numbers) {
        return Arrays.stream(numbers)
            .reduce(this::leastCommonMultiple)
            .getAsInt();
    }

    public int leastCommonMultiple(int number1, int number2) {
        return (number1 * number2) / greatestCommonDenominator(number1, number2);
    }

    public int greatestCommonDenominator(int number1, int number2) {
        int temp;
        while (number2 != 0) {
            temp = number1 % number2;
            number1 = number2;
            number2 = temp;
        }
        return number1;
    }

//    public Map<Integer, Integer> factorize(int number) {
//        Map<Integer, Integer> primeFactors = new HashMap<>();
//        System.out.println("number: " + number);
//        System.out.println("sqrt: " + Math.sqrt(number));
//
//        for (int i = 1; i < Math.sqrt(number); i += 1) {
//            System.out.println("i: " + i);
//            System.out.println("number % i: " + (number % i));
//            System.out.println("Size of Map: " + primeFactors.size());
//
//            if (number % i == 0 && !primeFactors.containsKey(i)) {
//                primeFactors.put(i, 1);
//            }
//            if (number % i == 0 && primeFactors.containsKey(i)) {
//                primeFactors.replace(i, primeFactors.get(i) + 1);
//            }
//        }
//
//        return primeFactors;
//    }
}
