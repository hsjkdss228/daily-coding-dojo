# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 인사고과

> 연습문제

- https://school.programmers.co.kr/learn/courses/30/lessons/152995
- 각 사원의 근무 태도 점수, 동료 평가 점수 목록을 담은 이차원 배열 scores가 주어졌을 때,
- 완호의 석차를 return한다.
- 완호가 인센티브를 받지 못할 경우 -1을 return한다.

### 23.4.7

#### 1. 이해

1. 주어진 조건은 무엇인가?
    1. 규칙
        - 인센티브를 지급하는 규칙
          - 어떤 사원이 다른 임의의 사원보다 근무 태도 점수, 동료 평가 점수가 모두 낮은 경우가
            한 번이라도 있다면, 그 사원은 인센티브를 받을 수 없음
          - 그렇지 않은 사원들에 대해 두 점수의 합이 높은 순으로 석차를 내고,
            석차에 따라 인센티브를 차등 지급.
          - 두 점수의 합이 동일한 사원은 동석차이며, 동석차의 수만큼 다음 석차는 건너뜀.
            - ex. 점수의 합이 가장 큰 사원이 2명이라면
            - 1등이 2명. 다음 석차는 2등 없이 3등부터 시작
    2. 제한사항
        - scores의 길이: 1 이상 100,000 이하
        - scores[i]: 특정 사원의
          - scores[i][0]: 근무 태도 점수 (0 이상 100,000 이하)
          - scores[i][1]: 동료 평가 점수 (0 이상 100,000 이하)
        - scores[0]: 완호의 점수
    3. 추론
        - 고려해야 하는 경우
          - 완호가 인센티브를 받지 못하는 경우
          - 완호가 단독으로 석차를 차지한 경우
          - 완호가 동석차를 차지한 경우
        - 특정 사원이 다른 사원보다 두 점수가 모두 낮은지 확인하기 위해
          모든 사원과 일일이 대조하는 것은 시간이 너무 오래 걸림
        - 단 두 석차의 합을 바탕으로 먼저 정렬을 시킨 다음에,
          합이 낮은 사원부터 두 점수를 비교하는 식으로 올라가다가
          둘 다 나보다 높은 사람이 나오면 제외시키는 방식도 써볼 수 있을 것 같다.

2. 내가 이용할 수 있는 것은 무엇인가?
    - 각 사원의 근무 태도 점수, 동료 평가 점수

3. 내가 모르는 건 무엇인가?
    - 각 사원의 두 점수의 합
    - 인센티브를 받을 수 없는 사원이 어떤 사원인지

#### 2. 계획

##### 최초 풀이

- 사원의 점수 객체 정의
  - 멤버 변수
    - 근무 태도 점수
    - 동료 평가 점수
  - 메서드
    - 두 점수의 합
1. 배열의 모든 원소를 사원의 점수 객체들로 만들어 List로 변경
2. 완호의 정보를 담은 사원의 점수 객체의 주소값을 기억
3. List의 사원의 점수 객체들의 합을 비교해 오름차순으로 정렬
4. List에 있는 사원의 점수 객체들 중 순위를 매길 수 없는 사원의 점수 객체는 제거
   - 각 List의 사원의 점수 객체들을 순회
     - 자기 index 뒤의 사원의 점수 객체들을 다시 순회하면서
     - 두 점수 각각이 자신의 두 점수보다 높은 경우, List에서 제외 
5. 완호의 정보를 담은 사원의 점수 객체의 List 내 index를 확인
6. 없으면 -1을 return
7. 완호의 index가 단독 석차이면, index + 1을 return
   - 앞 index와 뒤 index 사원의 점수 객체의 점수 합을 확인해서 
     합이 다르면 완호의 석차는 단독 석차
   - 이때 index가 맨 앞이면 뒤 index만 확인하고, 맨 뒤이면 앞 index만 확인
8. 완호의 석차가 단독 석차가 아니면, 완호가 포함된 공동 석차를 return
   - 완호 앞에 있는 모든 index의 사원의 점수 객체를 조회하는데
   - 두 점수의 합이 완호의 점수의 합과 다른 사원의 점수 객체가 조회된 경우,
     해당 사원의 점수 객체의 index + 2를 return
   - 조회되지 않았으면, 공동 1등인 것이므로 1을 return

#### 3. 실행

- 이해/계획: 20:20-20:30, 20:45-21:00, 21:15-21:40 (50분)
- 풀이: 21:55-22:40 (45분)
- 오류 추적: 22:40-23:00, 10:45-11:25, 12:30-13:00 (90분)

#### 4. 반성

1. 순위를 매길 수 없는 사원의 점수 객체를 제거할 때,
   배열이 점수가 높은 순에서 낮은 순으로 내림차순 정렬되어 있으므로
   배열의 맨 뒤에서부터 앞으로 확인하면서 제거해줬어야 했는데, 반대로 탐색하면서 제거헀다.
2. 중복 순위인지 아닌지 판단하는 로직에서 완호의 index가
   맨 앞 index일 때, 맨 뒤 index일 때를 명시적으로 구분해서 처리
3. 런타임 에러가 발생해 실패하는 케이스가 있고,
   시간 초과가 발생하는 케이스 4개가 있어
   근본적으로 O(n^2)으로 비교해서 순위표에서 제거하는 로직을 개선해야 한다.
4. 런타임 에러 잡기
   1. 완호의 index가 맨 앞 index일 때, 뒤의 요소와 비교한 값을 return했어야 했는데
      return하지 않고 다음으로 넘어갔음
   2. 완호 혼자만 배열에 있을 때는 그냥 1을 return하게 함
5. 시간 초과 잡기
   - https://school.programmers.co.kr/questions/43297
     - 아예 처음부터 모수를 줄인다.
     - 완호보다 점수의 합이 낮은 사원은 나중에 석차에 넣을 수 있건, 없건
       완호의 석차를 따지는 데 상관이 없음.
     - 따라서 처음에 List로 변환할 때, 점수의 합이 완호보다 작으면
       List에 추가하지 않는 것으로 로직을 수정
     - 해결.
   - Bonus: 처음부터 정렬된 List를 만들 수 있다면?
     - PriorityQueue를 써볼 까 했지만 실패.
     - PriorityQueue 구현체의 Queue에 요소들을 삽입한 뒤에,
       ArrayList 구현체의 List로 다시 정의해서
       PriorityQueue에 정렬된 순서 그대로 ArrayList에
       담으면 정렬도 한번에 하면서 List에 index로 접근할 수 있을까 생각했음.
     - 정렬은 되었으나, 의도대로 '정확하게' 합의 내림차순으로는 정렬되지 않고
       PriorityQueue의 성질만 만족하게끔 (이진 트리의 부모 노드가 두 자식 노드보다 큰 값을 만족하게끔)
       정렬되기 때문에 어짜피 정렬을 한번 더 수행해야 한다.
     - 그렇다고 아무 소득이 없는 건 아니고,
       List나 Queue 같은 컬렉션들을 메서드에 파라미터로 전달할 때
       메서드 시그니처에 인자의 타입을 상위 타입으로 받을 수 있다는 사실을 알았다.
       - 이를테면 Collection<T>로 인자를 받으면, 파라미터로 Collection의 하위 타입인
         List<T>나 Queue<T> 같은 하위 컬렉션들을 전달할 수 있다.
         대신 메서드는 Collection 타입에서 사용할 수 있는 메서드만 사용할 수 있다.