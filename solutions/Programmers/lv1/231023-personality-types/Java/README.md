# [성격 유형 검사하기]

[성격 유형 검사하기]: https://school.programmers.co.kr/learn/courses/30/lessons/118666

> 2022 KAKAO TECH INTERNSHIP

## 문제 이해

### 설명

- 각 지표
  - 1번 지표: RT, TR
  - 2번 지표: CF, FC
  - 3번 지표: JM, MJ
  - 4번 지표: AN, NA
- 각 지표에 대해 1-7 사이의 숫자가 나올 수 있음
  - 4: 양 지표 중 어느 쪽에도 점수를 부여하지 않음
  - 1-3: 지표 중 첫 번째 지표에 (+3)-(+1)
    - survey[i]: RT, choice[i]: 1이면, R += 3
  - 5-7: 지표 중 두 번째 지표에 (+1)-(+3)
    - survey[i]: NA, choice[i]: 6이면, A += 2
- 최종적으로 모든 지표에 매겨진 점수를 합산해 1-4번 지표 중 어느 유형에 해당하는지 판별
  - 이때, 각 지표에서 둘의 점수가 같을 경우 사전순으로 빠른 지표를 유형으로 판별

### 제한사항

- 1 <= survey.length <= 1_000 
- survey[i]: RT, TR, CF, FC, JM, MJ, AN, NA 중 하나
- survey.length == choice.length
- 1 <= choice[i] <= 7

## 풀이

### 풀이 1

#### 아이디어

- 배열을 한 번 순회하면서 각 유형 별 점수를 생성한다.
- 생성된 각 유형 별 점수를 통해 성격 유형을 판별한다.

#### 설계

```text
define Map<Type: Character, Score: Integer> typeToScores

- calculateTypeScores
    for each survey[i] and choices[i]
        if choices[i] is 1-3
            type = survey[i].charAt(0)
            add score of type: (score + 4 - choices[i])
            continue
        if choices[i] is 5-7
            type = survey[i].charAt(1)
            add score of type: (score + choices[i] - 4)
            continue
        (do nothing if score is 4)

- define result = determinePersonalityType
    define firstType: R score >= T score ? R : T
    define secondType: C score >= F score ? C : F
    define thirdType: J score >= M score ? J : M
    define fourthType: A score >= N score ? A : N
    
    return firstType + secondType + thirdType + fourthType

return result
```

#### 결과

- 통과
- 수행 시간 비교
  - String 합 연산 시: 10-30ms 내외에서 형성
  - StringBuilder, StringBuffer 사용 시: 0.2-1ms 내외에서 형성
- 메모리 사용량 비교
  - String 합 연산, StringBuilder, StringBuffer 모두 평균 7-80MB 내외에서 형성

## 회고

### String 합 연산보다 StringBuilder/StringBuffer를 통한 String 생성 시 연산 시간이 단축되는 이유?

- 불변성 (Immutability)
- Java에서 `String`은 불변 객체.
- 특정 `String` 생성 시 JVM이 `String`을 다루는 방식
  - `String` 풀에서 동일한 `String`을 찾음. 존재할 경우, 해당 `String` 객체의 참조를 반환.
  - 존재하지 않을 경우, `String` 풀에 해당 `String` 객체를 생성해 참조를 반환.
- 하나의 구문 내에서 `String`을 '+' 연산자를 통해 반복적으로 연산하는 경우에도 각각의 분절된 연산마다 새로운 `String` 객체를 생성하고 메모리를 할당.
  - ex) "R" + "F" + "M" + "A" 연산을 수행하는 경우
    ```Java
    String result = "R" + "F" + "M" + "A";
    ```
    - "R" + "F": `String` 풀에서 "R", "F" 및 "RF" 조회, 모두 없으므로 생성 후 저장 
    - "RF" + "M": `String` 풀에서 "RF", "M" 및 "RFM" 조회, "M"과 "RFA"가 없으므로 생성 후 저장 
    - "RFM" + "A": `String` 풀에서 "RFM", "A" 및 "RFMA" 조회, "A"와 "RFMA"가 없으므로 생성 후 저장
    - 따라서 O(3n)의 시간 복잡도, O(n)의 공간 복잡도가 소요. 이때 서로 다른 문자열이 많으면 많을수록 더 많은 연산 시간과 저장공간을 요구.
- 반면 `StringBuilder`/`StringBuffer`는 메서드로 전달받은 문자열을 통해 자기자신의 객체 내에서 문자열을 생성한 뒤, `toString()` 메서드를 호출해 `String`으로 변환.
  - ex)
    ```Java
    String result = new StringBuilder()
        .append("R")
        .append("F")
        .append("M")
        .append("A")
        .toString();
    ```
  - 이로 인해 `String` 풀에는 "RFMA" 문자열 단 하나에 대해서만 `String` 풀에서 조회하고 생성, 저장하므로 시간 복잡도, 공간 복잡도 모두 O(1)으로 단축.
  - 반복적인 문자열 연산이 많은 경우 `StringBuilder`/`StringBuffer`를 사용하면 성능을 개선할 수 있음.
- `StringBuilder` vs `StringBuffer`
  - `StringBuilder`는 Thread-safe하지 않으나 `StringBuffer`보다 좋은 성능을 보임.
  - `StringBuffer`는 동기화 동작이 존재하므로 `StringBuilder`보다 성능은 좋지 못하나, Thread-safe.
