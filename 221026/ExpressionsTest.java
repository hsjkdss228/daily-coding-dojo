import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ExpressionsTest {
  @Test
  void solution() {
    Expressions test = new Expressions();

    assertThat(test.solution(15)).isEqualTo(4);
  }
}
