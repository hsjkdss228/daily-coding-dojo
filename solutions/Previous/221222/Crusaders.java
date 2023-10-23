public class Crusaders {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        int[] divisors = new int[number + 1];

        for (int index = 1; index <= number; index += 1) {
            divisors[index] = divisorCount(index);

//            System.out.println("divisorCount: " + divisors[index]);
//            System.out.println();

            answer += compareWithLimit(divisors[index], limit, power);
        }

        return answer;
    }

    public int divisorCount(int index) {
        if (index == 1) {
            return 1;
        }

        int count = 0;
        int sqrt = (int) Math.floor(Math.sqrt(index));

//        System.out.print("index: " + index + ", ");
//        System.out.println("sqrt: " + sqrt);

        for (int i = 1; i <= sqrt; i += 1) {
//            System.out.println("i: " + i);
//            System.out.println("index % i: " + index % i);
//            System.out.println("index / i: " + index / i);

            if (index % i == 0) {
                count += 1;

                if (index / i != i) {
                    count += 1;
                }
            }
        }

        return count;
    }

    public int compareWithLimit(int divisorCount, int limit, int power) {
        return divisorCount > limit
            ? power
            : divisorCount;
    }
}
