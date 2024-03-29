
# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 짝지어 제거하기
문자열이 주어졌을 떄, 이어붙어 있는 같은 알파벳 2개를 제거하고
남은 알파벳들을 이어붙이는 과정을 반복해 문자열을 모두 제거할 수 있는지 확인한다.

#### 1. 이해
- 모르는 것은 무엇인가?
  - 얼마나 긴 알파벳이 주어질지 알 수 없다.
- 주어진 것은 무엇인가?
  - 알파벳으로 이루어진 문자열
- 자료는 무엇인가?
  - String, (사용에 따라 Character)
- 조건은 무엇인가?
  - 알파벳 두 개가 붙어 있으면 문자열에서 제거할 수 있다.
- 조건은 알아내야 하는 것을 찾는데 충분한가?
  - 주어진 조건만을 이용해서 문제 해결 방법을 찾을 수는 있다.
   (숨어 있는 상황을 찾아야 하는 경우는 없음)

#### 2. 계획
- 관련된 문제를 알고 있는가?
- 전에 풀어 본 문제를 활용하려면 어떤 보조 요소를 도입해야 되는가?
- 도움이 될 것 같은 어떤 사실이나 정리를 알고 있는가? (보통은 자료 구조나 수학적 공리 또는 정의가 해당됨)
- 자료와 조건은 모두 활용 했는가? (Edge case가 될 조건을 꼭 확인해야 함)

얼마나 긴 알파벳이 주어질지 알 수 없기 때문에,
알파벳을 제거하는 과정에서 오버헤드를 줄여야 함  
ex. 이어붙은 같은 알파벳들을 " "으로 바꾸고 순회공연을 돌고 나면
" "은 ""으로 바꿔서 문자열들을 잇는 식으로도 할 수 있겠지만,
이러면 작업을 두 번 하는 모양새가 됨  
생각한 방법은
- 문자열을 charAt으로 하나씩 뽑아서 List에 하나씩 add
- 변수를 하나 놓음: 문자열 탐색을 한바퀴 돌기 이전의 List의 길이를 갖고 있을 것임
- 반복을 돌기 전에, List의 길이를 변수에 저장
- while로 변수 크기가 2 이상이라면 아래의 반복 실시
- for문 반복을 돌음
  - 특정 index에서 다음 index의 문자와 내가 같으면 둘 다 delete  
  - 기준은 List의 size (i < size)  
    (길이가 줄어들어도 조건 검사에서 인지할 수 있기 때문에 가변적이여도 괜찮음)
- 반복을 돌고 나서 List의 size가 0이라면 true, 1이라면 false
  - 생각해보니 문자열 길이가 홀수면 시작할 때부터 false로 끝내버리면 됨
- 또는 반복을 돌고 난 뒤의 size와 변수(돌기 전 크기) 값이 같다면 false

시간초과로 실패 (정확성 테스트에서 7초 이상, 효율성 테스트는 굉장히 긴 시간 동안 수행...)

#### 3. 실행
- 각 단계가 올바른지 명확히 알 수 있는가?
- 그것이 옳다는 것을 설명할 수 있는가?

#### 4. 반성
- 다른 방법으로 해결할 수는 없었는가? (이때 다른 사람의 풀이도 참고하면 좋음)
- 결과나 방법을 다른 문제에 활용할 수 있는가? (유용한 패턴은 따로 정리해두자)

Stack을 이용하여 풀이하였다. Stack에 넣을 때마다 인접한 문자와 같으면 삭제하도록
로직을 구현하여 모든 문자열을 제거할 수 있는지 확인하는 반복을 n^2회에서 n회로 줄일 수 있었다.
