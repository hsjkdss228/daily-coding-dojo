# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 삼총사

> 연습문제

- https://school.programmers.co.kr/learn/courses/30/lessons/131705
- 학생들의 번호를 나타내는 정수 배열 numbers가 매개변수로 주어질 때,
  학생들 중 삼총사를 만들 수 있는 방법의 수를 return한다.

### 23.3.7

#### 1. 이해

- 삼총사란?
  - 학생 3명의 정수 번호를 더했을 때 0이 되는 경우
- numbers의 길이: 3 이상 13 이하
- numbers의 각 원소의 크기: -1000 이상 1000 이하
- 서로 다른 학생의 정수 번호가 같을 수 있음

#### 2. 계획

- Set<학생 3명의 index 묶음 객체> 정의
  - 학생 3명의 index 묶음 객체의 equals
    - 객체 내 3개의 index 변수가 다른 객체 내 3개의 index 변수와
      순서는 다르더라도 값들이 같은 경우
- numbers를 0부터 순회
  - 반복문 내에서 해당 number를 제외한 numbers를 정의하고 0부터 순회
    - 반복문 내에서 참조하는 두 number들을 제외한 numbers를 정의하고 0부터 순회
    - 쌍을 만들어서 Set<학생 3명의 index 묶음 객체>에 삽입
- Set의 모든 원소들에 대해 다음을 반복
  - 각 학생 3명의 index 묶음 객체의 원소를 참조해
    학생 3명의 정수 번호를 파악하고, 삼총사인 경우 정답 += 1
- 최종적으로 도출된 정답을 반환

#### 3. 실행

- 문제 계획 시간: 15:00-15:40
- 문제 풀이 시간: 15:30-17:50

#### 4. 반성

- Set에 객체를 삽입할 때,
  객체의 equals를 Override해서 조건을 만족하면 같은 객체로 인식하게 해
  Set에 add하지 않는 것을 의도했으나 의도대로 동작하지 않음
- 일단 Set에 객체가 존재하는지 검증하는 동작을 객체의 equals가 아닌
  별도의 프로세스로 빼 수행
- 문제의 원인은 HashSet에 요소가 삽입되는 방식에 있었음.
  - HashSet에 요소가 삽입될 때, 삽입되는 요소는 hashCode 메서드를 통해 반환받은 고유한 해시 값을
    해당 HashSet의 버킷 수로 나눠 그 나머지 값을 index로 하는 위치에 요소를 저장
  - 즉 HashSet에 존재하는 특정 객체가 이미 존재하는 객체임을 확인하기 위해서는
    HashSet에 들어 있는 비교 대상 객체와, 삽입하려는 객체의 hashCode 값이 같아야만
    비교 대상 객체를 찾을 수 있는 것임
  - 기존에 정의한 hashCode 생성 로직은 이를테면 Objects.hash(1, 2, 3)와
    Objects.hash(3, 1, 2)가 서로 다른 hashCode 값을 반환하기 때문에
    비교하려는 객체가 HashSet에 add되었을 때 접근할 수 있었던 index에는
    기존에 저장되어 있던 객체가 존재하지 않았기 때문에
    애초에 비교 연산을 수행하지 않고 그대로 HashSet에 add된 것...
- hashCode 메서드를 index 묶음 객체의 각 index를 Objects.hash(index)해
  3개의 hashCode를 생성한 뒤, 3개의 hashCode를 더한 결과 값을
  최종 hashCode 값으로 사용하도록 해 문제 해결
  - 이렇게 하면 특정 index 묶음 객체 내 index들이 비교 대상 객체의 index들과
    순서가 다르더라도 값이 같다면 같은 hashCode 결과 값을 가질 수 있기 때문에
    HashSet에 add될 때 기존에 저장되어 있던 비교 대상 객체가 저장된 위치에 접근할 수 있고,
    비교 연산을 수행할 수 있음