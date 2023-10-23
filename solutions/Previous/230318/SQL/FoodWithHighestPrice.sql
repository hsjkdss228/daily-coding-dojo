/* 가격이 제일 비싼 식품의 정보 출력하기
   https://school.programmers.co.kr/learn/courses/30/lessons/131115
*/

SELECT *
FROM food_product
ORDER BY price DESC LIMIT 1

# LIMIT 예약어를 이용해 ORDER BY 절에서 지정한 조건에 해당하는 결과에서
# 출력할 결과의 양을 조정할 수 있다.
