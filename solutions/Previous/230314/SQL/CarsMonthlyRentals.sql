/* 대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/151139
*/

SELECT
    MONTH(start_date) AS month,
    car_id,
    COUNT(*) AS records
FROM car_rental_company_rental_history
WHERE MONTH(start_date) BETWEEN 8 AND 10
    AND car_id IN (
        SELECT car_id
        FROM car_rental_company_rental_history
        WHERE MONTH(start_date) BETWEEN 8 AND 10
        GROUP BY car_id
        HAVING COUNT(*) >= 5
    )
GROUP BY MONTH(start_date), car_id
HAVING records > 0
ORDER BY MONTH(start_date) ASC, car_id DESC

# WHERE문에서 다음의 형태들로 조건을 지정할 수 있다.
# 'WHERE column BETWEEN value1 AND value2'
# 'WHERE column IN conditions'

# 해당 문제는 서브쿼리문에서 8~10월 사이의 월간 대여 수 합이 5 이상인 car_id들을 선별해
# 선별된 car_id와 월을 묶어 그룹화한다.
