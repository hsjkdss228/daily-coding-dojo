
# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 영어 끝말잇기
영단어 끝말잇기에 참가하는 참가자 수와 단어 배열이 주어질 때,
탈락자의 번호와, 탈락자가 몇 번째 차례인지 값의 쌍 배열을 반환한다.

#### 1. 이해
- 주어진 것은 무엇인가? / 모르는 것은 무엇인가? / 자료는 무엇인가? / 조건은 무엇인가?
  - 사용자 수, 단어의 개수 및 순서
  - 각 단어의 길이는 매번 다를 수 있음
  - 문자열과 개수
  - 문자열이 많이 주어져도 중간에 탈락자가 나올 수도 있음

#### 2. 계획
- 각 문자열에 대해 순차적으로 사용자 번호, 사용자 차례를 기억하면서
  - 단어가 이전에 나왔는지 확인한다.
  - 앞 단어 마지막 글자와 내 단어 첫 글자가 같은지 확인한다.
  - 하나라도 만족하지 못하면 사용자 번호, 사용자 차례의 쌍이 정답

- 검사한 단어를 넣을 LinkedHashSet을 놓는다.
- 단어 배열을 순서대로 돌면서
  - 단어의 번호, 차례를 기록한다.
  - LinkedHashSet에 단어가 있는지,
    직전에 넣은 단어의맨 뒷글자와 지금 단어의 맨 앞글자가 같은지 확인한다.
  - 조건을 통과하지 못하면 단어의 번호, 차례 쌍이 정답
  - 조건을 통과하면 검사한 단어를 LinkedHashSet에 넣는다. 

#### 3. 실행


#### 4. 반성
- 마지막 단어 때문에 실패한 사용자가 나와야 하는 케이스가 있는데,
  마지막 단어가 이전에 나왔던 단어인지 검사하는 로직을 실행하지 않고 패스하는 문제가 있다.
- 문제는 반복문 안에서 word.equals(firstWord)로 첫 단어를 넣은 경우 다음 반복으로 넘어가도록
  하는 로직이 있었는데, 하필이면 마지막 단어가 첫 단어와 같아서 이 조건에 자꾸 걸렸다.
- 엣지 케이스 예외처리를 위한 로직이 또다른 엣지 케이스를 만들어내는 모습을 볼 수 있었다.
