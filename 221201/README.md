
# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 튜플
특정 튜플을 표현하는 집합이 담긴 문자열 s가 매개변수로 주어질 때, s가 표현하는 튜플을 배열로 return한다.

#### 1. 이해
- 튜플에는 원래 중복되는 원소가 있을 수 있지만, 문제에서는 중복되는 원소는 주어지지 않는다.
- 원소에 정해진 순서가 있기 때문에, 원소가 같아도 순서가 다르면 서로 다른 튜플임에 주의해야 한다.
  - (1, 2, 3)과 (1, 3, 2)는 같지 않다.
- 원소가 n개인 튜플은 1개부터 n개까지의 집합들의 묶음으로 표현할 수 있다.
  - (2, 1 3)이면 {{2}, {2, 1}, {2, 1, 3}} 이런 식으로.
  - 집합은 원소의 순서가 바뀌어도 상관없기 때문에 {{2}, {2, 1}, {1, 2, 3}}은
    위의 튜플과 같은 튜플이다.
- 아래의 집합은 위의 집합과 같은 튜플을 나타내야 한다.
- 한편 튜플 집합 문자열은 숫자와 '{', '}', ','로만 구성된다.

#### 2. 계획
- 작업은 크게 두 가지로 나뉜다.
  - 문자열을 가져와서 배열로 만들어 컬렉션에 넣기
  - 컬렉션에서 하나씩 꺼내와서 튜플 만들기

- 문자열을 가져와서 배열로 만들어 컬렉션에 넣기
  - 하나의 { } 안에 얼마나 많은 숫자가 있을지 알 수 없다. 전체 { }에도 얼마나 있을지 알 수 없다.
  - (Java 식으로 표현하면) List<String[]>을 하나 놓는다. 여기에 튜플의 각 집합을 담을 것이다.
  - {{, }}을 제거한다. >> ('2,1,3},{2},{2,1')
  - },{을 특정 구분자로 대체한다. (ex. '/') >> '2,1,3/2/2,1'
  - 구분자를 기준으로 split해 배열을 생성한다. >> ['2,1,3', '2', '2,1']
  - 배열의 요소가 가진 숫자 개수에 맞춰 배열을 정렬한다. >> ['2', '2,1', '2,1,3']
  - List<String[]>에 다음을 반복하면서 하나씩 배열을 넣는다.
    - 생성한 배열의 요소를 하나씩 꺼낸다.
    - ','로 split해 배열을 생성하고, List<String[]>에 넣는다.
  - 생성한 컬렉션의 결과는 다음과 같다.
    : [[2], [2, 1], [2, 1, 3]]

- 컬렉션에서 하나씩 꺼내와서 튜플 만들기
  - 정답 배열을 하나 놓는다.
    정답 배열이 가질 원소의 개수는 가장 큰 집합이 가진 원소의 개수와 같다.
  - 다음을 반복한다.
    - 컬렉션에서 집합 배열을 하나씩 꺼낸다. 정렬했으므로 원소의 개수가 작은 것부터 꺼내진다.
      - 집합 배열에서 원소를 하나씩 꺼낸다.
      - 정답 배열에 꺼내온 원소가 없으면, 원소를 정답 배열에 넣는다.
        원소 개수가 작은 배열부터 순서대로 넣으므로, 튜플의 순서를 지킬 수 있다.

#### 3. 실행

#### 4. 반성