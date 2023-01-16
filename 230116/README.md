# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 베스트앨범 

> 해시

- https://school.programmers.co.kr/learn/courses/30/lessons/42579
- 노래의 장르를 나타내는 문자열 배열 genres와
  노래 별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때,
  베스트 앨범에 들어갈 노래의 index를 순서대로 return한다.

### 23.1.16

#### 1. 이해

- genres[index]: index에 해당하는 노래의 장르
- plays[index]: index에 해당하는 노래가 재생된 횟수
- genres와 plays 배열의 길이는 같고, 1 이상 10000 이하
- genres의 종류는 99개 이하
- 장르에 속한 곡이 하나라면 해당되는 그 하나의 곡만 선택
- 모든 장르끼리는 총 재생된 횟수가 다름

- 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 앨범을 출시하려 함
- 노래를 수록하는 기준
  1. 속한 노래가 많이 재생된 장르를 먼저 수록
  2. 장르 내에서 많이 재생된 노래를 먼저 수록
  3. 장르 내에서 재생 횟수가 같은 노래가 있을 경우, 고유 번호가 낮은 노래를 먼저 수록 

#### 2. 계획

1. 주어진 genres, plays를 Map으로 관리한다.
  - Map<Index(Integer), Genre(String)>
  - Map<Index(Integer), play(Integer or Long)>
    - play는 Long이어야 할까?

2. 재생 횟수에 따라 장르의 순번을 정해야 한다.
  - 재생 횟수의 합을 구해 비교한다.
  - Map<Genre(String), playSum(Integer or Long)>
  - genres Map, plays Map을 순회하면서 합을 구해 playSums에 업데이트한다.
  - playSum의 key값들(장르 이름)을 오름차순으로 배열로 꺼내온다.

3. 정답 List를 놓는다.

4. 장르의 순번 배열을 순회하면서 장르를 하나씩 꺼내온다.
  - value가 장르에 해당하는 모든 key들을 꺼내온다.
  - 꺼내온 모든 key들에 해당하는 play들을 꺼내온다.
  - play의 크기가 가장 큰 index 두개를 정답 List에 push
    - 이때 두 play의 크기가 같으면 index가 작은 쪽을 먼저 push

5. List.toArray()

#### 3. 실행

- 문제 계획 시간: 16:00-16:30
- 문제 풀이 시간: 16:30-17:25 (미해결)

#### 4. 반성

- 굳이 indexAndGenres, indexAndPlays를 둬야 할까 의문이 있다.
- playSum의 장르 이름을 value의 크기에 맞춰서
  오름차순으로 정렬하는 로직을 상세하게 설계하지 않았다.
- Map의 Entry<Key, Value>를 사용하는 데 시간이 걸렸다. 2번까지는 완료
- 내일 이어서 풀어보도록 하자.
