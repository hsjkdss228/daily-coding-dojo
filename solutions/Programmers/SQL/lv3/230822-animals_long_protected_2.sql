/*
 *  오랜 기간 보호한 동물(2)
 *  https://school.programmers.co.kr/learn/courses/30/lessons/59411
 */

SELECT
    ins.animal_id animal_id,
    ins.name name
FROM
    animal_ins ins INNER JOIN animal_outs outs
        ON ins.animal_id = outs.animal_id
ORDER BY
    DATEDIFF(outs.datetime, ins.datetime) DESC
LIMIT 2;
