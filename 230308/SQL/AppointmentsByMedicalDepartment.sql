/* 진료과별 총 예약 횟수 출력하기
   https://school.programmers.co.kr/learn/courses/30/lessons/132202
*/

SELECT
    mcdp_cd AS '진료과코드',
    COUNT(*) AS '5월예약건수'
FROM appointment
WHERE DATE_FORMAT(apnt_ymd, '%Y-%m') = '2022-05'
GROUP BY mcdp_cd
ORDER BY COUNT(*) ASC, mcdp_cd ASC

# SELECT문에 집계함수(SUM, COUNT 등)가 사용된 경우
# 위의 구문처럼 해당 column에 사용된 집계함수를 기준으로도 정렬이 가능하다.
