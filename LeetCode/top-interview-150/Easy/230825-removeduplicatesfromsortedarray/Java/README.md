# Remove Duplicates from Sorted Array

> LeetCode Top Interview 150

- https://leetcode.com/problems/remove-duplicates-from-sorted-array/

## 문제 이해

### 설명

- 정수 배열 `numbers`가 비내림차순으로 정렬되어 있다.
- 해당 배열 내 각 요소들이 고유하도록 중복된 요소들을 제거한다. 이때 요소들의 상대적 순서는 동일하게 유지한다.
- 모든 중복이 제거된 고유 요소들의 수를 반환한다.

### 제한사항

- 1 <= `numbers.length` <= 3 * 104
- -100 <= `numbers[i]` <= 100

## 풀이

### 유의사항 및 엣지 케이스 확인

- 본 문제 역시 Remove Element 문제와 마찬가지로,
  프로세스를 수행한 뒤의 `numbers`는 `[...[중복이 제거된 값들], ...[이외의 값들]]`의 형태로 구성된다.
  `[이외의 값들]`의 값 구성은 신경쓰지 않아도 된다.

### 풀이 1

#### 아이디어

- Remove Element 문제의 다른 풀이 방식에서 적용했던 방식을 적용한다.
- 배열을 순회하면서 새로운 고유한 값이 탐색되면 해당 값을 배열의 앞에서부터 채워나간다.
- 배열 순회를 마쳤을 때 고유값을 배열에 재할당하기 위한 `index`가
  `[중복이 제거된 값들]`의 원소 개수와 같을 것이므로, `index`를 반환한다.

#### 설계

- 지역 변수 정의
  - `indexToReassign = 1`: 고유값을 배열에 재할당하기 위한 index
    - `numbers[0]`은 최초의 값이므로 고유값.
  - `value = numbers[1]`: `numbers` 순회 과정에서 조회하는 고유값
- for (numbers의 두 번째 요소부터 순회)
  - 고유값이면 indexToReassign 위치에 재할당, indexToReassign += 1
  - 고유값이 아니면 건너뜀
- indexToReassign 반환

#### 이슈

1. `indexToReassign`의 초기값은 0이 아니라 1이어야 함.
   `numbers[0]`은 최초의 고유값이므로, 새로운 고유값은 `numbers[0]` 다음 값에 재할당해야 함.

#### 결과

- Accepted
- Runtime 0ms (Beats 100%)
- Memory 44.14MB (Beats 18.63%)

### 풀이 2

- `value`에 값을 저장하지 않고 `number[indexToReassign - 1]`과 직접 비교한다.

#### 결과

- Accepted
- Runtime 1ms (Beats 98.01%)
- Memory 43.63MB (Beats 86.14%)

## 회고

- 별개의 index를 활용해 배열을 한 방향에서 순회함과 동시에
  필요한 다른 지점들을 확인할 수 있는 기법이 알고리즘 풀이에 유용하게 쓰일 수 있을 것 같다.
