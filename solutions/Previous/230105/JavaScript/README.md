# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 서울에서 김서방 찾기
문자열로 이루어진 배열 seoul에서 "Kim"의 위치 x를 찾아 "김서방은 x에 있다" 문자열을 반환한다.

#### 1. 이해
- seoul은 길이 1 이상 1000 이하인 배열
- seoul의 각 요소는 길이 1 이상 20 이하인 문자열
- "Kim"은 반드시 seoul에 포함되어 있음

#### 2. 계획
- seoul.findIndex((person) => person === 'Kim')로 찾기

#### 3. 실행
계획 시간: 10:50-10:55
문제 풀이 시간: 10:55-11:00

#### 4. 반성
- seoul.indexOf('Kim')으로도 찾을 수 있다.
