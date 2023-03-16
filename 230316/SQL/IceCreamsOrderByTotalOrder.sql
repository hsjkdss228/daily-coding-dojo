/* 인기있는 아이스크림
   https://school.programmers.co.kr/learn/courses/30/lessons/133024
*/

SELECT flavor
FROM first_half
ORDER BY total_order DESC, shipment_id ASC
