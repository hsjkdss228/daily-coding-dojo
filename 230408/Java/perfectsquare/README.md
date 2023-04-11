# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 제곱수 판별하기

> 코딩테스트 입문

- https://school.programmers.co.kr/learn/courses/30/lessons/120909
- 정수 number가 매개변수로 주어질 때,
- number가 제곱수이면 true를, 아니면 false를 반환한다.

### 23.4.8

#### 1. 이해

1. 주어진 조건은 무엇인가?
   1. 규칙
      - 제곱수: 어떤 자연수를 제곱했을 때 나오는 정수
   2. 제한사항
      - number의 크기: 1 이상 100,000 이하
   3. 추론

2. 내가 이용할 수 있는 것은 무엇인가?
   - 제곱수는 어떤 자연수의 '제곱'이라는 점

3. 내가 모르는 건 무엇인가?
   - 모두 파악.

#### 2. 계획

##### 최초 풀이

1. 자연수 1부터 시작
   - 기반 수의 제곱이 number보다 작으면 계속 반복
     - 기반 수의 제곱이 number와 같으면 제곱수
     - 아니면 기반 수에 1을 더해 다음 수의 제곱수를 확인
   - 기반 수가 number보다 커졌으면 제곱수가 아님

#### 3. 실행

- 이해/계획: 23:30-23:35
- 풀이: 23:35-23:40

#### 4. 반성

- 해당 수가 1이 아니라면, 제곱근을 구해 자연수인지 아닌지
  판별하는 방식으로도 제곱수인지 판별할 수 있다.