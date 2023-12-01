# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 세균 증식

> 코딩테스트 입문

- https://school.programmers.co.kr/learn/courses/30/lessons/120910
- 처음 세균의 마리수 bacteriaCount와 경과한 시간 hour가 매개변수로 주어질 때,
  hour시간 후의 세균의 수를 return한다.

### 23.4.6

#### 1. 이해

1. 주어진 조건은 무엇인가?
   1. 규칙
      - 세균은 1시간에 두 배만큼 증식
   2. 제한사항
      - initialCount의 크기: 1 이상 10 이하
      - hour의 크기: 1 이상 15 이하
   3. 추론

2. 내가 이용할 수 있는 것은 무엇인가?
   - 세균의 수
   - 시간

3. 내가 모르는 건 무엇인가?
   - 일단 모두 파악한 듯.

#### 2. 계획

##### 최초 풀이

1. 시간의 크기만큼 반복
   - 매 반복마다 세균의 수 * 2
2. 결과 세균의 수를 정답으로 반환

#### 3. 실행

- 이해/계획: 21:25-21:30
- 풀이: 21:30-21:35

#### 4. 반성

- JavaScript에서 특정 크기의 배열을 생성해
  그를 이용해 함수형 메서드를 사용하는 방식을 Java에서도 취할 수 있다.
  IntStream.range(범위).boxed()를 사용해 stream 컬렉션 인스턴스를 생성할 수 있다.