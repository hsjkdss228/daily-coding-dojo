/*
 *  자동차 대여 기록에서 대여중/대여 가능 여부 구분하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/151139
 */

-- [풀이 1]
SELECT
    DISTINCT car_id,
    CASE
        WHEN car_id IN (
            SELECT
                car_id
            FROM
                car_rental_company_rental_history history
            WHERE
                start_date <= '2022-10-16' AND end_date >= '2022-10-16'
        ) THEN '대여중'
        ELSE '대여 가능'
    END availability
FROM
    car_rental_company_rental_history history
ORDER BY
    history.car_id DESC
;

-- SELECT 절에서도 IN subquery 구문을 사용할 수 있다.
-- 단, CTE에 쿼리를 작성한 뒤 CTE 테이블명을 직접 가져다쓰는 방식은 지원하지 않으므로 서브쿼리를 직접 작성해야 한다.
-- (ex. WHEN car_id IN rent_cars와 같은 방식으로는 작성할 수 없다.)

-- [풀이 2]
WITH rent_cars AS (
    SELECT
        car_id
    FROM
        car_rental_company_rental_history history
    WHERE
        start_date <= '2022-10-16' AND end_date >= '2022-10-16'
)
SELECT
    DISTINCT history.car_id,
    CASE
        WHEN rent_cars.car_id IS NOT NULL THEN '대여중'
        ELSE '대여 가능'
    END availability
FROM
    car_rental_company_rental_history history LEFT JOIN rent_cars
        ON history.car_id = rent_cars.car_id
ORDER BY
    history.car_id DESC
;

-- LEFT JOIN은 조건에 일치하지 않더라도 기준 테이블의 row는 모두 포함한다.
-- 따라서 '2022-10-16'에 대여 기록이 없어 rent_cars.car_id에 JOIN 조건을 만족하는 row가 없으면
-- 결과 테이블의 rent_cars.car_id column에는 NULL 값이 남게 된다.
-- 이를 통해 대여 기록이 없는 car_id를 식별할 수 있다.
