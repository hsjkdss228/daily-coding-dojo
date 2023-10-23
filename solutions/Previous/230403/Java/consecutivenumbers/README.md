# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 연속된 수의 합

> 코딩테스트 입문

- https://school.programmers.co.kr/learn/courses/30/lessons/120923
- 연속된 수 count개를 더한 값이 total이 될 때,
- 연속된 정수들의 배열을 오름차순으로 담아 return한다.

### 23.4.3

#### 1. 이해

1. 주어진 조건은 무엇인가?
   1. 규칙
      - 연속된 수들은 count개만큼 존재
   2. 제한사항
      - count의 크기: 1 이상 100 이하
      - total의 크기: 0 이상 1000 이하
   3. 추론
      - total의 크기가 0일 수도 있다는 것은, 연속된 수에 음수가 있을 수도 있다는 것.

2. 내가 이용할 수 있는 것은 무엇인가?
   - '연속된 수'라는 것.

3. 내가 모르는 건 무엇인가?
   - 일단 다 파악한 듯.

#### 2. 계획

##### 최초 풀이

1. 정답 List answer 정의: List<Integer>, LinkedList
2. 1부터 count까지 answer의 끝에 삽입
3. answer의 맨 앞 수 (가장 작은 수), 맨 뒤 수 (가장 큰 수) 정의
4. answer의 합이 total이 될 때까지 반복
   - answer의 합이 total보다 작으면
     answer 맨 앞의 원소를 제거하고, answer 맨 뒤에 가장 큰 수 + 1 삽입 후
     가장 작은 수, 가장 큰 수 갱신
   - answer의 합이 total보다 크면
     answer 맨 뒤의 원소를 제거하고, answer 맨 앞에 가장 작은 수 - 1 삽입 후
     가장 작은 수, 가장 큰 수 갱신
5. answer를 toArray()한 뒤, 정답으로 반환

#### 3. 실행

- 이해/계획: 24:40-24:55
- 풀이: 24:55-25:25

#### 4. 반성

- IntStream.range(시작 index, 마지막 index)는
  반복을 시작 index부터 '마지막 index - 1'까지 수행하는 것에 유의!!
