import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FoodFight {
    public String solution(int[] foods) {
        for (int i = 1; i < foods.length; i += 1) {
            foods[i] -= 1;
        }

        List<Integer> answer = new ArrayList<>();
        answer.add(0);
        for (int index = foods.length - 1; index >= 1; index -= 1) {
            for (int j = 0; j < foods[index]; j += 2) {
                answer.add(index);
                answer.add(0, index);
            }
        }

        return answer.stream()
            .map(Object::toString)
            .collect(Collectors.joining());
    }
}
