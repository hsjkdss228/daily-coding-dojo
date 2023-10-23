/* 카테고리 별 상품 개수 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/131529
*/

SELECT
    SUBSTRING(product_code, 1, 2) AS category,
    COUNT(*) AS products
FROM product
GROUP BY category
ORDER BY category ASC

# 특정 column 문자열 값의 일부분을 자르기 위해 다음의 함수들을 사용할 수 있다.
# SUBSTRING(column, 시작 index, 잘라낼 영역의 길이)
# LEFT(column, 문자열의 가장 왼쪽 문자로부터 잘라낼 영역의 길이)
# RIGHT(column, 문자열의 가장 오른쪽 문자로부터 잘라낼 영역의 길이)
# https://gent.tistory.com/436

# SELECT 문에서 AS로 별칭을 지정한 구문을
# GROUP BY, ORDER BY 문에서 참조할 수 있다.
