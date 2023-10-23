/* 자동차 종류 별 특정 옵션이 포함된 자동차 수 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/151137
*/

SELECT
    car_type,
    COUNT(*) AS cars
FROM car_rental_company_car
WHERE options LIKE '%통풍시트%'
    OR options LIKE '%열선시트%'
    OR options LIKE '%가죽시트%'
GROUP BY car_type
ORDER BY car_type ASC

# HAVING은 SELECT 절에서 조회하고 있는 column에 대해서만
# column을 지정하고 조건을 검사할 수 있다.
# 해당 문제 같은 경우에는 WHERE 절에서 조건 검사를 수행할 수 있다.
