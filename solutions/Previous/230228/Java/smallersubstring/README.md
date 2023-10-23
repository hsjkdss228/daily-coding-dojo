# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 크기가 작은 부분문자열

> 연습문제

- https://school.programmers.co.kr/learn/courses/30/lessons/147355
- 숫자로 이루어진 두 개의 문자열 number1, number2가 주어질 때,
  number1에서 number2와 길이가 같은 부분문자열이 나타내는 수가
  number2가 나타내는 수보다 작거나 같은 경우의 개수를 return한다.

### 23.2.28

#### 1. 이해

- ex. number1 = "3141592", number2 = "271"인 경우
  - number1의 길이가 3인 부분 문자열은 314, 141, 415, 159, 592
  - 이 숫자들 중 271보다 작거나 같은 수는 141, 159로 2개
- number2의 길이: 1 이상 18 이하
- number1의 길이: number2의 길이 이상 10,000 이하
- number1과 number2는 숫자로만 이루어진 문자열이고, 0부터 시작하지 않음
- 부분 문자열의 앞 글자가 0인 경우 포함시키지 않음

#### 2. 계획

- count = 0;
- for (i = 0; i < number1의 길이 - number2의 길이; i += 1)
  - 부분 문자열을 추출: index가 i부터 (i + number2의 길이 - 1)만큼
  - 부분 문자열이 number2보다 작거나 같으면 count += 1
- count를 반환

#### 3. 실행

- 문제 계획 시간: 23:40-23:50
- 문제 풀이 시간: 23:50-24:20

#### 4. 반성

- 문자열.substring(시작 index, 끝 index)에서
  끝 인덱스는 나타내고자 하는 부분 문자열의 마지막 부분의 다음 index를 지정해야 한다.
  - 예를 들어, "3141592"의 0-2번째 index만큼의 문자열인 "314"를 나타내기 위해서는
    "3141592".substring(0, 3)과 같이 substring에 인자를 주어야 한다.
- number2의 최대 길이는 18일 수 있다.
  int 타입으로 변환할 경우, NumberFormatException이 발생할 수 있으므로
  숫자들을 long 타입으로 변환해 크기를 비교해야 한다.
