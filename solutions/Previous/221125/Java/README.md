
# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 타겟 넘버
n개의 음이 아닌 정수들이 주어질 때, 정수들을 순서를 바꾸지 않고 더하거나 빼서
특정한 타겟 넘버를 만들 수 있는 경우의 수를 반환한다.

#### 1. 이해
- 주어지는 정수의 개수는 2~20개
- 각 정수의 범위는 1~50인 자연수 (0은 주어지지 않는다)
- 타겟 넘버는 1~1000
- 정수들의 순서는 바뀌어서는 안 된다.
- 정수들의 부호는 바뀔 수 있다.

#### 2. 계획
- 일단 모든 정수를 합해도 타겟 넘버보다 작으면 정답은 0
- 특정 수가 양수인 경우와 음수인 경우를 갈라서
  이전 계산 결과를 누적시키는 방식으로 모든 경우의 수를 찾아야 할 것 같았는데
  도저히 어떻게 계산 결과를 쌓을지 모르겠어서 다른 사람의 풀이를 참조
- 일단 재귀함수를 이용해 계산 결과를 하나씩 합해서 기억하는 식이 아닌,
  매 분기마다 배열을 생성하는 방식으로 풀이 시도 

- 주어진 배열만큼 반복을 돌린다.
- 첫 번째 원소를 꺼내오면 이전에 값이 있던 원소에 더한 경우와 뺀 경우로 새 배열을 만든다.
- 예를 들어, [1, 2, 3, 4]가 주어졌다면
  - 1 꺼내옴 -> [1]
  - 2 꺼내옴 -> [1+2, 1-2] -> [3, -1]
  - 3 꺼내옴 -> [3+3, -1+3, 3-3, -1-3] -> [6, 2, 0, -4] 이런 식으로
- 최종 배열이 만들어졌을 때, 배열에 타겟 넘버와 같은 숫자의 개수가 정답

#### 3. 실행

#### 4. 반성