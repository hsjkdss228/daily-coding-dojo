import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FailureRateTest {
  @Test
  void solution() {
    FailureRate failureRate = new FailureRate();

    failureRate.solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3});
  }

}