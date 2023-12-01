
# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 구명보트
사람들의 몸무게를 담은 배열 people과 구명보트의 무게 제한 limit가 매개변수로 주어질 때,
모든 사람들을 구출하기 위해 필요한 구명보트 개수의 최소값을 return한다.

#### 1. 이해
- 주어진 것은 무엇인가? / 모르는 것은 무엇인가? / 자료는 무엇인가? / 조건은 무엇인가?
  - 무인도에 갇힌 사람은 1명 이상 50,000명 이하
  - 각 사람의 몸무게는 40~240
  - 구명보트의 무게 제한은 40~240
  - 구명보트의 무게 제한은 항상 사람들의 몸무게 중 최댓값보다 크게 주어짐
  - 정수형 비교

#### 2. 계획
- 배열을 오름차순으로 정렬한다.
- 다음을 반복한다.
  - 가장 무게가 높은 사람부터 순차적으로 태운다. (몸무게 배열에서 제거한다.)
  - 더 이상 무게가 높은 사람 순으로 순차적으로 태울 수 없을 경우,
    가장 무게가 낮은 사람부터 다시 순차적으로 태운다. (몸무게 배열에서 제거한다.)
  - 태울 수 없을 경우 구명보트 개수에 1을 추가한다.
- 총 구명보트 개수를 return한다.

#### 3. 실행


#### 4. 반성
- 가장 무게가 높은 사람과 낮은 사람을 한 명씩 태워서 순차적으로 보내는 것이 가능했다.
- 근데 낮은 무게인 사람을 최대한 태울 수 있는 것 아닌가? 생각했다.
- 가장 큰 문제는 구명보트는 작아서 한 번에 최대 2명씩밖에 태울 수 없다는 사실을 간과했다는 점이다.
- 엣지 케이스를 처음에 꼼꼼하게 확인하지 않으면 내 논리가 맞는 논리인 것 같아도 엇날 수밖에 없다.
- 이해 단락을 처음 썼다고 끝낼 게 아니라 문제가 막히면 이해 란을 다시 작성하도록 하자.