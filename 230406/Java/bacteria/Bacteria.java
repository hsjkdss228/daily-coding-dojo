import java.util.stream.IntStream;

public class Bacteria {
    public int solution(int initialCount, int hour) {
        return IntStream.range(0, hour)
            .boxed()
            .reduce(initialCount, (count, currentHour) -> count * 2);
    }
}
