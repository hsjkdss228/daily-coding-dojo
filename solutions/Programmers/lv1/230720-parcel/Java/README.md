# 💡 How to solve it?

> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 택배 배달과 수거하기

> 2023 KAKAO BLIND RECRUITMENT

- https://school.programmers.co.kr/learn/courses/30/lessons/150369

### 23.7.20

#### 1. 이해

1. 주어진 조건은 무엇인가?
   1. 구하고자 하는 것: 트럭 하나로 모든 배달과 수거를 마치고 물류창고까지 돌아올 수 있는 최소 이동 거리
   2. 출발지에서 충분한 개수의 택배 상자를 실어 여러 집에 내려주거나, 여러 집의 빈 택배 상자를 수거해야 함
   3. 일렬로 나열된 n개의 집에 택배 배달 (1 <= n <= 100,000)
   4. 모든 집들 간의 거리: 1
   5. 트럭의 초기 위치는 물류창고

2. 내가 이용할 수 있는 것은 무엇인가?
   1. 트럭에 실을 수 있는 택배 상자의 개수: capacity (1 <= capacity <= 50)
   2. 각 집마다 배달할 택배 상자의 개수: delivers
   3. 수거할 빈 택배 상자의 개수: pickups
      - delivers의 길이 = pickups의 길이 = n
      - delivers[i], pickups[i]: i + 1번째 집에 배달/수거할 택배 상자의 개수 (0 <= 각 원소 <= 50)

3. 내가 모르는 건 무엇인가?
   - 몇 번 왕복해야 최소한으로 택배를 배달하고 빈 박스를 수거해올 수 있는지

#### 2. 계획

- 가장 먼 집에서부터 최대한 배달 및 수거를 진행하도록 한다.
- 배달할/수거할 가장 먼 집의 index를 기억
- 다음을 반복
  - 총 이동거리 += (배달할/수거할 index 중 큰 쪽의 index) + 1
    - 실제 거리는 index + 1이므로 + 1을 한 것
  - for (i = index; index가 0이 될 때까지 -= 1)
    - 배달/수거를 위한 남은 capacity 정의
    - 배달/수거를 위한 남은 capacity가 둘 다 0이면 다음 index 체크
    - 배달/수거를 위한 남은 capacity 중 하나라도 0보다 크면 다음을 반복
      - 시작 index까지 모두 봤으면 break
      - 2중 반복문에서 deliveries, pickups를 조회할 index 정의: j
      - deliveries/pickups[j] > 0이면
        - 남은 capacity -= deliveries/pickups[j]
        - deliveries/pickups[j] -= 남은 capacity
      - deliveries/pickups[j] <= 0이면 패스
- 총 이동거리를 반환

#### 3. 실행

- 이해/계획: 10:40-11:15 (35분)
- 풀이: 13:00-13:20 (20분), 13:40-16:10 (150분)

#### 4. 반성

- delivery와 pickup을 동시에 했을 때 17번 문제에서 시간 초과 발생.
- 둘의 프로세스가 같다는 점을 고려해 동일한 메서드를 호출해 별도로 실행하게 했더니 
  시간 초과되지 않고 통과.
- delivery와 pickup 간에 차이가 큰 테스트 케이스에서 불필요한 조회를 많이 하게 되어
  실행 시간에 실질적으로 영향을 끼쳤을 것으로 생각된다.
- n^2의 시간 복잡도를 근본적으로 줄이지는 못했지만, n에 곱해지는 상수의 크기를 줄이는 것도
  어느정도는 유의미한 결과가 있다고 볼 수 있는 것인가?
