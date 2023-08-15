/*
 *  입양 시각 구하기(2)
 *  https://school.programmers.co.kr/learn/courses/30/lessons/59413
 */

-- 다음 풀이는 HOUR(datetime) 결과가 없는 시간에 대해서는
-- 해당 시간의 hour가 생성되지 않아 오답.
-- GROUP BY 상에서 아예 집계되지 않기 때문.
SELECT
    HOUR(datetime) hour,
    COUNT(datetime) count
FROM
    animal_outs outs
GROUP BY
    HOUR(datetime)
ORDER BY
    hour ASC
;

-- [풀이 1]
SET @hour = -1;
SELECT
    (@hour := @hour + 1) hour,
    (
        SELECT
            COUNT(HOUR(datetime))
        FROM
            animal_outs outs
        WHERE
            HOUR(datetime) = @hour
    ) count
FROM
    animal_outs outs
WHERE
    @hour < 23
;

-- https://three-pleasure.tistory.com/256
-- 사용자 정의 변수
-- 변수를 정의해 사용할 수 있다.
-- MySQL에서의 대입 연산자는 ':='

-- [풀이 2]
WITH RECURSIVE hours AS (
    SELECT
        0 hour
    UNION ALL
    SELECT
        hour + 1
    FROM
        hours
    WHERE
        hour < 23
)
SELECT
    hours.hour,
    COUNT(outs.datetime) count
FROM
    animal_outs outs RIGHT JOIN hours
        ON HOUR(outs.datetime) = hours.hour
GROUP BY
    hours.hour
ORDER BY
    hours.hour ASC
;

-- https://horang98.tistory.com/10
-- Common Table Expression (CTE)
-- WITH 구문을 활용해 메모리 상에 임시 테이블을 생성하고
-- 해당 테이블을 쿼리에 활용할 수 있다.

-- https://sowon-dev.github.io/2021/10/18/211019SQL-unionall/
-- UNION, UNION ALL
-- 동일한 Column을 가진 두 개의 테이블을 합칠 수 있다.
-- 이때 UNION은 중복 데이터를 제거하고,
-- UNION ALL은 중복 데이터를 제거하지 않는다.
