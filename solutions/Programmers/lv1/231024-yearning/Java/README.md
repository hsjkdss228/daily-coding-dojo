# [추억 점수]

[추억 점수]: https://school.programmers.co.kr/learn/courses/30/lessons/176963

> 연습문제

## 문제 이해

### 설명

- 다음이 주어짐
  - names: array[String], 그리운 인물들 이름 배열
  - yearnings: array[int], 각 그리운 인물들 인덱스에 해당하는 그리움 점수
  - photos: array[][String], 각 사진 별 인물 목록을 포함한 2차원 배열
- photos의 인물 목록에서 names에 존재하는 인물들에 대해서는 해당 인물의 yearnings 점수를, 존재하지 않는 인물들에 대해서는 0을 합산해 주어진 모든 사진들에 대해 점수의 합을 구함
- 구해진 각 사진 별 점수의 합 배열을 반환 

### 제한사항

- 3 <= names.length == yearnings.length <= 100
  - names[i]는 알파벳 소문자 문자열
  - 3 <= names[i].length <= 7
  - names[i] 내 원소 간 중복은 존재하지 않음
  - 1 <= yearnings[i] <= 100
- 3 <= photos.length <= 100
  - 1 <= photos[i].length <= 100
  - photos[i][j]는 알파벳 소문자 문자열
  - 3 <= photos[i][j].length <= 7
  - photos[i][j] 내 원소 간 중복은 존재하지 않음

## 풀이

### 풀이 1

#### 아이디어

- 각 names 별 yearnings을 짝짓는다.
- 각 photos를 순회하면서 추억 점수 배열을 생성한다. 각 photos 내 인물 목록을 순회할 때는 names-yearnings 쌍을 참조해 점수의 합을 매긴다.

#### 설계

```text
given names, yearnings, photos

Map<name: String, yearning: int> nameToYearnings = pair(names, yearnings)
    for each names[i], yearnings[i]
        nameToYearnings.put(name[i], yearning[i])

return calculateYearningScore(nameToYearnings, photos)
    return map photos: array[][String] to array[int]
        map photos[i]: array[String] to int
            reduce sum of nameToYearnings.get(photos[i][j]: String) or if nameToYearnings.not.contains(photos[i][j]) 0
```

#### 결과

- 통과
- 수행 시간: 8-30ms 내외에서 형성
- 메모리 사용량: 75-92MB 내외에서 형성

## 회고

### Collectors.toMap()

- Stream<T>에 대해 Map\<T1, T2\>으로 변환하기 위한 Collector를 반환.
  - Collector 인스턴스는 Stream\<T\> 인스턴스의 collect() 메서드에 인자로 전달되어 대상 컬렉션으로 변환됨.
- 본 문제에서는 0부터 길이가 같게 주어진 두 배열의 길이 크기 범위만큼의 IntStream을 생성한 뒤, 해당 Stream의 각 요소를 배열에서 참조할 인덱스로 활용.
  - Map\<T1, T2\>를 구성하는 Key, Value 쌍은 두 배열의 인덱스에 해당하는 요소들의 쌍. 

### Map.getOrDefault()

- Map\<K, V\>에서 첫 번째 인자로 전달되는 Key 값이 존재하면 해당 Key에 해당하는 Value를 반환하고, 존재하지 않는 경우 두 번째 인자로 전달되는 기본값을 반환.
- 본 문제에서는 nameToYearnings에 name이 존재하는 경우 name에 해당하는 yearning 값을, 존재하지 않는 경우 기본값으로 0을 반환하도록 구성.
