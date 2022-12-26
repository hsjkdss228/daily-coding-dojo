# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 과일 장수
과일 장수가 사과 상자를 팔았을 때 얻을 수 있는 최대 이익을 return한다.

#### 1. 이해
- 사과 한 상자의 가격을 결정하는 방식
  - 사과 하나의 점수는 1-k점까지의 점수로 분류: (1점: 최하품, k점: 최상품)
  - 사과 상자에는 numberInBox개의 사과를 담음
  - 사과 상자의 가격: 사과 상자에 담긴 사과 중 [가장 낮은 점수 * numberInBox]
- k의 범위: 3-9
- numberInBox의 범위: 3-10
- 사과들의 점수를 담은 배열(scores)의 길이: 7-1,000,000
- 각 사과의 점수(scores[i]): 1-k
- 이익이 발생하지 않는 경우에는 0을 return

#### 2. 계획
- 사과 상자에 들어가는 사과 개수가 주어진 사과 개수보다 많은 경우에는 0을 return
- scores를 내림차순으로 정렬한다: [최상품, 차상품, 차차상품, ... , 차하품, 최하품]
- 정답을 놓는다.
- scores에 대해 반복을 도는데, 한 상자에 담기는 사과에서 최하점수의 사과 가격만 확인하면 되므로
  - i = 0; i < scores.length; i += numberInBox
  - 정답 += scores[i] * numberInBox
- 정답을 return한다.

#### 3. 실행
- 문제 풀이 계획 시간: JavaScript 풀이를 index를 참조하는 for문으로 풀이하는 식으로 풀이
- 문제 풀이 시간
  - Java: 10:50-11:15
  
#### 4. 반성
- 반성은... 딱히 없다.
- int 배열을 내림차순으로 정렬하는 방법에는 두 가지가 있었는데,
  int 배열 그대로인 상태에서는 내림차순 정렬이 어려웠고 int 배열을 boxed된 Integer 배열로 바꿔줘야 했음
  - Arrays.sort(array, Collections.reverseOrder());
  - Arrays.sort(array, (a, b) -> b - a);
