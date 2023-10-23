import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class TrioTest {
    private Trio test;

    @BeforeEach
    void setUp() {
        test = new Trio();
    }

    @Test
    void indicesEquals1() {
        assertThat(new Trio.Indices(1, 3, 5))
            .isEqualTo(new Trio.Indices(3, 1, 5));
    }

    @Test
    void indicesEquals2() {
        assertThat(new Trio.Indices(1, 2, 3))
            .isEqualTo(new Trio.Indices(2, 3, 1));
        assertThat(new Trio.Indices(2, 3, 1))
            .isEqualTo(new Trio.Indices(1, 2, 3));
    }

    @Test
    void indicesNotEquals() {
        assertThat(new Trio.Indices(1, 3, 5))
            .isNotEqualTo(new Trio.Indices(1, -2, 3));
    }

    @Test
    void hash() {
        assertThat(Objects.hash(1, 2, 3)).isNotEqualTo(Objects.hash(2, 3, 1));
        assertThat(Objects.hash(1) + Objects.hash(2) + Objects.hash(3))
            .isEqualTo(Objects.hash(2) + Objects.hash(3) + Objects.hash(1));
    }

    @Test
    void createIndicesSet() {
        int length = 4;
        assertThat(test.createIndicesSet(length))
            .isEqualTo(Set.of(
                Trio.Indices.of(0, 1, 2),
                Trio.Indices.of(0, 1, 3),
                Trio.Indices.of(0, 2, 3),
                Trio.Indices.of(1, 2, 3)
            ));
    }

    @Test
    void solution1() {
        int[] numbers = {-2, 3, 0, 2, -5};
        assertThat(test.solution(numbers)).isEqualTo(2);
    }

    @Test
    void solution2() {
        int[] numbers = {-3, -2, -1, 0, 1, 2, 3};
        assertThat(test.solution(numbers)).isEqualTo(5);
    }

    @Test
    void solution3() {
        int[] numbers = {-1, 1, -1, 1};
        assertThat(test.solution(numbers)).isEqualTo(0);
    }
}
