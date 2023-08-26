/*
 *  즐겨찾기가 가장 많은 식당 정보 출력하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/131123
 */

-- [풀이 1]
SELECT
    food_type,
    rest_id,
    rest_name,
    favorites
FROM
    rest_info
WHERE
    favorites IN (
        SELECT
            MAX(favorites)
        FROM
            rest_info
        GROUP BY
            food_type
    )
GROUP BY
    food_type
ORDER BY
    food_type DESC;

-- [풀이 2]
WITH types_top_favorites AS (
    SELECT
        food_type,
        MAX(favorites) top_favorites
    FROM
        rest_info
    GROUP BY
        food_type
)
SELECT
    rest_info.food_type,
    rest_info.rest_id,
    rest_info.rest_name,
    rest_info.favorites
FROM
    rest_info INNER JOIN types_top_favorites
        ON rest_info.food_type = types_top_favorites.food_type
        AND rest_info.favorites = types_top_favorites.top_favorites
ORDER BY
    food_type DESC
;

-- https://learnsql.com/blog/inline-query-in-sql/
-- 서브쿼리 (Subquery) vs 인라인 뷰 (Inline View)
-- FROM 절에서 사용되는 인라인 쿼리는 인라인 뷰,
-- FROM 절 이외의 SELECT 절, WHERE 절 등지에서 사용되는 인라인 쿼리는 서브쿼리.
-- 두 개념 간의 동작 원리와 관련된 차이를 찾아보았으나 명확하지 않았다.
-- 일단은 사용처에 따라 이름을 구분한다는 것까지만 확인.
