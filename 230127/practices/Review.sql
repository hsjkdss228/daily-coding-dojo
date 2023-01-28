/* 모든 레코드 조회하기
   https://school.programmers.co.kr/learn/courses/30/lessons/59034
*/
SELECT *
FROM animal_ins
ORDER BY animal_id ASC

/* 최댓값 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/59415
*/
SELECT max(datetime) AS recent
FROM animal_ins

/* 역순 정렬하기
   https://school.programmers.co.kr/learn/courses/30/lessons/59035
*/
SELECT name, datetime
FROM animal_ins
ORDER BY animal_id DESC

/* 이름이 없는 동물의 아이디
   https://school.programmers.co.kr/learn/courses/30/lessons/59039
*/
SELECT animal_id
FROM animal_ins
WHERE name IS NULL

/* 상위 n개 레코드
   https://school.programmers.co.kr/learn/courses/30/lessons/59405
*/
SELECT name
FROM animal_ins
ORDER BY datetime ASC
LIMIT 1

/* 동물의 아이디와 이름
   https://school.programmers.co.kr/learn/courses/30/lessons/59403
*/
SELECT animal_id, name
FROM animal_ins
ORDER BY animal_id ASC

/* 아픈 동물 찾기
   https://school.programmers.co.kr/learn/courses/30/lessons/59036
*/
SELECT animal_id, name
FROM animal_ins
WHERE intake_condition = 'Sick'

/* 어린 동물 찾기
   https://school.programmers.co.kr/learn/courses/30/lessons/59037
*/
SELECT animal_id, name
FROM animal_ins
WHERE intake_condition != 'Aged'

/* 이름이 있는 동물의 아이디
   https://school.programmers.co.kr/learn/courses/30/lessons/59407
*/
SELECT animal_id
FROM animal_ins
WHERE name IS NOT NULL
ORDER BY animal_id asc

/* 여러 기준으로 정렬하기
   https://school.programmers.co.kr/learn/courses/30/lessons/59404
*/
SELECT animal_id, name, datetime
FROM animal_ins
ORDER BY
    name ASC,
    datetime DESC

/* 동물 수 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/59406
*/
SELECT count(*) AS count
FROM animal_ins

/* 고양이와 개는 몇 마리 있을까
   https://school.programmers.co.kr/learn/courses/30/lessons/59040
*/
SELECT animal_type, count(animal_type) AS count
FROM animal_ins
GROUP BY animal_type
ORDER BY animal_type ASC

/* 동명 동물 수 찾기
   https://school.programmers.co.kr/learn/courses/30/lessons/59041
*/
SELECT name, count(*) AS count
FROM animal_ins
WHERE name IS NOT NULL
GROUP BY name
    HAVING count(*) >= 2
ORDER BY name ASC

/* NULL 처리하기
   https://school.programmers.co.kr/learn/courses/30/lessons/59410
*/
SELECT
    animal_type,
    CASE
        WHEN name IS NULL THEN 'No name'
        ELSE name
        END AS name,
    sex_upon_intake
FROM animal_ins

/* 있었는데요 없었습니다
   https://school.programmers.co.kr/learn/courses/30/lessons/59043
*/

-- Solution 1: LEFT JOIN
SELECT animal_id, name
FROM (
    SELECT
        ins.animal_id AS animal_id,
        ins.name AS name,
        ins.datetime AS ins_datetime,
        outs.datetime AS outs_datetime
    FROM
        animal_ins AS ins
        LEFT JOIN animal_outs AS outs
        ON ins.animal_id = outs.animal_id
) animal_ins_outs
WHERE ins_datetime > outs_datetime
ORDER BY ins_datetime ASC

-- Solution 2: WHERE EXISTS
SELECT animal_id, name
FROM animal_ins AS ins
WHERE EXISTS (
    SELECT animal_id
    FROM animal_outs AS outs
    WHERE ins.animal_id = outs.animal_id
        && ins.datetime > outs.datetime
)
ORDER BY datetime ASC
