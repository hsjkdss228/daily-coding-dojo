/* 평균 일일 대여 요금 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/151136
*/

SELECT ROUND(AVG(daily_fee), 0) AS average_fee
FROM car_rental_company_car
GROUP BY car_type
HAVING car_type = 'SUV'
