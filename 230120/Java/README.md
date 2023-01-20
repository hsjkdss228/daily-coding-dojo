# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 기능개발

> 스택/큐

- https://school.programmers.co.kr/learn/courses/30/lessons/42586
- 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와
  각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때,
  각 배포마다 몇 개의 기능이 배포되는지 return한다.

### 23.1.20

#### 1. 이해

- progresses, speeds의 길이는 100 이하
- progresses의 각 원소는 99 이하의 자연수
- speeds의 각 원소는 100 이하의 자연수
- 각 기능은 진도가 100일 때 배포 가능
- 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있음
  - 뒤에 있는 기능이 먼저 개발되면 앞에 있는 기능과 함께 배포됨
- 배포는 하루에 한 번만 가능하고, 하루의 개발 속도만큼 개발을 모두 진행한 뒤 배포
  - ex. progress가 95이고, speed가 4인 작업은 2일 뒤에 배포됨 (99 -> 100)

#### 2. 계획

- 규칙성 찾기
   - 입출력 예 1번의 경우 
     - 93 30 55
     - 97 100 / 70
     - 100 100 / 85
     - 100 100 / 100
   - 입출력 예 2번의 경우
     - 95 90 99 99 80 99
     - 100 / 95 100 100 / 85 100
     - 100 / 100 100 100 / 90 100
     - 100 / 100 100 100 / 100 100

- Queue\<Progress\>, Queue\<Speed\>를 놓고, progresses, speeds를 각 순서대로 push.
- 정답 List\<Integer\>를 놓는다.
- Queue\<Progress\>가 빌 때까지 다음을 반복한다.
  - Queue\<Progress\>의 각 index에 Queue\<Speed\>의 각 index 값을 더한다.
  - remove 횟수 = 0
  - while (Queue\<Progress\>.peek()한 값이 100보다 작을 때까지)
    - Queue\<Progress\>, Queue\<Speed\>에서 하나씩 remove하고, remove한 횟수 += 1
  - remove 횟수가 1 이상이면 정답 List에 remove 횟수를 add.
- 정답 List를 반환

#### 3. 실행

- 문제 계획 시간: 10:05-10:35
- 문제 풀이 시간: 10:50-11:25

#### 4. 반성

- Queue에는 index에 맞게 접근할 수 있는 메서드가 없었다. 따라서 List를 이용하는 것으로 풀이 변경
- 그렇다면 위의 설계 방식은 Queue나 Stack을 쓰기에 적절한 방식은 아닌 것일까?
- Queue/Stack 문제라고 해서 꼭 Queue나 Stack을 써야 하나 싶기도 하고...
