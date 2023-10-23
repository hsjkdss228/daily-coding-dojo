# Majority Element

> LeetCode Top Interview 150

- https://leetcode.com/problems/majority-element/

## 문제 이해

### 설명

- 정수 배열 `numbers`가 주어진다.
- `numbers`에서 배열에 존재하는 요소들 중 가장 많은 개수를 가진 요소를 반환한다.

### 제한사항

- `n` == `numbers`.length
- 1 <= `n` <= 5 * 104
- -109 <= `numbers[i]` <= 109
- 가능하다면, 시간 복잡도 O(n), 공간 복잡도 O(1)의 풀이를 고려한다.

## 풀이

### 유의사항 및 엣지 케이스 확인

- 배열의 길이는 1개 이상

### 풀이 1

#### 아이디어

- 가장 쉽게 생각할 수 있는 방법은 `Map<Element, Count>`를 두는 것.

#### 설계

- 지역 변수 정의
  - `numberAndCounts`: `Map<Integer, Integer>`
    - key: 배열 내 요소
    - value: 배열 내 해당 요소가 존재하는 개수
- 배열을 순회
  - if `elementAndCount` contains `numbers[i]`
    - value += 1
  - if elementAndCount does not contain `numbers[i]`
    - `<numbers[i], 1>` 쌍 추가
- `numberAndCounts`에서 value가 최대인 쌍의 Key 반환
  - `numberAndCounts`의 entry들을 value의 크기별로 정렬

#### 결과

- Accepted
- Runtime 14ms (Beats 22.19%)
- Memory 46.8MB (Beats 83.59%)

#### 이슈

- 배열을 순회하는 데 드는 시간 복잡도는 O(n)
- `Map.entrySet()`을 정렬하는 데 드는 시간 복잡도는 O(nlogn)

### 풀이 2

#### 아이디어

- O(n) 시간에 `Map.entrySet()`에서 value가 가장 큰 entry를 찾을 수 있으면
  시간 복잡도를 O(n)으로 줄일 수 있을 것으로 생각된다.
  - 가장 쉽게 생각할 수 있는 방법은 entrySet을 정렬하지 않고,
    한 번만 순회하면서 value가 가장 큰 entry만을 찾는 것.
  - 비교 과정에서 과반 값 저장을 위한 별도의 저장공간을 사용한다면 공간 복잡도는 약간 늘어날 듯.

#### 설계

- `numberAndCounts`에서 value가 최대인 쌍의 Key 반환
  - `numberAndCounts`를 정렬하지 않고, entry를 순회하면서
    value가 가장 큰 key를 판별해 반환

#### 결과

- Accepted
- Runtime 13ms (Beats 27.26%)
- Memory 46.7MB (Beats 83.59%)

#### 이슈

- 개선이 크게 이루어지지 않았다.
- O(n) 이하로는 시간 복잡도를 줄이는 것이 불가능할 것으로 보이므로,
  HashMap을 사용하지 않으면서 O(n)의 시간 복잡도를 유지하는 방법을 찾는다.

### 다른 풀이

#### Boyer-Moore Majority Vote Algorithm

- <https://leetcode.com/problems/majority-element/solutions/3676530/3-method-s-beats-100-c-java-python-beginner-friendly/>
- 다음의 변수들을 정의한다.
  - `max` = numbers의 첫 번째 수: 현재 과반 이상이라고 판단되는 값
  - `count` = 0: max가 과반 이상의 수인지 식별하기 위한 값
- `numbers`를 순회
  - `if count == 0`
    - `max = numbers[i]`
    - `count += 1`
    - `continue`
  - `if count > 0 && max == numbers[i]`
    - `count += 1`
    - `continue`
  - `if count > 0 && max == numbers[i]`
    - `count -= 1`
- `max`를 반환

#### 결과

- Accepted
- Runtime 2ms (Beats 68.56%)
- Memory 49.16MB (Beats 7.20%)

#### 이슈

- 시간 복잡도가 개선되었다.
- 공간 복잡도가 증가했다.
- 동일 변수에 값을 재할당하기 때문에 정해진 메모리 공간만을 사용하고,
  해당 풀이에서는 오히려 Map<Integer, Integer>을 사용하지 않으므로
  공간 복잡도도 감소할 것으로 예상했는데 오히려 공간 복잡도가 늘어난 것은 이해가 되지 않는다.

## 회고

- Java의 컬렉션이나 직접 정의한 객체를 풀이에 사용했을 때
  공간 복잡도나 시간 복잡도에 어떤 영향을 끼치는지 찾아볼 필요가 있다.
