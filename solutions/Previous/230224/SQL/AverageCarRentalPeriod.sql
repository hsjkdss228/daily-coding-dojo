/* 자동차 평균 대여 기간 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/157342
*/

SELECT car_id, ROUND(AVG(DATEDIFF(end_date, start_date) + 1), 1) AS average_duration
FROM car_rental_company_rental_history
GROUP BY car_id
HAVING average_duration >= 7
ORDER BY average_duration DESC, car_id DESC

# DATEDIFF는 두 날짜의 차이를 계산해 결과를 정수로 반환한다.
# 예를 들어, DATEDIFF('2022-08-16', '2022-08-09')의 결과는 7이다.
# DATEDIFF를 사용해 본 문제를 해결하는 경우, 문제에서 제시하는 평균 대여 기간에
# start_date의 날짜와 end_date의 날짜를 모두 포함시켜야 하므로
# DATEDIFF(end_date, start_date)의 결과에 +1을 더한 결과를 이용해야 한다.
