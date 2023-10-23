# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 숫자 짝꿍

> 연습문제

- https://school.programmers.co.kr/learn/courses/30/lessons/131128
- 두 정수 number1, number2가 주어졌을 때, 두 정수의 짝꿍을 return한다.

### 23.3.6

#### 1. 이해

- 두 수의 짝꿍이란?
  - 두 정수의 임의의 자리에서 공통으로 나타나는 정수들을 이용하여 만들 수 있는 가장 큰 정수
  - ex. number1 = 5525, number2 = 1255라면
    - 두 수에서 공통으로 나타나는 숫자는 2, 5, 5 (number1의 5 하나는 짝지을 수 없음)
    - 해당 숫자들로 만들 수 있는 가장 큰 정수는 552
  - 두 수의 짝꿍이 존재하지 않으면 -1
  - 두 수의 짝꿍이 0으로만 구성되어 있다면 짝꿍은 0
- 각 수의 길이(자릿수): 3 이상 3,000,000 이하
- 두 수는 0으로 시작하지 않음
- 결과는 문자열로 반환

#### 2. 계획

- Map\<숫자, 공통으로 나타나는 횟수 카운트\> 정의
- 두 수에 대해 다음을 반복
  - ~~각 수의 자릿수 문자를 확인해~~
  - ~~Map에 숫자가 존재하지 않으면 \<숫자, 0\>을 put~~
  - ~~Map에 숫자가 존재하면 해당 숫자의 value += 1~~
  - number1, number2에서 각각 숫자가 출현한 횟수를 별도의 Map으로 카운트
  - number1, 2의 Map에 모두 특정 숫자 Key가 존재하는 경우에만
    두 Value 중 작은 쪽으로 Map에 put
- Map의 EntrySet을 확인해 다음을 수행
  - List로 변환하고, Key 크기에 따라 내림차순으로 정렬
  - Map이 비어있으면 (조건을 만족하기 위한 요소들이 없으면) -1 반환
  - Key 중 0의 Value만 1 이상이고 나머지 Key Value가 모두 0이면 정답으로 0 반환
  - List의 요소를 순서대로 확인해 Value의 크기만큼 Key를 정답에 이어붙여 정답으로 반환

#### 3. 실행

- 문제 계획 시간: 19:00-19:20
- 문제 풀이 시간: 19:30-21:00

#### 4. 반성

- Java의 reduce 함수는 JavaScript와는 다르게
  accumulator의 타입으로 주어진 Stream 컬렉션의 요소 타입과 다른 타입을 부여할 수는 없다.
- 즉 다음과 같은 방식의 reduce는 Java에서 사용할 수 없다.

```Java
// digitAndCountsDescendantKey의 타입은 Map.Entry<>
return digitAndCountsDescendantKey.stream()
    .reduce("", (answer, digitAndCount) -> {
        int count = digitAndCount.getValue();
        String digits = "";
        for (int i = 0; i < count; i += 1) {
            digits += digitAndCount.getKey();
        }
        return digits;
    });
```
