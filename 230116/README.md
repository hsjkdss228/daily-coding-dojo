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

### 23.1.17

#### 3. 실행

- 문제 풀이 시간: 8:45-10:15 (미해결)

#### 4. 반성

- List<Map.Entry<Integer, Integer>>를 내림차순으로 정렬하는 게 무시되고 있는 것 같다.
- 그냥 숫자를 Sort하는 게 아니라 Entry를 value에 따라서 sort하는 로직이니까
  sort하는 방법을 찾아내던가, 아니면 value를 확인해보면서 key를 선택하는데,
  이전 value보다 큰 value면 key를 대체하는 방식으로 index 두 개를 뽑는 것도 좋을 것 같다.
- 근데 같은 문제에 3시간이나 쓰고 있다는 게 불편하다.

### 23.1.18

#### 2. 계획

- value를 꺼냈을 때, 이전 value보다 큰 value면
  key를 대체하는 방식으로 index 두 개를 뽑는 방식으로 index 선정을 대체해보자.
- 구체적으로
  - List를 놓음.
    List(0) = Play가 가장 큰 <Index, Play>, List(1) = Play가 두 번째로 큰 <Index, Play>
  - <Index, Play>를 하나를 뽑는데
    - List가 비어있거나 하나만 있으면 일단 Push
    - List에 2개 이상 있으면 List 안에 있는 것들을 하나씩 확인하는데
      - Play가 List에 있는 둘 중에 하나보다 크면, 뽑아온 <Index, Play>로 기존의 작은 것을 대체

#### 3. 실행

- 문제 풀이 시간: 9:45-10:40 (실패)
- 오류 추적 시간: 10:40-11:, 12:00-12:40 (실패)

#### 4. 반성

- 처음부터 다시...

- 방식 1
  - (sortGenres) Map<장르, 스트리밍 횟수 합>을 스트리밍 횟수 합의 내림차순으로 정렬
    - define Map<index, 스트리밍 횟수 합>
    - define Map<index, Entry<장르, 스트리밍 횟수 합>>
    - Map<index, 스트리밍 횟수 합>을 스트리밍 횟수 합이 낮은 순서대로 정렬
    - 두 Map이 index가 똑같으므로 정렬한 것에서 index를 갖다 씀 Map<index, Entry<장르, 스트리밍 횟수 합>>

- 방식 2
  - (문제 전체) 문제를 다시 설계
    - Map<장르, 스트리밍 횟수 합>
    - Map<장르, List<index>>
    - Map<장르, List<재생 횟수>>
    - genres만큼 반복을 돌면서
      - 위의 3개의 Map을 채움 (스트리밍 횟수는 합하고, index와 재생 횟수 List에는 각각 추가)
    - 각 장르 별로 List<재생 횟수>를 정렬하면서 그에 맞게 List<index>도 정렬
    - Map<장르, 스트리밍 횟수 합>에서 스트리밍 횟수 합이 큰 순서대로 정렬
    - 정렬된 장르별로 List<index>의 1, 2번째 index를 가져와 정답 배열에 삽입
