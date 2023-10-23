import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AverageTest {
    @Test
    public void example1() {
        Average testApplication = new Average();

        int[] array = new int[]{1, 2, 3, 4};

        assertEquals(2.5, testApplication.solution(array), 0.000001);
    }

    @Test
    public void example2() {
        Average testApplication = new Average();

        int[] array = new int[]{5, 5};

        assertEquals(5, testApplication.solution(array), 0.000001);
    }
}
