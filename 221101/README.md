
# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 카펫
갈색 격자의 수 brown, 노란색 격자의 수 yellow가 매개변수로 주어질 때,
카펫의 가로, 세로 크기를 순서대로 담아 배열에 return한다.


#### 1. 이해
- 모르는 것은 무엇인가?
    - 카펫의 가로, 세로 크기
- 주어진 것은 무엇인가?
    - 중앙의 노란색 격자의 수, 노란색 격자를 둘러싼 갈색 격자의 수
- 자료는 무엇인가?
    - 자연수? 배열?
- 조건은 무엇인가?
    - 갈색 격자가 노란색 격자를 완전히 둘러싼다.
    - 갈색 격자 수는 8 이상 5000 이하인 자연수
    - 노란색 격자 수는 1 이상 2000000 이하인 자연수
    - 카펫의 가로 길이는 세로 길이와 같거나 세로 길이보다 길다
- 조건은 알아내야 하는 것을 찾는데 충분한가?

#### 2. 계획
- 관련된 문제를 알고 있는가?
- 전에 풀어 본 문제를 활용하려면 어떤 보조 요소를 도입해야 되는가?
- 도움이 될 것 같은 어떤 사실이나 정리를 알고 있는가? (보통은 자료 구조나 수학적 공리 또는 정의가 해당됨)
- 자료와 조건은 모두 활용 했는가? (Edge case가 될 조건을 꼭 확인해야 함)

- Java 풀이를 JavaScript의 함수형 풀이로 전환할 수 있는가?

- 노란색 격자가 어떤 두 수의 곱인지 알아낸다.
    - 노란색 격자 수의 약수를 구한다. (ex. 9라면 9, 3, 1)
        - reduce를 이용, accumulator를 배열로 두고 구해지는 약수를 accumulator에 push한다.
- 갈색 격자의 수를 어떻게 활용할 것인가?
    - 판별을 위해 약수 배열에서 두 값을 꺼내서 쌍으로 만든다.
      인덱스는 각각 왼쪽 끝, 오른쪽 끝부터 시작해서 한 칸씩 안쪽으로 옮겨온다. (ex. <27, 1>, <9, 3>)
      두 수에 각각 2를 곱해서 더한 뒤 거기에 4를 더한 숫자가 갈색 블록 개수와 같다면,
      정답은 <왼쪽 약수 + 2, 오른쪽 약수 + 2>
        - reduce를 사용해 실행문 안에서 쌍을 만들고 답이면 accumulator 값을 대체한다.
        - 오른쪽 인덱스가 왼쪽 인덱스보다 커지면 reduce를 탈출한다.
        - 최종적으로 남은 accumulator가 정답

#### 3. 실행
- 각 단계가 올바른지 명확히 알 수 있는가?
- 그것이 옳다는 것을 설명할 수 있는가?

#### 4. 반성
- 다른 방법으로 해결할 수는 없었는가? (이때 다른 사람의 풀이도 참고하면 좋음)
- 결과나 방법을 다른 문제에 활용할 수 있는가? (유용한 패턴은 따로 정리해두자)

- for문에서는 손쉽게 할 수 있었던 break를 함수형 메서드에서는 배열의 범위를 줄여버려서
  중단시키는 방식을 사용해야 하는데, 의미를 드러내면서 중단시킬 수 있는 방식이 없을지 궁금하다.