/*
 *  오랜 기간 보호한 동물(1)
 *  https://school.programmers.co.kr/learn/courses/30/lessons/59044
 */

SELECT
    ins.name,
    ins.datetime datetime
FROM
    animal_ins ins LEFT JOIN animal_outs outs
        ON ins.animal_id = outs.animal_id
WHERE
    outs.datetime IS NULL
ORDER BY
    ins.datetime ASC
LIMIT 3;
