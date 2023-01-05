# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 서울에서 김서방 찾기
문자열로 이루어진 배열 seoul에서 "Kim"의 위치 x를 찾아 "김서방은 x에 있다" 문자열을 반환한다.

#### 1. 이해
- seoul은 길이 1 이상 1000 이하인 배열
- seoul의 각 요소는 길이 1 이상 20 이하인 문자열
- "Kim"은 반드시 seoul에 포함되어 있음

#### 2. 계획
- Arrays.stream(seoul)
- ~~filter로 찾은 위치의 index를 반환받기~~
- IntStream으로 반복을 돌면서 Kim의 index를 찾기

#### 3. 실행
계획 시간: 11:10-11:12
문제 풀이 시간: 11:12-11:30

#### 4. 반성
- stream의 filter에는 index를 찾을 수 있는 방법이 있는지 모르겠다?
- IntStream.range(시작 index, 종료 index + 1) 또는
  Intstream.rangeClosed(시작 index, 종료 index)를 이용해서
  시작 index부터 종료 index까지 stream 방식으로 반복을 돌릴 수 있다.
- IntStream은 for문에 비해 가독성을 살릴 수 있지만,
  Intstream.range의 반복 속도는 효율성이 그다지 좋아 보이지는 않는다.
  JavaScript의 findIndex로 0.05ms가 소요되던 것이 
  Java의 IntStream.range에서는 10ms 가량 소요되고 있음
