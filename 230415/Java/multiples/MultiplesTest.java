import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MultiplesTest {
    private Multiples test;

    @BeforeEach
    void setUp() {
        test = new Multiples();
    }

    @Test
    void streamAlreadyConsumed() {
        Stream<Integer> stream = Stream.of(99, 99, 99, 99);
        stream.forEach(System.out::println);
        assertThrows(IllegalStateException.class, () -> {
            stream.forEach(System.out::println);
        });
    }

    @Test
    void streamSupplier() {
        Supplier<IntStream> supplier = () -> IntStream.of(9, 99, 999, 9999);
        supplier.get().forEach(System.out::println);
        assertDoesNotThrow(() -> {
            supplier.get().forEach(System.out::println);
        });
    }

    @Test
    void integerStreamWithNull() {
        Supplier<Stream<Integer>> supplier = () -> Stream.of(10, null, 12, null);
        supplier.get().forEach(element -> {
            if (element != null) {
                assertThat(element.getClass())
                    .hasSameClassAs(Integer.class);
                return;
            }
            assertThat(element).isNull();
        });

        int[] nullExcepted = {10, 12};
        assertThat(
            supplier.get().filter(Objects::nonNull)
                .mapToInt(multiple -> multiple)
                .toArray()
        ).isEqualTo(nullExcepted);
    }

    @Test
    void solution() {
        int number = 3;
        int[] numbers = {4, 5, 6, 7, 8, 9, 10, 11, 12};
        int[] result = {6, 9, 12};
        assertThat(test.solution(number, numbers)).isEqualTo(result);
    }
}
