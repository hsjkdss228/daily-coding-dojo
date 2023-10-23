# Remove Element

> LeetCode Top Interview 150

- https://leetcode.com/problems/remove-element/

## 문제 이해

### 설명

- 정수 배열 numbers, 특정한 정수 value가 주어진다.
- numbers에 대해 다음을 수행한다.
  - numbers에서 value와 같지 않은 수들을 모두 numbers의 앞쪽에 배치한다.
  - value에 해당하지 않는 수들의 개수를 반환한다.

### 제한사항

- 0 <= numbers.length <= 100
- 0 <= numbers[index] <= 50
- 0 <= value <= 100

### 참고사항

- https://en.wikipedia.org/wiki/In-place_algorithm
  - In-place algorithm

## 풀이

### 유의사항 및 엣지 케이스 확인

- 프로세스 수행 후, value에 해당하지 않는 수들이 numbers에서 배치된 순서는 중요하지 않다.
- ex) numbers: [0, 1, 2, 2, 3, 0, 4, 2], value: 2일 때, 정답으로 인정되는 경우
  - 반환값: 5 ([2에 해당하지 않는 수들].length)
  - 프로세스 수행 후 numbers: [...[value에 해당하지 않는 수들], ...[그 외의 수들]]
  - [value에 해당하지 않는 수들]에 대해서만 정렬 후 일치 여부를 평가하기 때문에,
    해당 배열에 값이 포함되기만 하면 된다.
  - [그 외의 수들]에 대해서는 평가하지 않으므로, 어떤 값이 들어있어도 상관없다.

### 풀이

#### 아이디어

- numbers를 순서대로 순회하면서, value와 같은 경우에는 배열 뒤쪽의 값과 배치를 바꾼다.

#### 설계

- 다음의 변수를 정의.
  - index: numbers를 순회하기 위한 변수
  - indexMoved: numbers에서 value와 같지 않은 값이 위치한 가장 마지막 index
  - temp: numbers[index]와 numbers[indexMoved]를 Swap하기 위한 변수
- 빈 배열이 주어진 경우에는 0을 반환
- while (index < indexMoved)
  - if (numbers[index] == value)
    - numbers[indexMoved]와 numbers[index] Swap
    - indexMoved -= 1
  - index += 1
- ~~indexMoved + 1 반환~~
  - ~~반복이 끝난 지점에서의 indexMoved가 value와 같지 않은 수들이 위치한 마지막 index.~~
    ~~따라서 [value에 해당되지 않는 수들].length는 indexMoved + 1~~
- ~~index + 1 반환~~
  - numbers[index] == value면 index을 반환
    (numbers[index - 1]까지가 [value에 해당되지 않는 수들]인 것이므로)
  - 그렇지 않으면 index + 1을 반환
    (numbers[index]까지가 [value에 해당되지 않는 수들]인 것이므로)

#### 이슈

1. 처음에는 numbers의 맨 뒤쪽 index가 value와 같은 경우를 고려하지 않았으나,
   검증을 진행하는 과정에서 관련된 이슈를 확인해 indexMoved를
   value가 아닌 index까지 옮기는 동작을 먼저 수행하도록 수정.
2. numbers[index]가 indexMoved보다 커졌을 때 순회를 중단하지 않으면
   value와 같은 수들이 배열의 가장 앞부터 위치하게 됨.
3. indexMoved + 1을 [value에 해당되지 않는 수들]의 개수로 사용할 경우,
   solution3()와 같이 [value에 해당되는 수들]이 더 많은 경우를 정확하게 측정할 수 없음.
   - 따라서 index를 [value에 해당되지 않는 수들].length로 사용
4. numbers를 순회하는 과정에서 numbers[indexMoved - 1]의 값이 value와 같은 경우,
   value와 같지 않을 때까지 계속해서 indexMoved -= 1을 수행해야 함.

#### 결과

- Accepted
- Runtime 0ms (Beats 100%)
- Memory 40.58MB (Beats 89.0%)

### 다른 풀이

- https://bcp0109.tistory.com/172
- value에 해당되지 않는 수를 삽입하기 위한 index를 별도로 정의.
- 배열을 순회하면서 조회하는 수가 value에 해당되지 않는 수이면, numbers[index]에 해당 수를 재할당하고 index += 1
- 배열 순회를 마쳤을 때의 index는 numbers에서 [value에 해당되지 않는 수들] 중 마지막 index + 1이기 때문에
  해당 값을 그대로 반환.

### 회고

- 원래 풀이의 문제는 value에 해당하는 수와 해당하지 않는 수를 정확하게 유지시키려고 했다는 문제가 있음.
  value를 배열의 나머지 부분에 유지시키기 위해 불필요한 작업이 추가되었고,
  value가 아닌 값들과 value인 값들의 경계를 정확하게 구분하기 위해
  여러 엣지 케이스를 고려하는 과정에서 문제풀이에 추가적인 시간이 소요되었음.
- 유의사항을 정확히 분석한다면 문제풀이에 사용하는 시간을 최소화할 수 있다!
