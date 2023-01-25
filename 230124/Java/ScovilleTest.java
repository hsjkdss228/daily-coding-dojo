import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

class ScovilleTest {
    @Test
    void solution1() {
        Scoville test = new Scoville();

        int[] scovilles = new int[]{1, 2, 3, 9, 10, 12};
        int target = 7;
        assertThat(test.solution(scovilles, target))
            .isEqualTo(2);
    }

//    @Test
//    void sortScovillesChanged() {
//        Scoville test = new Scoville();
//
//        Stack<Integer> scovillesChanged = new Stack<>();
//        scovillesChanged.push(12);
//        scovillesChanged.push(10);
//        scovillesChanged.push(9);
//        scovillesChanged.push(3);
//        int newScoville = 5;
//        test.sortScovillesChanged(scovillesChanged, newScoville);
//        assertThat(scovillesChanged.pop()).isEqualTo(3);
//        assertThat(scovillesChanged.pop()).isEqualTo(5);
//        assertThat(scovillesChanged.pop()).isEqualTo(9);
//    }
}
