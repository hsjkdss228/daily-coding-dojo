import java.util.Arrays;
import java.util.stream.Stream;

public class Quiz {
    public enum Operator {
        PLUS,
        MINUS;

        public static Operator of(String part) {
            return part.equals("+") ? PLUS : MINUS;
        }
    }

    public static class Expression {
        private final int[] factors;
        private final Operator operator;
        private final int result;

        public Expression(int[] factors, Operator operator, int result) {
            this.factors = factors;
            this.operator = operator;
            this.result = result;
        }

        public static Expression create(String expression) {
            String[] parts = expression.split(" ");
            int[] factors = factors(parts[0], parts[2]);
            Operator operator = Operator.of(parts[1]);
            int result = applySign(parts[4]);
            return new Expression(factors, operator, result);
        }

        private static int[] factors(String factor1, String factor2) {
            return Stream.of(applySign(factor1), applySign(factor2))
                .mapToInt(number -> number)
                .toArray();
        }

        private static int applySign(String factor) {
            if (factor.contains("-")) {
                String number = factor.substring(1);
                return Integer.parseInt(number) * -1;
            }
            return Integer.parseInt(factor);
        }

        public String checkExpressionValidity() {
            int factor1OperatorFactor2 = operator == Operator.PLUS
                ? factors[0] + factors[1]
                : factors[0] - factors[1];
            return factor1OperatorFactor2 == result
                ? "O"
                : "X";
        }
    }

    public String[] solution(String[] expressions) {
        return Arrays.stream(expressions)
            .map(expression -> Expression.create(expression)
                .checkExpressionValidity())
            .toArray(String[]::new);
    }
}
