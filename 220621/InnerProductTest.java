import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InnerProductTest {

  @Test
  void example1() {
    InnerProduct testApplication = new InnerProduct();

    assertEquals(
        3,
        testApplication.solution(new int[]{1, 2, 3, 4}, new int[]{-3, -1, 0, 2})
    );
  }

  @Test
  void example2() {
    InnerProduct testApplication = new InnerProduct();

    assertEquals(
        -2,
        testApplication.solution(new int[]{-1, 0, 1}, new int[]{1, 0, -1})
    );
  }
}