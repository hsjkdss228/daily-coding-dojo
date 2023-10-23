# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 문자열 안에 문자열

> 코딩테스트 입문

- https://school.programmers.co.kr/learn/courses/30/lessons/120908
- 문자열 string1, string2가 매개변수로 주어질 때,
- string1에 string2가 포함되어 있으면 true를,
- 없으면 false를 return한다.

### 23.4.11

#### 1. 이해

1. 주어진 조건은 무엇인가?
   1. 규칙
      - 문자열이 다른 문자열에 포함되어 있는지 비교한다.
   2. 제한사항
      - string1, string2의 길이: 1 이상 100 이하
      - string1, string2는 알파벳 대문자, 소문자, 숫자로 구성되어 있음
   3. 추론

2. 내가 이용할 수 있는 것은 무엇인가?
   - 두 문자열의 각 알파벳
   - string2의 알파벳 개수

3. 내가 모르는 건 무엇인가?
   - string2가 string1보다 길 수도 있을까?

#### 2. 계획

##### 최초 풀이

- contains를 사용하지 않고 풀어본다.
1. string2가 string1보다 길면 false
2. string1의 모든 알파벳을 순차적으로 순회
   1. string2의 모든 알파벳도 순차적으로 동시에 순회하는데
   2. string2의 알파벳과 string1의 알파벳이 같으면 string2를 계속 순회하고,
      같지 않으면 string1은 다음 알파벳을, string2는 첫 알파벳부터 다시 비교
   3. string2의 순회가 끝났으면 string1에는 string2가 있는 것이므로
      true를 return
3. string1의 모든 알파벳을 끝까지 순회했으면
   string1에는 string2가 없는 것임. 따라서 false를 return

#### 3. 실행

- 이해/계획: 11:05-11:15
- 풀이: 11:15-11:28
- 오류 추적: 11:28-11:40

#### 4. 반성

1. 에러 케이스가 하나 있었다.
   - string2의 알파벳을 순회하는 로직을 for문을 이용했다.
   - string2의 알파벳과 string1의 알파벳이 다르면
     string2의 반복을 첫 알파벳부터 다시 시작하게 하는 로직을 구현하기 위해서는
     둘이 다른 경우 string2 알파벳 index를 -1로 변경해
     다음 반복에서 string2 알파벳 index로 0을 참조하도록 했어야 했는데
     index를 0으로 변경했기 때문에 다음 반복에서 index가 1을 참조하는 오류가 발생했다.
   - 오류 수정 완료.
     이후 가독성이 별로 좋지 않은 것 같아 for 반복문 대신
     while 반복문을 사용하는 것으로 변경
