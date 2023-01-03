# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 문자열 다루기 기본
주어지는 문자열 s의 길이가 4 또는 6이고, 숫자로만 구성되어 있는지 확인하는 함수를 완성한다.

#### 1. 이해
- s의 길이는 1 이상, 8 이하인 문자열
- s는 영문 알파벳 대소문자 또는 0-9 사이의 숫자로 이루어져 있음

#### 2. 계획
- s의 길이가 4이거나 6이 아니면 false
  - if !(문자열.length === 4 || === 6), return false
- [...문자열].reduce
  - 초기값은 true
  - 숫자이면 초기값을 그대로, 숫자가 아니면 false를 return
  - 어떤 함수를 사용해 숫자인지 확인할 것인가? isNaN(character)
  - 숫자가 아닌 문자를 만나는 순간 accumulator는 영원히 false
- 정답으로 accumulator를 return

#### 3. 실행
계획 시간: 09:15-09:25
문제 풀이 시간: 09:25-09:50

#### 4. 반성
- 문자가 숫자인지 아닌지 체크하는 함수를 사용하기 위해 isNaN을 사용
- airbnb 컨벤션에 따르면, isNaN(character) 대신
  Number.isNaN(Number(character))을 사용할 것을 권장하고 있었음
  - https://github.com/airbnb/javascript#standard-library--isnan
- Number.isNaN(character) 형태는 숫자인지 아닌지를 올바르게 검출하지 못했음
- 다른 사람의 풀이 중 유용한 것에는 정규식을 이용한 풀이가 있었음
  - const regex = /^\d{6}$|^\d{4}$/;
    - 숫자여야 하고 (\d)
    - 4이거나 6이어야 하는 ({6}, {4})
    - 두 개의 정규식을 OR로 연결 (/^정규식$|^정규식$/)
