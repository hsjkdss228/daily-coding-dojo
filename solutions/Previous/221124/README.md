
# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## H-Index
어떤 과학자의 논문 인용 횟수를 담은 배열 citations가
매개변수로 주어질 때, 이 과학자의 H-Index를 return한다.

#### 1. 이해
- 주어진 것은 무엇인가? / 모르는 것은 무엇인가? / 자료는 무엇인가? / 조건은 무엇인가?
  - 과학자가 발표한 논문 n편 중,
  - h번 이상 인용된 논문의 개수는 h보다 크거나 같다.
  - 나머지 논문들은 h번 이하로 인용되었다.
  - 논문 인용 횟수 citations가 [3, 0, 6, 1, 5]만큼 주어졌을 때,
    - 논문의 수는 5편
    - 3편의 논문들은 3회 이상 인용됨 (6, 5, 3)
    - 나머지 논문들은 3회 이하로 인용됨 (1, 0)

#### 2. 계획
- 만약 citations가 [3, 0, 6, 3, 5]로 주어진다면
  - 3편의 논문들은 3회 이상 인용됨 (6, 5, 3)
  - 나머지 논문들은 3회 이하로 인용됨 (3, 0)
  - 같은 경우도 있을 수 있음

- 어제 정답 케이스에서 발견했던 놓쳤던 부분을 바탕으로
  기존 풀이의 논리 보완을 시도
- 꺼내온 숫자인 그 논문이 인용된 횟수를 봐야 하는 게 아니라
  그 논문보다 인용횟수가 크거나 같은 논문의 '개수'를 기준으로 잡기 위해
  꺼내온 숫자가 아닌 배열을 확인하는 숫자의 인덱스를 참조하는 것을 시도

- 배열을 내림차순으로 정렬
- 배열의 요소만큼 반복을 돌린다.
  - 배열에서 숫자 하나를 꺼내오는데, ~~꺼내온 숫자의 크기만큼 배열을 맨 앞에서부터 순서대로 다시 탐색하면서
    꺼내온 숫자보다 크거나 같은 요소들의 개수를 센다.~~
    - 배열을 다시 탐색하면서 개수를 셀 필요가 없다.
      [배열 길이 - index] 방식으로 조건을 만족하는 인용된 논문 편수를 셀 수 있음
  - [꺼내온 숫자] <= [배열 길이 - index] 개수가 같으면 배열 길이 - index가 정답

#### 3. 실행

#### 4. 반성
