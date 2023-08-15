/*
 *  없어진 기록 찾기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/59042
 */

-- [풀이 1]
SELECT
    outs.animal_id,
    outs.name
FROM
    animal_ins ins RIGHT JOIN animal_outs outs
        ON ins.animal_id = outs.animal_id
WHERE
    ins.animal_id IS NULL
ORDER BY
    outs.animal_id ASC
;

-- 특정 Column의 요소가 NULL인지 확인할 때는 '= NULL'이 아니라
-- 'IS NULL'을 사용한다.

-- [풀이 2]
SELECT
    outs.animal_id,
    outs.name
FROM
    animal_ins ins RIGHT JOIN animal_outs outs
        ON ins.animal_id = outs.animal_id
GROUP BY
    ins.animal_id, outs.animal_id
HAVING
    COUNT(ins.animal_id) = 0
ORDER BY
    outs.animal_id ASC
;
