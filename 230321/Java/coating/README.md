# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 덧칠하기

> 연습문제

- https://school.programmers.co.kr/learn/courses/30/lessons/161989
- 1미터 구역으로 구분되는 벽의 부분 개수 lengthWall, 벽에 페인트를 칠하는 롤러의 길이 lengthRuler,
  다시 페인트를 칠해야 하는 구역 번호가 담긴 정수 배열 sections가 매개변수로 주어질 때,
  롤러로 페인트칠해야 하는 최소 횟수를 return한다.

### 23.3.22

#### 1. 이해

- 롤러로 벽을 칠할 때 롤러 길이의 일부분만을 칠할 수 없음,
  즉 벽의 index를 벗어나게 칠할 수 없고, 칠하는 범위는 벽의 index 시작부터 끝 이내여야 함

#### 2. 계획

- 페인트를 칠한 횟수 = 0
- sections가 빌 때까지 반복
  - sections의 가장 앞 원소를 조회
  - sections에서 조회되는 원소가 (가장 앞 원소 + lengthRuler)보다 작은 값이면
    계속해서 sections에서 맨 앞의 원소를 remove
    - sections가 비었거나, 조회되는 원소가
      (sections + lengthRuler)보다 크거나 같은 값이면 remove를 중단
  - 페인트를 칠한 횟수 += 1
- 페인트를 칠한 횟수를 정답으로 반환

#### 3. 실행

- 문제 계획 시간: 09:25-09:43
- 문제 풀이 시간: 09:43-10:00

#### 4. 반성

- rulerLength가 1인 경우 section이 비었는지 검사하는 조건을 만족하지 못함
  - 만족하지 못했던 이유는 endingPoint 정의를 startingPoint + rulerLength - 1로 했기 때문
  - sections에서 조회되는 원소가 (가장 앞 원소 + lengthRuler)보다 작은 값일 때
    내부 while문을 실행하는 것이면 endingPoint를
    startingPoint + rulerLength로 해야 범위에 맞음
