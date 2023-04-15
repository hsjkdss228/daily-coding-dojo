# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## n의 배수 고르기

> 연습문제

- https://school.programmers.co.kr/learn/courses/30/lessons/120905
- 정수 number와 정수 배열 numbers가 매개변수로 주어질 때,
- numbers에서 number의 배수가 아닌 수들을 제거한 배열을 return한다.

### 23.4.15

#### 1. 이해

1. 주어진 조건은 무엇인가?
   1. 규칙
      - a를 b로 나눴을 때 나머지가 0이라면, a는 b의 배수
   2. 제한사항
      - number의 크기: 1 이상 10,000 이하
      - numbers의 길이: 1 이상 100 이하
      - numbers[i]의 크기: 1 이상 100,000 이하
   3. 추론

2. 내가 이용할 수 있는 것은 무엇인가?
   - 정수 number
   - 정수 배열 numbers의 각 수

3. 내가 모르는 건 무엇인가?
   - number가 numbers[i]를 나눴을 때 나머지가 0인지

#### 2. 계획

##### 최초 풀이

1. numbers.stream()
   - numbers의 각 수를 number로 나눈 나머지가 0이면 해당 수로, 아니면 -1로 변환
   - -1은 제외
   - 배열로 변환해 정답으로 반환

#### 3. 실행

- 이해/계획: 10:10-10:15
- 풀이: 10:15-10:30

#### 4. 반성

- map해서 나머지를 확인해 해당 수 아니면 -1로 변환하는 과정은
  filter에서 나머지를 확인해 바로 포함시키거나 제거하는 방식으로 축약할 수 있었다.


- https://stackoverflow.com/questions/64974871/what-is-the-difference-between-intstream-and-streaminteger
- IntStream과 Stream<Integer>의 차이는 무엇인가?
  - IntStream은 primitive 타입인 int 타입을 요소로 갖는 stream이다.
  - Stream<Integer>는 wrapper 클래스인 Integer 타입을 요소로 갖는 stream이다.
- Stream<Integer>에서 흔히 사용했던 mapToInt() 메서드는
  Stream<wrapper 클래스>을 IntStream으로 변환하는 메서드였던 것.
- primitive 타입 Stream과 객체 타입을 요소로 갖는 Stream의 메서드에는 차이가 있음.
  - range(), sum() 등의 일부 메서드는 primitive 타입 Stream에만 존재.
  - Stream<T>에서는 reduce()로 대신할 수 있음.


- https://www.baeldung.com/java-stream-operated-upon-or-closed-exception
- Stream 컬렉션은 단 한번만 소비될 수 있고, 한 번의 소비가 수행되면 닫힌다.
  - 한 번 소비된 Stream을 다시 수행하려고 시도하는 경우
    'stream has already been operated upon or closed'
    메시지와 함께 IllegalStateException이 발생.
  - 일반적인 메서드 체이닝 상황에서는 쉽게 발생할 일은 없겠지만,
    Stream.of() 계열의 메서드를 이용해 Stream 객체를 직접 생성할 경우
    이미 소비된 Stream 인스턴스에 다시 접근하려 하는 문제가 발생할 수도 있음.
  - 동일한 Stream을 반복해서 생성해야 하는 상황이 있다면 Supplier 객체를 이용하는 것도 방법.
  - Supplier<T> 객체의 get() 메서드를 통해
    Supplier<T> 객체 인스턴스에 정의된 함수가 반환하는 T 타입 객체 인스턴스를 반환받을 수 있음.
  ```Java
  Supplier<IntStream> supplier = () -> IntStream.of(9, 99, 999, 9999);
  IntStream stream = supplier.get();
  ```