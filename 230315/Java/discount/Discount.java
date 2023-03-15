import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Discount {
    public int solution(String[] wants,
                        int[] numbers,
                        String[] rawDiscounts) {
        List<String> discounts = Arrays.stream(rawDiscounts)
            .collect(Collectors.toList());
        List<String> discountsFor10Days = new ArrayList<>();

        addDiscountsFor9Days(discounts, discountsFor10Days);

        int result = 0;
        while (!discounts.isEmpty()) {
            discountsFor10Days.add(discounts.remove(0));
            if (canGetDiscountForAll(wants, numbers, discountsFor10Days)) {
                result += 1;
            }
            discountsFor10Days.remove(0);
        }

        return result;
    }

    public boolean canGetDiscountForAll(String[] wants,
                                        int[] numbers,
                                        List<String> discountsFor10Days) {
        Map<String, Integer> productAndCount = new HashMap<>();

        discountsFor10Days.forEach(discount -> {
            if (productAndCount.containsKey(discount)) {
                productAndCount.replace(
                    discount,
                    productAndCount.get(discount) + 1
                );
                return;
            }
            productAndCount.put(discount, 1);
        });

        for (int i = 0; i < wants.length; i += 1) {
            String product = wants[i];
            int count = numbers[i];
            if (!productAndCount.containsKey(product)
                || productAndCount.get(product) != count) {
                return false;
            }
        }
        return true;
    }

    public void addDiscountsFor9Days(List<String> discounts,
                                     List<String> discountsFor10Days) {
        for (int i = 0; i < 9; i += 1) {
            discountsFor10Days.add(discounts.remove(0));
        }
    }
}
