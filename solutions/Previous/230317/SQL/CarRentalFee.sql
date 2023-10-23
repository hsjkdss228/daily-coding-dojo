/* 특정 기간 동안 대여 가능한 자동차들의 대여비용 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/157339
*/

# 세단 또는 SUV
# 2022-11-01부터 2022-11-30까지 대여 가능
# 30일 간 대여 금액 50만원 이상 200만원 미만

# 자동차 ID, 자동차 종류, 대여 금액 출력

# 대여 금액 기준 내림차순 정렬
# 대여 금액이 같은 경우 자동차 종류 기준 오름차순 정렬
# 자동차 종류가 같은 경우 자동차 ID 기준 내림차순 정렬

SELECT
    car.car_id AS car_id,
    car.car_type AS car_type,
    ROUND(daily_fee * (100 - discount_rate) / 100) * 30 AS fee
FROM
    car_rental_company_car AS car
    RIGHT JOIN car_rental_company_rental_history AS history
        ON car.car_id = history.car_id
    LEFT JOIN car_rental_company_discount_plan AS discount_plan
        ON car.car_type = discount_plan.car_type
        AND discount_plan.duration_type LIKE '30일 이상'
WHERE
    car.car_type IN ('세단', 'SUV')
    AND car.car_id NOT IN (
        SELECT car_id
        FROM car_rental_company_rental_history
        WHERE
            start_date BETWEEN '2022-11-01' AND '2022-11-30'
            OR (start_date <= '2022-10-31'
                AND end_date >= '2022-11-01')
    )
    AND ROUND(daily_fee * (100 - discount_rate) / 100) * 30 >= 500000
    AND ROUND(daily_fee * (100 - discount_rate) / 100) * 30 <= 2000000
GROUP BY
    car_id
ORDER BY
    fee DESC,
    car_type ASC,
    car_id DESC

# 11월 1일부터 11월 30일까지 대여가 불가능한 경우
# - 대여일이 11월 1일 이후인 경우
# - 대여일이 11월 1일 이전이고 반납일이 11월 1일 이후인 경우
# 위의 경우를 제외한 날짜에 해당되는 경우를 조회한다.

# 특정 카테고리의 한 column이 특정 조건을 만족할 때 그 조건을 포함하는 카테고리 전체를 포함시키지 않고 싶은 경우,
# WHERE NOT IN 조건에 서브쿼리문의 결과를 전달하는 방식이 있다.
# 예시에서는 11월 1일부터 11월 30일까지의 기간 동안 대여가 불가능한 차량의 id를 조회해
# 서브쿼리로 전달하고, 해당 차량 id는 결과에서 제외시킨다.

# 2개 이상의 테이블을 JOIN할 수 있다.
