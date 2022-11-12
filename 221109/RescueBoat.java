import java.util.Arrays;

public class RescueBoat {
    public int solution(int[] weights, int limit) {
        Arrays.sort(weights);

        int answer = 0;
        int index = 0;

        for (int i = weights.length - 1; i >= index; i -= 1) {
            if (weights[i] + weights[index] <= limit) {
                index += 1;
                answer += 1;
                continue;
            }

            if (weights[i] + weights[index] > limit) {
                answer += 1;
            }
        }

        return answer;
    }
}
