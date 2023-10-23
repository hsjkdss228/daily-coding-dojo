# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 시소 짝꿍

> 연습문제

- https://school.programmers.co.kr/learn/courses/30/lessons/152996
- 사람들의 몸무게 목록 weights가 주어질 때,
  존재할 수 있는 시소 짝꿍의 쌍의 개수를 return한다.

### 23.2.27

#### 1. 이해

- 시소 짝꿍이란?
  - 시소 좌석에 앉는 사람의 몸무게 * 시소 좌석의 거리 값이 같은 쌍
- 시소의 좌석은 2, 3, 4 거리만큼의 지점에 하나씩 좌석이 있음
- weights의 길이: 2 이상 100,000 이하
- 각 weight의 크기: 100 이상 1000 이하

#### 2. 계획

- 요소는 중복되는 값이 존재할 수 있지만, 쌍은 하나만 존재할 것이다.
- Set\<쌍\>을 놓는다.
  - 쌍의 개수를 파악할 것임
  - 쌍의 요소: 작은 값, 큰 값
- Set\<이미 조회한 값\>을 놓는다.
  - 몸무게 List에서 이미 조회한 값은 해당 Set에 넣을 것임
- weights를 List로 변환한 뒤, List가 빌 때까지 반복
  - weights에서 맨 앞의 값을 remove
  - 맨 앞 weight가 Set\<이미 조회한 값\>에 존재하면 continue
  - 나머지 weights를 순회하면서
    - 순회하고 있는 weight가 기준 weight와 시소 짝꿍이라면
      기준 weight와, 순회하고 있는 weight를 쌍으로 만들어 Set\<쌍\>에 put
  - 맨 처음에 remove했던 맨 앞 weight를 Set\<이미 조회한 값\>에 put 
- Set\<쌍\>의 size를 정답으로 return

#### 3. 실행

- 문제 계획 시간: 12:45-13:15
- 문제 풀이 시간: 13:15-13:25, 25:10-25:40
- 오류 추적 시간: 25:40-26:00

#### 4. 반성

- 쌍에도 중복되는 값이 있을 수 있다. 생각해보면 무게가 같아도 다른 사람이다.
- 중복 쌍을 허용할 경우,
  이중 반복문 순회로 인한 O(n^2)의 시간 복잡도로 인해 시간 초과가 발생한다.
  - 중복이 있어도 되면 굳이 쌍 객체를 정의해 사용할 필요는 없다.
    쌍인지만 확인하면 되기 때문.
  - Set\<쌍\> 대신, 쌍의 개수를 세는 count를 놓는다.
  - List로 변환한 weights를 정렬한다.
  - 똑같이 순회는 하되, 다음의 방식으로 변경한다.
    - 순회하고 있는 weight가 기준 weight와 같으면
      isMate를 수행하지 않고 바로 count += 1한 뒤 continue
  - count를 정답으로 return
- 여전히 시간 초과하므로, 쌍의 중복을 제거하기 위해 Map을 사용한다.

### 23.2.27

#### 2. 계획

- weights를 List가 아닌, Map\<weight, count\>로 변환한다.
  - 중복되는 weight는 count가 여러 개가 되는 식으로 한다.
- Map으로 변환한 weights의 keys를 순회
  - 순회하고 있는 key weight를 기준으로 다시 keys를 순회하면서
    - 비교 weight가 기준 weight와 같으면
      - weight의 value가 2 이상이면
      - count += for (i = 0; i < weight의 value; i += 1) value의 삼각수
    - 비교 weight가 기준 weight와 쌍이면
      - count += 비교 weight의 value * 기준 weight의 value
- count를 정답으로 return

#### 3. 실행

- 문제 계획 시간: 02:00-02:20
- 문제 풀이 시간: 02:20-02:45
