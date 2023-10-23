# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 개인정보 수집 유효기간
- https://school.programmers.co.kr/learn/courses/30/lessons/150370
- 오늘 날짜 문자열 today, 각 약관의 유효기간 문자열 배열 terms,
  수집된 개인정보의 정보 문자열 배열 privacies가 매개변수로 주어질 때,
  파기해야 할 개인정보의 번호를 오름차순으로 배열에 담아 return한다.

#### 1. 이해
- today: yyyy.mm.dd
- terms: [약관 종류, 유효기간]
  - 길이는 1 이상 20 이하
  - 약관 종류: "A" ~ "Z"
  - 유효기간: 1 이상 100 이하의 정수, 개인정보 보관이 가능한 '달' 수를 나타냄
- privacies: [날짜, 약관 종류]
  - 길이는 1 이상 100 이하
  - 각 개인정보의 번호: index + 1
  - 날짜: yyyy.mm.dd, today 이전의 날짜만 주어짐
  - 약관 종류: terms의 약관 종류 중 하나
- yyyy.mm.dd
  - yyyy: 2000 이상 2022 이하
  - mm: 01 이상 12 이하, 한 자리수인 경우 앞에 0이 붙음
  - dd: 01 이상 28 이하, 한 자리수인 경우 앞에 0이 붙음
- 파기해야 할 개인정보가 하나 이상 존재하는 입력만 주어짐

#### 2. 계획
- today를 날짜로 표현한 절대값으로 변경
  - (yyyy * 12 * 28) + (mm * 28) + dd
- 유효기간 Map<약관 종류(String), 유효 기간(Integer)>을 정의하고 term을 삽입
  - 유효 기간은 날짜 절대값으로 Parsing해서 삽입: 유효 기간 * 28
- 결과 index들을 담을 List를 놓고 
- privacies를 순회
  - privacy를 split해서 [1]번째의 약관 종류를 이용해 유효기간 Map에서
    날짜로 표현한 절대값을 찾음
  - split의 [0]번째의 yyyy.mm.dd를 날짜로 표현한 절대값으로 변경
  - 차이 = today를 날짜로 표현한 절대값 - split의 [0]번째의 yyyy.mm.dd를 날짜로 표현한 절대값
  - 차이가 유효 기간보다 크면 결과 List에 index를 추가
- List를 array로 변환한 결과가 정답

#### 3. 실행
계획 시간: 9:00-9:30, 9:40-9:45
문제 풀이 시간: 9:45-10:35
오류 추적 시간: 10:35-10:40

#### 4. 반성
- 수집된 개인정보는 유효기깐까지가 아니라 유효기간 '전'까지 보관해야 함
- 따라서 difference > expirationAbsoluteDate이 아니라
  difference >= expirationAbsoluteDate이 되어야 함
- terms와 privacies의 이름을 헷갈려서 privacies를 써야 할 곳에 terms를 쓰고 있었다.
  - for문에서 privacies.length 대신 terms.length를 쓰고 있었다던가
  - isExpired에 privacy가 아니라 term을 넘겨주고 있었다던가
