/*
 *  대여 횟수가 많은 자동차들의 월별 대여 횟수 구하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/151139
 */

WITH car_ids_more_5_rentals AS (
    SELECT
        car_id
    FROM
        car_rental_company_rental_history history
    WHERE
        start_date BETWEEN '2022-08-01' AND '2022-10-31'
    GROUP BY
        car_id
    HAVING
        COUNT(*) >= 5
)
SELECT
    MONTH(history.start_date) month,
    history.car_id car_id,
    COUNT(*) records
FROM
    car_rental_company_rental_history history INNER JOIN car_ids_more_5_rentals car_ids
        ON history.car_id = car_ids.car_id
WHERE
    start_date BETWEEN '2022-08-01' AND '2022-10-31'
GROUP BY
    MONTH(history.start_date),
    history.car_id
ORDER BY
    month ASC,
    history.car_id DESC
;
