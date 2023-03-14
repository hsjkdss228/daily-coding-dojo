/* 대여 기록이 존재하는 자동차 리스트 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/157341
*/

SELECT car_rental_company_car.car_id
FROM car_rental_company_car RIGHT JOIN (
    SELECT
        car_id,
        start_date
    FROM car_rental_company_rental_history
    WHERE DATE_FORMAT(start_date, '%m') = '10'
) AS car_rental_history_in_oct
    ON car_rental_company_car.car_id = car_rental_history_in_oct.car_id
WHERE car_type LIKE '세단'
GROUP BY car_id
ORDER BY car_id DESC
