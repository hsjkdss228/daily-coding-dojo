# Rotate Array

> LeetCode Top Interview 150

- https://leetcode.com/problems/rotate-array/

## 문제 이해

### 설명

- 정수 배열 `numbers`, 0 이상의 정수 `times`가 주어진다.
- `numbers의` 요소를 `times`만큼 회전시킨다.
- ex.
  - `numbers`: [1, 2, 3, 4, 5, 6, 7], `times`: 3인 경우
  - 프로세스를 마친 후의 `numbers`: [5, 6, 7, 1, 2, 3, 4]

### 제한사항

- 1 <= `numbers.length` <= 10^5
- -2^31 <= `numbers[i]` <= 2^31 - 1
- 0 <= `times` <= 10^5

## 풀이

### 유의사항 및 엣지 케이스 확인

- 값은 항상 오른쪽으로 순환한다. index를 넘어가는 값은 배열의 처음으로 와야 한다.
- `numbers.length`보다 큰 값이 `times`로 주어질 수도 있다.

### 풀이 1

#### 아이디어

- Queue를 이용한다.
- rotate의 경우, `numbers.length`만큼 반복하는 경우 `numbers`의 원본과 같다.
  따라서 `times % numbers.length`만큼만 rotate한다.

#### 설계

```text
queue = Queue: rotate를 위한 Queue
for (i = number.length - 1; i >= 0; i -= 1
  queue.add(numbers[i])
times % numbers.length 횟수만큼 반복
  value = queue.poll()
  queue.add(value)
for (i = number.length - 1; i >= 0; i -= 1)
  numbers[i] = queue.poll()
```

#### 결과

- Accepted
- Runtime 6ms (Beats 5.23%)
- Memory 54.89MB (Beats 95.63%)

#### 이슈

- 시간 복잡도: O(2n + k) (k < n)
- 공간 복잡도: O(n)
- 컬렉션을 사용하지 않고 문제를 풀이해본다.

### 다른 풀이

#### 아이디어 및 설계

- https://leetcode.com/problems/rotate-array/solutions/3928454/o-n-2-o-n-logn-both-approach-java/
- `numbers` 전체를 뒤집는다.
- `numbers`에서 index가 `0`에서 `(times % numbers.length) - 1`인 지점까지 뒤집는다.
- `numbers`에서 index가 `times % numbers.length`에서 `numbers.length - 1`인 지점까지 뒤집는다.

#### 결과

- Accepted
- Runtime 0ms (Beats 100%)
- Memory 56.78MB (Beats 6.25%)

#### 이슈

- 시간 복잡도: O(n) = O(n / 2) + O(n / 2)
- 반면 공간 복잡도는 reverse를 위한 temp 변수만을 사용하기 때문에
  낮아질 것으로 생각했지만 오히려 상승. 왜?
