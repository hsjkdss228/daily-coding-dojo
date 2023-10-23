import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RescueBoatTest {
    @Test
    void sort() {
        RescueBoat test = new RescueBoat();

        int[] before = new int[]{50, 40, 100, 20};
        List<Integer> after = List.of(20, 40, 50, 100);
        assertThat(test.sort(before)).isEqualTo(after);
    }



//    @Test
//    void removeFromHighestWhenEqualToLimit() {
//        RescueBoat test = new RescueBoat();
//
//        List<Integer> weights = new ArrayList<>(
//            List.of(10, 90)
//        );
//        int limit = 100;
//        assertThat(test.removeFromHighest(weights, limit)).isEqualTo(100);
//        assertThat(weights.size()).isEqualTo(0);
//    }
//
//    @Test
//    void removeFromHighestWhenLessThanLimit() {
//        RescueBoat test = new RescueBoat();
//
//        List<Integer> weights = new ArrayList<>(
//            List.of(10, 15, 25, 70)
//        );
//        int limit = 100;
//        assertThat(test.removeFromHighest(weights, limit)).isEqualTo(95);
//        assertThat(weights.size()).isEqualTo(2);
//
//    }
//
//    @Test
//    void removeFromLowestWhenEqualToLimit() {
//        RescueBoat test = new RescueBoat();
//
//        List<Integer> weights = new ArrayList<>(
//            List.of(5, 10, 50, 70)
//        );
//        int addedWeight = 85;
//        int limit = 100;
//        assertThat(test.removeFromLowest(weights, addedWeight, limit))
//            .isEqualTo(100);
//        assertThat(weights.size()).isEqualTo(2);
//
//    }
//
//    @Test
//    void removeFromLowestWhenLessThanLimit() {
//        RescueBoat test = new RescueBoat();
//
//        List<Integer> weights = new ArrayList<>(
//            List.of(10, 10, 25, 70)
//        );
//        int addedWeight = 85;
//
//        int limit = 100;
//        assertThat(test.removeFromLowest(weights, addedWeight, limit))
//            .isEqualTo(95);
//        assertThat(weights.size()).isEqualTo(3);
//    }
//
//    @Test
//    void solutionCase1() {
//        RescueBoat test = new RescueBoat();
//
//        int[] weights = new int[]{70, 50, 80, 50};
//        int limit = 100;
//        assertThat(test.solution(weights, limit)).isEqualTo(3);
//    }
//
//    @Test
//    void solutionCase2() {
//        RescueBoat test = new RescueBoat();
//
//        int[] weights = new int[]{70, 50, 80};
//        int limit = 100;
//        assertThat(test.solution(weights, limit)).isEqualTo(3);
//    }
}
