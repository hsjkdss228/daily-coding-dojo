/*
 *  대여 기록이 존재하는 자동차 리스트 구하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/157341
 */

-- [풀이 1]
WITH october_rentals AS (
    SELECT
        car_id
    FROM
        car_rental_company_rental_history histories
    WHERE
        histories.start_date BETWEEN '2022-10-01' AND '2022-10-31'
)
SELECT
    cars.car_id
FROM
    car_rental_company_car cars RIGHT JOIN october_rentals
        ON cars.car_id = october_rentals.car_id
WHERE
    car_type = '세단'
GROUP BY
    car_id
ORDER BY
    car_id DESC
;

-- [풀이 2]
SELECT
    DISTINCT cars.car_id
FROM
    car_rental_company_car cars
    INNER JOIN car_rental_company_rental_history histories
        ON cars.car_id = histories.car_id
WHERE
    cars.car_type = '세단'
    AND histories.start_date BETWEEN '2022-10-01' AND '2022-10-31'
ORDER BY
    car_id DESC
;

-- GROUP BY, ORDER BY는 SELECT로 조회된 Column에 대해 수행한다.
-- 따라서 FROM 절의 테이블의 Column명을 직접 지정하는 것뿐만 아니라
-- SELECT 절에 조회된 Column 별칭을 지정할 수도 있다.
