
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
    - 조건의 조합이 필요하다. 

#### 2. 계획
- 관련된 문제를 알고 있는가?
- 전에 풀어 본 문제를 활용하려면 어떤 보조 요소를 도입해야 되는가?
- 도움이 될 것 같은 어떤 사실이나 정리를 알고 있는가? (보통은 자료 구조나 수학적 공리 또는 정의가 해당됨)
- 자료와 조건은 모두 활용 했는가? (Edge case가 될 조건을 꼭 확인해야 함)

  - 노란색 격자가 어떤 두 수의 곱인지 알아낸다.
  - 갈색 격자의 수를 어떻게 활용할 것인가?
    - 노란색 격자 수의 약수를 구한다. (ex. 9라면 9, 3, 1)
    - 약수의 왼쪽 끝, 오른쪽 끝의 곱으로부터 시작해서 왼쪽 끝은 하나씩 오른쪽으로, 오른쪽 끝은
      하나씩 왼쪽으로 옮기는데, 같거나 교차할 때까지 반복한다. (ex. <9, 1>, <3, 3>)
    - 두 수에 각각 2를 곱해서 더한 뒤 거기에 4를 더한 숫자가 갈색 블록 개수와 같다면,
      정답은 <왼쪽 약수 + 2, 오른쪽 약수 + 2>

#### 3. 실행
- 각 단계가 올바른지 명확히 알 수 있는가?
- 그것이 옳다는 것을 설명할 수 있는가?

#### 4. 반성
- 다른 방법으로 해결할 수는 없었는가? (이때 다른 사람의 풀이도 참고하면 좋음)
- 결과나 방법을 다른 문제에 활용할 수 있는가? (유용한 패턴은 따로 정리해두자)
