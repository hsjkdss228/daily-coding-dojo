# Remove Duplicates from Sorted Array 2

> LeetCode Top Interview 150

- https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

## 문제 이해

### 설명

- 비내림차순으로 정렬되어 있는 정수 배열 `numbers`가 주어질 때,
  `numbers`의 각 고유값이 최대 두 번만 나타나도록 제거한다.
  남은 숫자들은 `numbers`의 앞부분에 비내림차순을 유지하며 존재해야 한다.
- 3개 이상의 중복이 모두 제거되고 난 뒤, `numbers`의 앞부분에 존재하는
  2개까지의 중복이 허용된 모든 숫자들의 개수를 반환한다.

### 제한사항

- 1 <= `numbers.length` <= 3 * 10^4 
- -10^4 <= `numbers[i]` <= 10^4

## 풀이

### 유의사항 및 엣지 케이스 확인

- 추가적인 배열이나 변수를 할당하지 않고 구현을 진행한다. (가급적 O(1)의 공간 복잡도를 고려한다.)
- 중복이 2개조차도 존재하지 않는, 즉 '정말로' 고유한 숫자도 존재할 수 있다.

### 풀이 1

#### 아이디어

- 다음의 pointer가 필요할 것으로 생각된다.
  - `indexReassigned`: 2개 이하의 고유값을 재할당할 위치 index
- 다음의 변수들이 필요할 것으로 생각된다.
  - `value`: 조회하고 있는 고유값
  - `valueCount`: 고유값이 2개 이하인지 카운트하기 위한 변수

#### 설계

- `numbers.length == 1`이면 1을 반환
- `indexReassigned`: 1
- `value`: `numbers[0]`
- `valueCount`: 1
- `for (i = 1 -> numbers[1]부터 순회)`
  - `numbers[i] == value && valueCount >= 2`: 값이 3개 이상 중복인 경우
    - `continue`
  - `numbers[i] == value && valueCount < 2`: 값이 2개까지 중복인 경우
    - `numbers[indexReassigned] = value`
    - `indexReassigned += 1`
    - `valueCount += 1`
    - `continue`
  - `numbers[i] != value`: 새로운 값이 조회되었을 경우
    - `value = numbers[i]`
    - `numbers[indexReassigned] = value`
    - `indexReassigned += 1`
    - `valueCount = 1`
- `indexReassigned` 반환

#### 결과

- Accepted
- Runtime 0ms (Beats 100%)
- Memory 44.08MB (Beats 11.12%)

### 풀이 2

#### 아이디어

- `indexReassigned` 변수만을 활용해 구현을 시도한다. 

#### 설계

- `value`, `valueCount`를 이용해 2개까지의 중복인지, 3개 이상 중복인지 확인하는 로직을
  다음과 같이 변경한다.
  - `value` -> `numbers[indexReassigned - 1]`
  - `valueCount`: `numbers[indexReassigned - 1]`, `numbers[indexReassigned - 2]`를 비교
  - 단, 이를 위해서는 `numbers.length >= 3`이어야 하므로,
  - `numbers.length == 1 || 2`인 경우는 엣지 케이스로 직접 처리한다.

#### 결과

- Accepted
- Runtime 0ms (Beats 100%)
- Memory 43.3MB (Beats 98.2%)

### 다른 풀이

- https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/solutions/3921824/simple-easy-100-beats-java-solution/
- `numbers[i] != numbers[indexReassigned - 2]`의 비교만으로도 2개까지의 중복만 허용할 수 있다. 

## 회고

- 풀이과정을 설계할 때, 모호한 설계보다 case를 정확하게 나누어 구체적으로 분류하니
  설계를 따라 바로바로 코드를 작성할 수 있었다.
