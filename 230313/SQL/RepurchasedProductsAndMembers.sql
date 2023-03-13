/* 재구매가 일어난 상품과 회원 리스트 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/131536
*/

SELECT
    user_id,
    product_id
FROM online_sale
GROUP BY user_id, product_id
HAVING COUNT(user_id) >= 2
ORDER BY user_id ASC, product_id DESC
