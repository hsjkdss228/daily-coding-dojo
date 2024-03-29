# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 문자열 정렬하기 (2)

> 코딩테스트 입문

- https://school.programmers.co.kr/learn/courses/30/lessons/120911
- 영어 대소문자로 이루어진 문자열 string이 매개변수로 주어질 때,
- string을 모두 소문자로 바꾸고 알파벳 순서대로 정렬한 문자열을 return한다.

### 23.4.6

#### 1. 이해

1. 주어진 조건은 무엇인가?
   1. 규칙
      - 주어진 문자열은 영어 대소문자의 조합
   2. 제한사항
      - string의 길이: 1 이상 99 이하
   3. 추론

2. 내가 이용할 수 있는 것은 무엇인가?
   - toLowercase
   - stream을 통해 각 알파벳을 문자 단위로 쪼갠 뒤,
   - 순서대로 정렬해서 다시 합침

3. 내가 모르는 건 무엇인가?
   - 문자열의 각 원소를 stream할 수 있는가?
   - List에 알파벳 하나씩 넣어서 stream할 수도 있기는 하겠지만,
     직접 변환할 수 있으면 좋을 것이다.
   - 문자열을 split해서 배열로 만든 뒤, 배열을 Stream하는 방식으로 해결

#### 2. 계획

##### 최초 풀이

1. 문자열의 각 알파벳을 모두 쪼갠 뒤 stream
   - 각 알파벳 전체에 대해 toLowercase
   - sorted
   - join
2. 결과 문자열을 정답으로 반환

#### 3. 실행

- 이해/계획: 13:00-13:10
- 풀이: 13:10-13:25

#### 4. 반성

- 문자열을 각 알파벳으로 쪼개기 전에 toLowercase를 먼저 해준 뒤,
  sorted, joining을 수행하면 수행 시간을 절약할 수 있다.
