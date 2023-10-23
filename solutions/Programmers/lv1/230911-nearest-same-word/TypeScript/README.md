# 가장 가까운 같은 글자

> Programmers 연습문제

- <https://school.programmers.co.kr/learn/courses/30/lessons/142086>

## 문제 이해

### 설명

- 문자열 `string`이 주어졌을 때, `string`의 각 index에 대해
  자신보다 앞에 나왔으면서 자신과 가장 가까운 곳에 있는
  같은 글자의 index 값 배열을 반환한다.

### 제한사항

- 1 <= `string.length` <= 10,000
- `string`은 영어 소문자로만 구성.

## 풀이

### 유의사항 및 엣지 케이스 확인

- 자신보다 앞 위치에 자신과 같은 글자가 없는 경우에는 -1이 주어져야 한다.

### 풀이 1

#### 아이디어

- 조회한 글자의 종류와, 가장 가까운 index를 파악해야 한다.
  - `Map<조회한 글자 종류, 가장 최근에 조회한 index>`을 이용할 수 있다.
- `조회한 글자의 index와 가장 가까운 index 간의 차`를 계산하거나, 없으면 `-1`을 부여해야 한다.
- 배열과 똑같은 크기의 정답 배열로 변환해야 한다.

#### 설계

```text
const charAndLastIndexes = new Map();

const differences = map string to
  // charAndLastIndexes에 조회한 글자의 종류의
  // 가장 가까운 index가 있는지 파악해서
  // 있으면 index 간의 차를 계산, 없으면 -1을 부여
  let difference;
  if (charAndLastIndexes contains key(string[index]))
    difference = index - charAndLastIndexes.get(string[index]);
  else
    difference = -1;

  // charAndLastIndexes에 조회한 글자의 종류 및 index 반영
  if (charAndLastIndexes contains key(string[index]))
    charAndLastIndexes.replace(string[index], index);
  else
    charAndlastIndexes.add(string[index], index);

  return difference;

return differences;
```

#### 결과

- 통과
- 수행 시간 최대: 2.71ms
- 메모리 사용량 최대: 37MB

#### 회고

- 시간 복잡도
  - `[...string]` 생성 및 순회 프로세스: O(n)
- 공간 복잡도
  - `charAndLastIndexes`, `differences` 생성에
    `string`의 배열 크기와 동일한 요소 개수의 공간 추가 사용
