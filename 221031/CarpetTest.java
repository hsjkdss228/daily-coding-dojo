import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarpetTest {
  @Test
  void findAllAliquots() {
    Carpet test = new Carpet();

    assertThat(test.findAllAliquots(24)).isEqualTo(List.of(24, 12, 8, 6, 4, 3, 2, 1));
  }

  @Test
  void compareToBrownCarpetCount() {
    Carpet test = new Carpet();

    assertThat(test.compareToBrownCarpetCount(new int[]{12, 2}, 24)).isFalse();
    assertThat(test.compareToBrownCarpetCount(new int[]{6, 4}, 24)).isTrue();
  }

  @Test
  void solution() {
    Carpet test = new Carpet();

    assertThat(test.solution(10, 2)).isEqualTo(new int[]{4, 3});
    assertThat(test.solution(8, 1)).isEqualTo(new int[]{3, 3});
    assertThat(test.solution(24, 24)).isEqualTo(new int[]{8, 6});
  }
}
