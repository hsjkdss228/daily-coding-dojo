/*
 *  헤비 유저가 소유한 장소
 *  https://school.programmers.co.kr/learn/courses/30/lessons/77487
 */

SELECT
    id,
    name,
    host_id
FROM
    places
WHERE
    host_id IN (
        SELECT
            host_id
        FROM
            places
        GROUP BY
            host_id
        HAVING
            COUNT(*) >= 2
    )
ORDER BY
    id ASC
;
