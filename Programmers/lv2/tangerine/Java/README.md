# 귤 고르기

> Programmers 연습문제

- <https://school.programmers.co.kr/learn/courses/30/lessons/138476>

## 문제 이해

### 설명

- 상자 하나에 담으려는 귤의 개수 `sum`,
  귤의 크기가 포함된 배열 `tangerines`가 매개변수로 주어질 때,
  크기가 서로 다른 종류의 수의 최소값을 반환한다.

### 제한사항

- 1 <= `sum` <= `tangerines.length` <= 100,000
- 1 <= `tangerines[i]` <= 10,000,000

## 풀이

### 풀이 1

#### 아이디어

- 각 귤의 크기 별 개수를 파악한다.
  - `Map`을 활용할 수 있다.
- Entry를 Value 내림차순으로 정렬한다.
- 내림차순으로 정렬된 Entry를 순서대로 합한다. 이때 `합 >= sum`이 될 경우, 합한 횟수를 `return`.

#### 설계

```text
Map<Integer, Integer> sizeAndCounts

for (int size : tangerines)
  if (sizeAndCounts not contains(size))
    sizeAndCounts.put(size, 1)
    continue
  if (sizeAndCounts contains(size))
    sizeAndCounts.replace(size, counts of size + 1)

sizeAndCounts.sort(value desc)

int countSum = 0
int sizeCount = 0
for (int count : values of sizeAndCounts)
  countSum += count
  sizeCount += 1
  if (countSum >= sum)
    return sizeCount

return sizeCount
```

#### 결과

- 통과
- 수행 시간 최대: 90.29ms
- 메모리 사용량 최대: 109MB

#### 회고

- 시간 복잡도
  - `sizeAndCounts` 생성: O(n)
  - `sizeAndCounts.values()` 정렬: O(nlogn)
  - `values()` 합산을 통한 정답 도출: O(n)
- 공간 복잡도
  - `sizeAndCounts`, `sizeAndCounts.values()`를 위한 추가 공간 사용
