import java.util.Arrays;

public class FruitSeller {
    public int solution(int k, int numberInBox, int[] scoresPrimitive) {
        if (numberInBox > scoresPrimitive.length) {
            return 0;
        }

        Integer[] scores = Arrays.stream(scoresPrimitive)
            .boxed()
            .toArray(Integer[]::new);

        sortInDescendingOrder(scores);

        int answer = 0;

        for (int i = numberInBox - 1; i < scores.length; i += numberInBox) {
            answer += scores[i] * numberInBox;
        }

        return answer;
    }

    public void sortInDescendingOrder(Integer[] scores) {
        Arrays.sort(scores, (a, b) -> b - a);
    }
}
