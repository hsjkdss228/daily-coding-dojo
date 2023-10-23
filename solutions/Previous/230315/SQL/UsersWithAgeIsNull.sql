/* 나이 정보가 없는 회원 수 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/131528
*/

SELECT COUNT(*) AS users
FROM user_info
WHERE age IS NULL
