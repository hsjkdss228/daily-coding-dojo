/* 자동차 대여 기록에서 대여중/대여 가능 여부 구분하기
   https://school.programmers.co.kr/learn/courses/30/lessons/157340
*/

SELECT
    car_id,
    CASE
        WHEN EXISTS(
            SELECT *
            FROM car_rental_company_rental_history AS sub
            WHERE sub.car_id = main.car_id
                AND start_date <= '2022-10-16'
                AND end_date >= '2022-10-16'
        ) THEN '대여중'
        ELSE '대여 가능'
        END AS availability
FROM car_rental_company_rental_history AS main
GROUP BY car_id
ORDER BY car_id DESC

# 동일한 Table에 대해 서브쿼리를 수행하는 쿼리문 내에서
# 서브쿼리 내에서 특정 row를 참조하고자 할 경우,
# 각 쿼리문에서 참조하는 Table에 별칭을 부여한 뒤
# 두 Table의 row의 식별자를 비교하는 방식으로 특정 row를 지정할 수 있다.

# GROUP BY는 특정 column 내에서 동일한 값을 갖는 row들을 그룹화해 하나의 row로 표현한다.
