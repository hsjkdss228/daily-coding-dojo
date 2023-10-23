import java.util.ArrayList;
import java.util.List;

public class Hamburger {
    public int solution(int[] ingredients) {
        int count = 0;
        List<Integer> stackedIngredients = new ArrayList<>();

        for (int ingredient : ingredients) {
            stackedIngredients.add(ingredient);
            if (stackedIngredients.size() >= 4 && canMakeHamburger(stackedIngredients)) {
                useIngredients(stackedIngredients);
                count += 1;
            }
        }

        return count;
    }

    public boolean canMakeHamburger(List<Integer> stackedIngredients) {
        int lastIngredientIndex = stackedIngredients.size() - 1;
        return stackedIngredients.get(lastIngredientIndex - 3) == 1
            && stackedIngredients.get(lastIngredientIndex - 2) == 2
            && stackedIngredients.get(lastIngredientIndex - 1) == 3
            && stackedIngredients.get(lastIngredientIndex) == 1;
    }

    public void useIngredients(List<Integer> stackedIngredients) {
        for (int i = 0; i < 4; i += 1) {
            int lastIngredientIndex = stackedIngredients.size() - 1;
            stackedIngredients.remove(lastIngredientIndex);
        }
    }
}
