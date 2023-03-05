/* 자동차 대여 기록에서 장기/단기 대여 구분하기
   https://school.programmers.co.kr/learn/courses/30/lessons/151138
*/

SELECT
    history_id,
    car_id,
    DATE_FORMAT(start_date, '%Y-%m-%d') AS start_date,
    DATE_FORMAT(end_date, '%Y-%m-%d') AS end_date,
    CASE
        WHEN DATEDIFF(end_date, start_date) + 1 >= 30 THEN '장기 대여'
        ELSE '단기 대여'
        END AS rent_type
FROM car_rental_company_rental_history
WHERE start_date >= '2022-09-01' AND start_date <= '2022-09-30'
ORDER BY history_id DESC

# '*'만을 사용해 모든 column의 데이터를 조회할 때는
# DATE 타입 column의 출력 양식을 지정할 수 없다.
# 별도의 추가 column 없이 모든 column을 출력하는 경우라 하더라도
# DATE 타입 column의 출력 양식을 지정해주기 위해서는 DATE_FORMAT()의 인자에
# 해당 column을 전달해야 한다.
