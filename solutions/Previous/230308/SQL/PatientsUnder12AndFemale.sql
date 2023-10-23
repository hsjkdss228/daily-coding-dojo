/* 12세 이하인 여자 환자 목록 출력하기
   https://school.programmers.co.kr/learn/courses/30/lessons/132201
*/

SELECT
    pt_name,
    pt_no,
    gend_cd,
    age,
    IFNULL(tlno, 'NONE') AS tlno
FROM patient
WHERE age <= 12 AND gend_cd = 'W'
ORDER BY age DESC, pt_name ASC

# IFNULL(요소1, 요소2)는 요소1이 NULL이 아닌 경우 요소1을,
# NULL인 경우 요소2를 반환한다.
# 즉 다음과 동일한 동작을 수행한다.
# CASE
#     WHEN tlno IS NULL THEN 'NONE'
#     ELSE tlno
#     END AS tlno
