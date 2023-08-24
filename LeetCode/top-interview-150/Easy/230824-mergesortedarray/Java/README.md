## Merge Sorted Array

> Leetcode Top Interview 150

- https://leetcode.com/problems/merge-sorted-array/

### 문제 이해

#### 설명

- 두 개의 *비내림차순*으로 정렬된 배열 `numbers1`, `numbers2`와,
  두 배열의 크기를 나타내는 정수 `length1`, `length2`가 인자로 주어진다.
- 두 배열을 병합하고 비내림차순으로 정렬한다.
- 결과 배열은 첫 번째 배열 내부에 저장된다.
  - 즉, `number1`의 길이는 `length1 + length2`이며,
    `length1 - 1` 인덱스까지는 값이 저장되어 있고 그 뒤에는 `0`이 저장되어 있다.

#### 제한사항

- `numbers1.length == length1 + length2`
- `numbers2.length == length2`
- `length1 >= 0, length2 <= 200`
- `1 <= length1 + length2 <= 200`
- `-10^9 <= numbers1[i], numbers[2] <= 10^9`

#### 참고사항

- O(m + n) 시간 복잡도 이내에 동작하는 알고리즘을 고려한다.

### 풀이

#### 유의사항 및 엣지 케이스 확인

- 정답은 `numbers1`에 생성되어야 한다.

#### 풀이 1

- `numbers1`의 나머지 공간에 `numbers2`를 삽입한다.
- `Arrays.sort(numbers1)`
  - `Arrays.sort()`는 기본적으로 비내림차순으로 정렬.
  - Dual-Pivot Quicksort 방식으로 정렬하여
    O(n * logn)의 시간복잡도를 소요.

##### 결과

- Accepted
- Runtime 1ms (Beats 38.53%)
- Memory 41.2MB (Beats 79.48%)

##### 회고

- 정렬을 직접 구현했다기보다는 이미 존재하는 정렬 메서드를 활용했다.
- 다음 풀이에서는 직접적으로 정렬을 시도해본다.

#### 풀이 2

- `length1` 길이만큼의 새로운 배열을 정의: `numbers1Copied`
- `numbers1Copied`에 `numbers1`을 복제 (`length1` 길이까지만큼)
- `numbers1Copied`, `numbers2`를 탐색하고 있는 index들을 정의: `index1 = 0`, `index2 = 0`
- `for (0부터 numbers1.length - 1까지의 각 index에 대해)`
  - 만약 한 쪽의 index가 `length1`, `length2와` 같아졌으면
    반대쪽의 `numbers`를 계속 삽입 후 continue
  - `numbers1[index] = numbers1Copied[index1], numbers2[index2] 중 작은 쪽`
  - *선택한 쪽의 index* += 1

##### 이슈

- 처음에는 정답 배열 `merged`를 정의한 뒤 `merged`에 정답을 생성해 numbers1을 `merged`로 재할당하는 방식을 고려했으나,
  `merge()` 메서드 내에서 전달된 파라미터를 재할당하는 것을 함수 외부에서 인지하지 못함.
- 따라서 메서드 내부에서는 `numbers1Copied`를 생성해 `numbers1`을 복제하고,
  비교 연산에는 `numbers1Copied`와 `numbers2`를 활용해 `numbers1`에 정답을 생성.

##### 결과

- Accepted
- Runtime 0ms (Beats 100%)
- Memory 41.08MB (Beats 89.09%)

##### 회고

- 시간 복잡도는 주어지는 두 배열을 한 번씩만 순회하는 것이므로 O(m + n)으로 감소.
- 공간 복잡도는 `length1` 크기만큼의 추가적인 공간을 사용

### 다른 풀이

- https://leetcode.com/problems/merge-sorted-array/solutions/3436053/beats-100-best-c-java-python-and-javascript-solution-two-pointer-stl/
- Approach: Two Pointer
  - 풀이 2와 같이 두 개의 index를 사용하는 방식은 동일했으나,
    **numbers1의 값이 존재하는 범위와 numbers2에 대해 마지막 index부터 비오름차순으로 삽입한다는 데 차이가 존재했음.**
  - 이 방식을 택할 경우 추가적인 공간을 정의하지 않고도 동일한 O(m + n)의 시간 복잡도를 유지할 수 있음.

### 포인트 정리

#### 비내림차순

- 한 마디로 **내림차순이 아닌 것**.
- 시퀀스 내에서 서로 붙어있는 정수 `previous`, `next`가 있을 때,
  `next`는 `previous`보다 크거나 **같다**.
- ex. `[1, 2, 2, 3, 5, 6, 6, 7, 8]`
- 오름차순과 다른 점?
  - 오름차순은 `next`는 `previous`보다 항상 반드시 커야 한다.
    즉 두 수가 **같을 수는 없다**는 의미이다.
  - ex. `[1, 2, 4, 7, 9, 10, 11, 13]`
  - 비내림차순 시퀀스에는 동일한 값이 존재할 수 있으나,
    오름차순 시퀀스에는 동일한 값이 존재할 수 없다,

#### System.arrayCopy()

- `System.arrayCopy()` 명세를 참조
- 인자로 전달되는 destination 배열에 source 배열을 복제.
- 파라미터
  - src: 원본 배열
  - srcPos: 원본 배열에서 복제를 시작할 index
  - dest: 원본을 복제시킬 목표 배열
  - srcPos: 목표 배열에서 값 삽입을 시작할 index
