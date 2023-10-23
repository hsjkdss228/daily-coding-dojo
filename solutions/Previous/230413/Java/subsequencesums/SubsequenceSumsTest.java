import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class SubsequenceSumsTest {
    private SubsequenceSums test;

    @BeforeEach
    void setUp() {
        test = new SubsequenceSums();
    }

//    @Test
//    void contains() {
//        Set<SubsequenceSums.Subsequence> subsequences = Set.of(
//            SubsequenceSums.Subsequence.of(new int[]{1, 2, 3}),
//            SubsequenceSums.Subsequence.of(new int[]{4, 5, 6, 7, 8})
//        );
//        SubsequenceSums.Subsequence target1
//            = SubsequenceSums.Subsequence.of(new int[]{3, 2, 1});
//        assertThat(subsequences.contains(target1)).isTrue();
//        SubsequenceSums.Subsequence target2
//            = SubsequenceSums.Subsequence.of(new int[]{6, 8, 4, 7, 5});
//        assertThat(subsequences.contains(target2)).isTrue();
//        SubsequenceSums.Subsequence target3
//            = SubsequenceSums.Subsequence.of(new int[]{999, 9999, 99999});
//        assertThat(subsequences.contains(target3)).isFalse();
//    }

//    @Test
//    void partOf1() {
//        int[] elements = {9, 99, 999, 9999, 99999, 9999999, 9, 99, 999, 9999, 99999};
//        int start = 1;
//        int end = 4;
//        int[] result = {99, 999, 9999};
//        assertThat(test.partOf(elements, start, end)).isEqualTo(result);
//    }
//
//    @Test
//    void partOf2() {
//        int[] elements = {9, 99, 999, 9999, 99999, 999999, 9, 99, 999, 9999, 99999};
//        int start = 4;
//        int end = 8;
//        int[] result = {99999, 999999, 9, 99};
//        assertThat(test.partOf(elements, start, end)).isEqualTo(result);
//    }

    @Test
    void solution() {
        int[] elements = {7, 9, 1, 1, 4};
        int sumsCount = 18;
        assertThat(test.solution(elements)).isEqualTo(sumsCount);
    }
}
