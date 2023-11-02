# [모음 사전]

[모음 사전]: https://school.programmers.co.kr/learn/courses/30/lessons/84512

> 완전탐색

## 문제 이해

### 설명

- 'A', 'E', 'I', 'O', 'U' 5개의 문자를 이용해 만들 수 있는 길이 5 이하의 모든 단어가 수록된 사전이 존재.
  - ['A', 'AA', 'AAA', ... , 'UUUUU']
- 주어지는 단어가 사전에서 몇 번째 단어인지 return

### 제한사항

- 1 <= `word.length` <= 5
- `word`는 'A', 'E', 'I', 'O', 'U'로만 이루어짐.

## 풀이

### 풀이 1

#### 아이디어

1. 만들 수 있는 모든 단어를 사전 순서대로 순회한다.
   - 사전을 모두 만들 필요가 없다. 찾아지는 단어의 순서가 정답.
2. word를 단어 하나하나로 분절해 비교하기에는 1-5개 중 몇 개로 이루어져 있을지 모르므로 문자열로 비교.
   - 문자열을 만드는 동작이 효율적이어야 할 것임.

#### 설계

순서를 무식하게 써 보면  
A  
AA  
AAA  
AAAA  
AAAAA  
AAAAE  
AAAAI  
AAAAO  
AAAAU  
AAAE  
AAAEA  
AAAEE  
AAAEI  
AAAEO  
AAAEU
AAAI
AAAIA
AAAIE
...  
AAE  
AAEA  
AAEAA  
AAEAE  
...  

```text
given word

define Vowel: A, E, I, O, U
define order: 0

define stringBuilder: StringBuilder

for first: A to U
    order += 1
    if createdWordEquals(stringBuilder, first, word) == true
        return order
    for second: A to U
        order += 1
        if createdWordEquals(stringBuilder, second, word) == true
            return order
        for third: A to U
            order += 1
            if createdWordEquals(stringBuilder, third, word) == true
                return order
            for fourth: A to U
                order += 1
                if createdWordEquals(stringBuilder, fourth, word) == true
                    return order
                for fifth: A to U
                    order += 1
                    if createdWordEquals(stringBuilder, fifth, word) == true
                        return order
                world.delete(fourthIndex)
            world.delete(thirdIndex)
        world.delete(secondIndex)
    world.delete(firstIndex)

wordEquals(stringBuilder, character, word): boolean
    define other: A ? stringBuilder.append(character).toString()
        : stringBuilder.remove(lastIndex).append(character).toString()
    return other.equals(word)
```

#### 결과

- 통과
- 수행 시간: 최대 5ms
- 메모리 사용량: 65-80MB

## 회고

### 재귀함수를 이용한 소스코드의 반복 개선

- 동일한 로직의 for문이 반복적으로 중첩될 때, 재귀함수를 통해 개선할 수 있음.
- 특정 종료조건을 만족할 때, 반복적으로 호출된 재귀함수에서 진입 지점까지 탈출할 수 있어야 함.

### 그 외의 풀이

- 특정 자리수가 변경되는 만큼 추가되는 순서를 계산해 사전 순서를 알아낼 수도 있음.
- 이 경우, 어떤 단어를 검색하더라도 연산에 걸리는 시간은 거의 동일.
