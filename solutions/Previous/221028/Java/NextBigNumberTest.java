import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NextBigNumberTest {
  // 자연수 n을 2진수로 변환해 1의 개수를 확인한다.
  // 자연수 n에 1을 더한 결과를 수를 2진수로 변환해 1의 개수를 확인한다.
  // 1을 더한 숫자가 자연수 n과 2진수의 1의 개수가 같으면 그 수가 정답
  // 아니면 계속 1을 더하면서 찾는 과정을 반복한다.

  @Test
  void convertToBinary() {
    NextBigNumber test = new NextBigNumber();

    assertThat(test.convertToBinary(78)).isEqualTo("1001110");
  }

  @Test
  void countOne() {
    NextBigNumber test = new NextBigNumber();

    assertThat(test.countOne("1001110")).isEqualTo(4);
  }

  @Test
  void solution() {
    NextBigNumber test = new NextBigNumber();

    assertThat(test.solution(78)).isEqualTo(83);
  }
}
