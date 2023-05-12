import java.util.LinkedList;
import java.util.Queue;

public class NumberConverting {
    public static class Number {
        private int value;
        private int operationCount;

        public Number(int value) {
            this.value = value;
            this.operationCount = 0;
        }

        public Number(int value, int operationCount) {
            this.value = value;
            this.operationCount = operationCount;
        }

        public int operationCount() {
            return operationCount;
        }

        public Number minusByN(int n) {
            return new Number(value - n, operationCount + 1);
        }

        public Number divideBy2() {
            return new Number(value / 2, operationCount + 1);
        }

        public Number divideBy3() {
            return new Number(value / 3, operationCount + 1);
        }

        public boolean valueIsEqualTo(int answer) {
            return value == answer;
        }
        
        public boolean valueIsDivisibleBy2() {
            return value % 2 == 0;
        }

        public boolean valueIsDivisibleBy3() {
            return value % 3 == 0;
        }

        public boolean valueIsHigherThanOrEqual(int answer) {
            return value >= answer;
        }
    }

    public int solution(int x, int y, int n) {
        Queue<Number> queue1 = new LinkedList<>();
        Queue<Number> queue2 = new LinkedList<>();

        queue1.add(new Number(y));

        while (true) {
            if (queue1.isEmpty()) {
                break;
            }

            while (!queue1.isEmpty()) {
                Number number = queue1.poll();

                if (number.valueIsEqualTo(x)) {
                    return number.operationCount();
                }

                Number subtractedN = number.minusByN(n);
                Number divides2 = number.valueIsDivisibleBy2()
                    ? number.divideBy2()
                    : null;
                Number divides3 = number.valueIsDivisibleBy3()
                    ? number.divideBy3()
                    : null;

                if (subtractedN.valueIsHigherThanOrEqual(x)) {
                    queue2.add(subtractedN);
                }
                if (divides2 != null && divides2.valueIsHigherThanOrEqual(x)) {
                    queue2.add(divides2);
                }
                if (divides3 != null && divides3.valueIsHigherThanOrEqual(x)) {
                    queue2.add(divides3);
                }
            }

            if (queue2.isEmpty()) {
                break;
            }

            while (!queue2.isEmpty()) {
                Number number = queue2.poll();

                if (number.valueIsEqualTo(x)) {
                    return number.operationCount();
                }

                Number subtractedN = number.minusByN(n);
                Number divides2 = number.valueIsDivisibleBy2()
                    ? number.divideBy2()
                    : null;
                Number divides3 = number.valueIsDivisibleBy3()
                    ? number.divideBy3()
                    : null;

                if (subtractedN.valueIsHigherThanOrEqual(x)) {
                    queue1.add(subtractedN);
                }
                if (divides2 != null && divides2.valueIsHigherThanOrEqual(x)) {
                    queue1.add(divides2);
                }
                if (divides3 != null && divides3.valueIsHigherThanOrEqual(x)) {
                    queue1.add(divides3);
                }
            }
        }

        return -1;
    }
}
