
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
  - List<List<Integer>>을 하나 놓는다. 여기에 튜플의 각 집합을 담을 것이다.
  - }}가 두 번 나올 때까지 (문자열이 끝날 때까지) 반복을 돌린다.
    - }가 나올 때까지 반복을 돌린다.
      - List<Integer>를 하나 놓는다.
      - 숫자가 나오면 넣는다.
      - ,가 나오면 넘어간다.
      - 만들어진 하나의 List<Integer>를 List<List<Integer>>에 넣는다.

- 컬렉션에서 하나씩 꺼내와서 튜플 만들기
  - 정답 List<Integer>를 놓는다.
  - List<List<Integer>>를 들고 있는 List<Integer>의 길이 순으로 정렬한다.
  - 작은 List<Integer>부터 하나씩 꺼내온다. 처음에 꺼내온 List<Integer>에 있는 가져온 값 하나를 넣는다.
  - 그 다음 List<Integer>를 꺼내오면, List<Integer>에 들어있는 숫자들 중 
    정답 List<Integer>에 있는 숫자들은 모두 제거한다. (꼭 순서를 지켜서 제거해야 한다.)
  - 남아있는 숫자들을 정답 List<Integer>에 순서대로 넣는다.

#### 3. 실행

#### 4. 반성
- 다른 사람의 풀이를 보고 참고하였음
  - https://123okk2.tistory.com/323
  - 문자열을 배열로 전환하는 데에서부터 큰 어려움을 겪었다.
  - 이 부분은 문자열을 다루고, 문자열 그룹을 어떤 컬렉션으로 보고 나눌 것인지
    문자열 메서드를 많이 연습하고 패턴들에 익숙해져야 할 것 같다.
