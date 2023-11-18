# [k진수에서 소수 개수 구하기]

[k진수에서 소수 개수 구하기]: https://school.programmers.co.kr/learn/courses/30/lessons/92335

> 2022 KAKAO BLIND RECRUITMENT

## 문제 이해

### 설명

- 양의 10진수 정수 `number`, k진수를 나타내기 위한 값 `k`가 주어짐
- `number`를 k진수로 바꿨을 때, 변환된 수 안에서 다음의 조건을 만족하는 소수의 개수를 반환.
  - 소수를 `P`라고 할 때,
    - `P`는 각 자리수에 0을 포함하지 않음.
    1. 소수 양쪽에 0이 존재: `0P0`
    2. 소수 왼쪽에는 아무것도 없고, 오른쪽에만 0이 존재: `P0`
    3. 소수 왼쪽에만 0이 존재하고, 오른쪽에는 아무것도 없음: `0P`
    4. 소수 양쪽에 아무것도 없음: `P`

### 제한사항

- 1 <= `number` <= 1_000_000
- 3 <= `k` <= 10
- 중복되는 소수가 도출되더라도, 모두 별도로 카운트.

## 풀이

### 풀이 1

#### 아이디어

- **`P`는 10진법으로 보았을 때의 소수!!**
  - 즉, 어떤 수를 3진법으로 바꿨을 때 `21102`이라는 수가 나왔다면,
  - `211`은 `(2 * 3^2) + (1 * 3^1) + (1 * 3^0)`으로 변환할 필요 없이 그냥 보이는 그대로의 10진수 `211`이 소수인지만 판별하면 됨.
- 숫자에 `0`이 포함되어야 하지 않으므로, 변환된 숫자들은 0을 기준으로 분리되어야 함.

#### 설계

```text
- number를 k진수로 변환: kNaryNumber

- kNaryNumber를 0으로 split: split

- split에서 소수의 수를 카운트
```

#### 결과

- 통과
- 수행 시간: 1-3ms, 15ms
- 메모리 사용량: 80MB 내외

## 회고

### long 타입으로 표현될 수 있는 수준으로 큰 수의 소수 구하기

- 다음의 방식은 주어지는 수가 너무 클 경우, 계산 범위를 2로 나눈다고 해도 너무 많은 연산을 수행해야 함.

```java
public boolean isPrimeNumber(long number) {
    if (number == 1) {
        return false;
    }

    if (number == 2) {
        return true;
    }

    if (number % 2 == 0) {
        return false;
    }

    for (int divisor = 3; divisor <= number / 2; divisor += 2) {
        if (number % divisor == 0) {
            return false;
        }
    }

    return true;
}
```

- 단순히 2로 나누는 것은 복잡도 감소에 유의미한 영향을 주지 못함.
  - 이를테면 `O(n / 2)`의 시간 복잡도는 여전히 `O(n)`.
- 일단 특정 범위 내의 모든 수로 주어지는 수를 나누어서 (즉 완전 탐색을 해서) 소수인지 판별하는 로직 자체는 해당 문제의 범위 내에서는 유효하다고 할 수 있음.
- 그렇다면 조회 범위가 어디까지 되어야 하겠는가?
- 소수인지 판별하는 과정의 핵심은 **'약수가 존재하는가'**.
- 그렇다면, 특정 수의 가장 큰 약수까지만 살펴보면, 그 이상의 수는 고려하지 않아도 됨. 그 이상의 수까지 살펴보는 것은 그 어떤 수로 나눠도 나누어떨어지지 않기 때문에 무의미.
- 특정 수의 가장 큰 약수는, **특정 수의 제곱근.**
- 따라서 특정 수의 제곱근을 반올림한 수까지의 범위만을 완전 탐색으로 조회한다면, 시간 복잡도를 감소시킬 수 있음.
  - 이를테면 `O(n / sqrt(n))`, 즉 `O(sqrt(n))`으로 시간 복잡도가 감소.
  - `O(logn)`보다는 느리지만, `O(n)`보다는 빠름.

```java
public boolean isPrimeNumber(long number) {
    if (number == 1) {
        return false;
    }

    if (number == 2) {
        return true;
    }

    long range = (long) Math.ceil(Math.sqrt(number));
    for (int divisor = 3; divisor <= range; divisor += 1) {
        if (number % divisor == 0) {
            return false;
        }
    }

    return true;
}
```

- 위의 로직에는 특정 수의 가장 큰 약수까지만 완전 탐색을 하는 방식으로 바꾼 것뿐만 아니라, 2로 나누어떨어지는 수이면 거짓을 반환하도록 한 조건문과 홀수만을 완전탐색하도록 한 부분을 삭제.
  - 해당 부분들 역시 시간 복잡도의 감소에 유의미한 영향을 끼치지 못하기 때문.

#### [참고 링크]

[참고 링크]: https://chat.openai.com/share/96bbc391-2f3f-45bd-99f9-aea9fcdf122c
