/* 과일로 만든 아이스크림 고르기
   https://school.programmers.co.kr/learn/courses/30/lessons/133025
*/

SELECT first_half.flavor
FROM first_half LEFT JOIN icecream_info
    ON first_half.flavor = icecream_info.flavor
WHERE total_order >= 3000
    AND ingredient_type LIKE 'fruit_based'
ORDER BY total_order DESC
