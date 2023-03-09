/* 가격대 별 상품 개수 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/131530
*/

SELECT
    TRUNCATE(price, -4) AS price_group,
    COUNT(*) AS products
FROM product
GROUP BY price_group
ORDER BY price_group ASC

# TRUNCATE() 함수는 특정 column의 요소의 특정 자리수 이하를 0으로 바꾼다.
# ex1. TRUNCATE(21000, -4) == 20000
# ex2. TRUNCATE(2000, -4) == 0

# 해당 문제는 price column 요소들의 1000의 자리 이하를 0으로 바꿔
# column의 모든 요소들이 만 단위의 숫자가 되도록 한다.
# 이후 price_group을 기준으로 요소들을 그룹화해 column의 수를 카운트한다.
