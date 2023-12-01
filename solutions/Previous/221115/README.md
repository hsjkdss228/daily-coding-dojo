
# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## N개의 최소공배수
n개의 숫자를 담은 배열 array가 입력되었을 때, 이 수들의 최소공배수를 반환한다.

#### 1. 이해
- 주어진 것은 무엇인가? / 모르는 것은 무엇인가? / 자료는 무엇인가? / 조건은 무엇인가?
  - 최소공배수의 정의
    n개의 수들의 배수 중 공통이 되는 가장 작은 숫자
    자료형: 자연수

#### 2. 계획
- 유클리드 호제법을 구하는 공식을 이용한다.
  - 두 수를 곱한 수를 최대공약수로 나눈다.
  - 최대공약수만 구하면, 최소공배수를 바로 구할 수 있다.
    - 최대공약수는 두 수가 동시에 나누어떨어지는 수들 중 가장 큰 수이다.
    - 1부터 두 수 중 작은 수까지 반복을 돌면서 나누어떨어지는 수들을 배열에 push하면,
      배열에 가장 마지막으로 들어간 수가 최대공약수
  - 이런 식으로 구한 두 수의 최소공배수를 n개의 수만큼 반복한다.
  - 함수형 메서드를 이용해 반복한다.

#### 3. 실행
  
  
#### 4. 반성
- 유클리드 호제법이라는 너무 좋은 공식을 알아버렸기 때문에
  쓰는 게 가장 효율적일 수밖에 없었지만,
  최대공약수를 구하는 방식만큼은 직접 구현해보았다.
  Math.ceil(작은 수 / 2)까지만 반복을 돌아도 괜찮을 것 같다.