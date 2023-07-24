/*
 *  자동차 대여 기록 별 대여 금액 구하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/151141
 */

-- 참고한 풀이: https://velog.io/@glad415/MySQL-%EC%9E%90%EB%8F%99%EC%B0%A8-%EB%8C%80%EC%97%AC-%EA%B8%B0%EB%A1%9D-%EB%B3%84-%EB%8C%80%EC%97%AC-%EA%B8%88%EC%95%A1-%EA%B5%AC%ED%95%98%EA%B8%B0
-- 풀이 접근법
-- 1. 특정 대여 기록에 대해 대여 기간 종류를 미리 선택한 테이블을 만든다. (이때 DURATION_TYPE에 일치시킬 column을 생성해둬야 한다!)
-- 2. 요금 테이블과 비교해 계산한다.

WITH rental_history_with_duration_type AS (
    SELECT
        history_id,
        car_type,
        daily_fee,
        CASE
            WHEN DATEDIFF(end_date, start_date) + 1 >= 90 THEN '90일 이상'
            WHEN DATEDIFF(end_date, start_date) + 1 >= 30 THEN '30일 이상'
            WHEN DATEDIFF(end_date, start_date) + 1 >= 7 THEN '7일 이상'
            ELSE 'NONE'
        END AS duration_type,
        DATEDIFF(end_date, start_date) + 1 AS duration
    FROM
        car_rental_company_car
            RIGHT JOIN car_rental_company_rental_history
                ON car_rental_company_car.car_id = car_rental_company_rental_history.car_id
    WHERE
        car_rental_company_car.car_type = '트럭'
)

SELECT
    history_id,
    (
        ROUND((daily_fee - (daily_fee * IFNULL(discount_rate, 0) / 100)) * duration)
    ) AS fee
FROM
    rental_history_with_duration_type
        LEFT JOIN car_rental_company_discount_plan
            ON rental_history_with_duration_type.car_type = car_rental_company_discount_plan.car_type
            AND rental_history_with_duration_type.duration_type = car_rental_company_discount_plan.duration_type
ORDER BY
    fee DESC,
    history_id DESC;

-- WITH table_name AS (
--    서브쿼리
-- ): 서브쿼리를 별도의 구문으로 분리할 수 있다.

-- DATEDIFF(뒷 날짜, 앞 날짜): 뒷 날짜 - 앞 날짜의 값을 계산
-- ex. DATEDIFF('2022-08-04', '2022-08-03') = 1
-- 본 문제에서는 대여 당일, 반납 당일까지 포함시켜야 하므로
-- 대여 기간을 계산할 목적으로 사용하기 위해서는 DATEDIFF() + 1을 해줘야 한다.

-- SUBSTRING: SUBSTRING(대상 요소, 시작 위치, 종료 위치 + 1)
-- cf. SQL 문자열의 index는 1부터 시작!!!
-- ex. '15%'에서 '%'를 제거하고 싶다면
-- SUBSTRING('15%', 1, LENGTH('15%'))
-- LENGTH('15%') = 3이므로, '15%'의 1-2 index에 해당되는 문자인 '15'를 반환

-- 기준 쿼리문에서는 JOIN 시, rental_history_with_duration_type을 기준으로 LEFT JOIN을 해줘야
-- 일치하는 duration_type이 존재하지 않는(할인율이 적용되지 않는) tuple도 결과 테이블에 도출될 수 있다.
-- 그러면 사용할 discount_rate 값이 없을 텐데, IFNULL(discount_rate, 0)을 부여해서
-- discount_rate 값이 없으면 할인을 적용하지 않도록 풀이할 수 있다.

-- SQL 문제를 풀 때는 문제 예시를 그대로 믿지 말고, 테이블 설명란의 Type을 기준으로 이해하도록 하자.
-- 본 문제의 discount_rate는 예시에서는 '15%', '20%' 이런 식으로 VARCHAR처럼 제시해줬지만, Type은 INTEGER였기 때문이다.
-- 굳이 해도 되지 않는 문자열 파싱 때문에 쿼리문도 길어지고, 길어진 쿼리문을 파악하느라 시간을 많이 썼다.
