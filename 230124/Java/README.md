# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 더 맵게

> Heap

- https://school.programmers.co.kr/learn/courses/30/lessons/42626
- 음식들의 스코빌 지수를 담은 배열 scoville과
  목표 스코빌 지수 target이 주어질 때,
  모든 음식의 스코빌 지수를 target 이상으로 마들기 위해 섞어야 하는 최소 횟수를 return한다.

### 23.1.24

#### 1. 이해

- scoville의 길이: 2 이상 1,000,000 이하
- target: 0 이상 1,000,000,000 이하
- scoville의 각 요소의 크기는 0 이상 1,000,000 이하
- 존재하는 모든 음식의 스코빌 지수를 target 이상으로 만들기 위해 다음의 과정을 반복
  - 새 음식의 스코빌 지수: 가장 낮은 스코빌 지수 + (두 번째로 낮은 스코빌 지수 * 2)
- 모든 음식의 스코빌 지수를 target 이상으로 만들 수 없는 경우에는 -1 return

#### 2. 계획

- 음식의 개수는 줄어도 상관없음, 음식이 전부 없어지지 않는 이상 음식을 섞은 카운트만 세면 됨
- 어쨌든 배열의 원소들을 낮은 값에서부터 순차적으로 모두 이용하기는 해야 함

- 해결 과정
  - Stack\<스코빌\>, 합친 횟수를 놓음
  - scoville의 원소들을 가장 큰 원소부터 Stack에 push
  - Stack에서 꺼내는 값 >= target일 때까지 다음을 반복
    - 가장 낮은 값: Stack.pop
    - 두 번째로 낮은 값: Stack.pop
    - Stack.push(계산한 새 스코빌 지수)
    - 합친 횟수 += 1
  - 반복이 끝난 시점의 합친 횟수가 정답
  - stack에 원소가 하나만 남았는데 꺼낸 값이 target보다 작을 경우, -1이 정답

#### 3. 실행

- 문제 계획 시간: 10:40-10:55
- 문제 풀이 시간: 10:55-11:08
- 오류 추적 시간 (1차): 11:08-11:30

#### 4. 반성

##### 1차 오류 추적

- 정확성 9/21, 효율성 0/5 (실패)
- 계산한 새 스코빌 지수가 Stack에서 꺼낼 다음 값보다 최소가 아니다.
- 새 스코빌 지수를 넣기 전, 순서에 맞도록 넣는 작업을 조정하는 로직 추가 시도
  - 새 스코빌 지수를 계산한 뒤
  - Stack\<임시로 넣어놓을 기존의 스코빌\>을 놓음
  - Stack\<스코빌\>.peek >= 새 스코빌 지수일 때까지
    - '임시 Stack'.push('기존 스코빌 Stack'.pop)
  - Stack\<스코빌\>.push(새 스코빌 지수)
  - '임시 Stack'에 있는 모든 값들을 순차적으로 Stack\<스코빌\>에 push

##### 2차 오류 추적

- 정확성 15/21, 효율성 0/5 (시간 초과 실패)
- long 문제는 아니다.
- PriorityQueue에 대해 학습한 뒤, 다시 풀어보도록 하자.
  - PriorityQueue는 내가 알던 FIFO 방식의 그 Queue가 아닌 것 같다.
    FIFO 방식의 Queue는 Java에서는 LinkedList를 이용해 구현하는 것이고,
    PriorityQueue는 Java에서 Heap 자료구조를 구현한 구현체인 것이다?

### 23.1.25

#### 1. 이해

- 배열이 정렬되어 있지 않을 수 있다.
- 오름차순 PriorityQueue를 사용하면,
  가장 덜 매운 scoville과 (PriorityQueue\<\>.remove())
  두 번째로 덜 매운 scoville을 빠르게 구함과 동시에 바로 정렬할 수 있다.
  ~~(Math.min(PriorityQueue\<\>[1], PriorityQueue\<\>[2]))~~
  바로 이어서 PriorityQueue\<\>.remove()
- 새로운 값은 그냥 add해도 내부에서 알아서 정렬된다.
  (가장 마지막인 leaf node에 들어간 뒤, heap의 성질로 인해 바로 정렬된다.)

#### 2. 계획

- 기존의 로직에서 Stack을 이용하는 방식을 PriorityQueue를 이용하는 방식으로 리팩터링한다.

#### 3. 실행

- 문제 계획 시간: 15:20-15:50 (Heap, PriorityQueue 학습), 17:00-17:05 (계획)
- 문제 풀이 시간: 17:05-17:15

#### 4. 반성

- PriorityQueue<>()에 속성을 주지 않을 경우 오름차순으로 우선순위 형성
  (작은 숫자일수록 Tree의 depth에 맞춰 낮은 index에 위치)
- Collections.reverseOrder()를 속성으로 줄 경우 내림차순으로 우선순위 형성 (큰 숫자일수록 낮은 index)
- Tree의 root의 바로 자식들끼리는 우선순위를 따지지 않아도 되는지 고민이었는데, 굳이 따지지 않아도 풀렸다.
- 블로그에 Heap과 PriorityQueue에 대해 정리할 것...
- Heap: https://gmlwjd9405.github.io/2018/05/10/data-structure-heap.html
- PriorityQueue: https://crazykim2.tistory.com/575
