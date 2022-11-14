import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class TheLeastCommonMultipleTest {
//    @Test
//    void factorize() {
//        TheLeastCommonMultiple test = new TheLeastCommonMultiple();
//        Map<Integer, Integer> primeFactors = new HashMap<>();
//        primeFactors.put(2, 2);
//        primeFactors.put(3, 1);
//        primeFactors.put(5, 1);
//
//        assertThat(test.factorize(60)).isEqualTo(primeFactors);
//    }

    @Test
    void solution() {
        TheLeastCommonMultiple test = new TheLeastCommonMultiple();
        assertThat(test.solution(new int[]{2, 6, 8, 14}))
            .isEqualTo(168);
        assertThat(test.solution(new int[]{1, 2, 3}))
            .isEqualTo(6);
    }
}
