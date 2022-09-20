import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NQueenTest {
  @Test
  void solution() {
    NQueen test = new NQueen();

    assertThat(test.solution(4)).isEqualTo(2);
  }
}
