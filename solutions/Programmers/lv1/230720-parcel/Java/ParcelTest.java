import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParcelTest {
    private Parcel test;

    @BeforeEach
    void setUp() {
        test = new Parcel();
    }

    @Nested
    class Ship {
        @Test
        void ship1() {
            int capacity = 4;
            int startIndex = 4;
            int[] deliveries = {1, 0, 3, 1, 2};
            boolean remains = test.ship(capacity, startIndex, deliveries);
            assertThat(remains).isTrue();
            assertThat(deliveries).isEqualTo(new int[]{1, 0, 2, 0, 0});
        }

        @Test
        void ship2() {
            int capacity = 2;
            int startIndex = 6;
            int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
            boolean remains = test.ship(capacity, startIndex, deliveries);
            assertThat(remains).isFalse();
            assertThat(deliveries).isEqualTo(new int[]{1, 0, 2, 0, 1, 0, 0});
        }

        @Test
        void ship3() {
            int capacity = 5;
            int startIndex = 9;
            int[] pickups = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
            boolean remains = test.ship(capacity, startIndex, pickups);
            assertThat(remains).isTrue();
            assertThat(pickups).isEqualTo(new int[]{3, 3, 3, 3, 3, 3, 3, 3, 1, 0});
        }
    }

    @Nested
    class Solution {
        @Test
        void solution1() {
            int capacity = 4;
            int n = 5;
            int[] deliveries = {1, 0, 3, 1, 2};
            int[] pickups = {0, 3, 0, 4, 0};
            assertThat(test.solution(capacity, n, deliveries, pickups))
                .isEqualTo(16);
        }

        @Test
        void solution2() {
            int capacity = 2;
            int n = 7;
            int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
            int[] pickups = {0, 2, 0, 1, 0, 2, 0};
            assertThat(test.solution(capacity, n, deliveries, pickups))
                .isEqualTo(30);
        }

        @Test
        void solutionWithNoDeliveriesAndPickups() {
            int capacity = 1;
            int n = 5;
            int[] deliveries = {0, 0, 0, 0, 0};
            int[] pickups = {0, 0, 0, 0, 0};
            assertThat(test.solution(capacity, n, deliveries, pickups))
                .isEqualTo(0);
        }

        @Test
        void solution3() {
            int capacity = 5;
            int n = 10;
            int[] deliveries = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
            int[] pickups = {3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
            assertThat(test.solution(capacity, n, deliveries, pickups))
                .isEqualTo(158);
        }
    }
}
