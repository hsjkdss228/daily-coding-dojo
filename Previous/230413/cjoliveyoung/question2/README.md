# 💡 How to solve it?
> 문제를 풀기 전에 어떻게 풀 것인지 먼저 생각을 정리하고, 다 풀고 나서 회고한다.

## 2번

> 2023년 상반기 CJ올리브영 백엔드 개발 직무 TEST

- 한국 주식의 종목명을 담은 문자열 배열 stocksOfKorea,
- 미국 주식의 종목명을 담은 문자열 배열 stocksOfUsa,
- 각 일별 상승한 종목들을 담은 문자열 배열 stocksRisings가 매개변수로 주어질 때,
- 동반 상승한 일자가 가장 많은 \<한국 주식, 미국 주식\> 쌍이 동반 상승한 일자를 return한다.
- 한국 주식과 미국 주식이 동시에 상승한 날이 하루도 없다면 0을 return한다.

### 23.4.12

#### 1. 이해

1. 주어진 조건은 무엇인가?
   1. 규칙
      - 예를 들어서 한국 주식이 ["BCD", "AAA"],
      - 미국 주식이 ["AA"],
      - 주식 상승은 ["BCD AA AAA", "BCD AA", "BCD AAA"] 이렇게 이루어졌다면,
      - \<한국 주식, 미국 주식\> 형태로 쌍을 이룬다고 할 때
      - 첫 날에는 \<BCD, AA\>, \<AAA, AA\> 쌍이 동반 상승
      - 둘째 날에는 \<BCD, AA\> 쌍이 동반 상승
      - 셋째 날에는 동반 상승한 쌍은 없음
      - 즉 가장 많이 동반 상승한 쌍인 \<BCD, AA\>의 상승 횟수인 2가 정답
   2. 제한사항
      - stocksOfKorea, stocksOfUsa의 크기: 1 이상 100,000 이하
      - stocksRising에는 종목들이 공백으로 구분되어 담겨 있음
   3. 추론
      - 주어지는 한국 주식, 미국 주식의 값이 크기 때문에
        특정 주식이 한국 주식인지, 미국 주식인지는 한 번에 찾을 수 있어야 함 -> Map

2. 내가 이용할 수 있는 것은 무엇인가?
   - 한국 주식의 종류
   - 미국 주식의 종류
   - 각 일자별 상승한 주식들

3. 내가 모르는 건 무엇인가?
   - 일단 모두 파악?

#### 2. 계획

##### 최초 풀이

1. 객체 정의
   - RisingPair
     - 멤버
       - nameOfKorea
       - nameOfUsa
     - equals
       - nameOfKorea, nameOfUsa가 모두 같을 경우
2. Set 정의
   - stocksOfKorea, Usa: Set<String>
   - 각 문자열 배열들을 모두 Set에 삽입
3. Map 정의
   - RisingPairsAndCounts: Set<RisingPair, Integer>
4. stocksRisings을 순회: stocksRising
   - stocksRising을 split
   - 한국 것인지, 미국 것인지 Set을 이용해 판별해 쌍을 생성
     - 한국 risingStocks와 미국 risingStocks를 만들고, 이들을 2중 반복으로 돌면서 쌍을 생성
   - RisingPairsAndCounts에 삽입
5. RisingPairsAndCounts의 entrySet을 순회하면서
   가장 높은 value값을 return

#### 3. 실행

- 이해/계획: 17:00-17:35
- 풀이: 17:40-18:00

#### 4. 반성

- 테스트는 모두 통과.
- IDE에서 테스트 환경으로 복붙이 안되서 따라 치는데만 20분이 걸렸다...
