import java.util.ArrayList;
import java.util.List;

public class Remainder {
  public int solution(int n) {
// n을 x로 나눈 나머지가 1인 가장 작은 자연수 찾기
// n은 3~1000000 사이
// x는 2부터 시작하는 임의의 자연수
// (1로 나누면 나머지가 항상 0이므로 1부터 시작하는 건 의미가 없음)
// 사실 선형으로 찾으면 장땡이지만 조건을 줄여 보자...
//
// n이 홀수면 x는 무조건 2
// n이 짝수면 x는...
//   - 홀수인 수들 중에서
//   - 범위는 3 이상 500000 미만
//   - 예시
//   - 10 << 3 ... 9 중 3이 가장 작음
//   - 12 << 3 ... 11 중 11이 가장 작음
//   - 38 << 3 5 7 9 11 13 15 17 19 ... 37
//           X X X X X  X  X  X  X      O
//   - 더 좁혀서 범위는 3 이상 n/2 미만 << 중에 있으면 걔고, 없으면 n - 1

    if (n % 2 == 1) {
      return 2;
    }

    for (int i = 3; i < n / 2; i += 2) {
      if (n % i == 1) {
        return i;
      }
    }

    return n - 1;
  }

  public int solution2(int n) {
    List<Integer> numbers = new ArrayList<>();

    for (int i = 0; i < n; i += 1) {
      numbers.add(i + 1);
    }

    return numbers.stream()
        .filter(i -> n % i == 1)
        .findFirst()
        .orElse(n - 1);
  }
}
