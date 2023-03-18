/* 3월에 태어난 여성 회원 목록 출력하기
   https://school.programmers.co.kr/learn/courses/30/lessons/131120
*/

SELECT
    member_id,
    member_name,
    gender,
    DATE_FORMAT(date_of_birth, '%Y-%m-%d') AS date_of_birth
FROM member_profile
WHERE
    MONTH(date_of_birth) = '03'
    AND gender LIKE 'W'
    AND tlno IS NOT NULL
ORDER BY member_id ASC
