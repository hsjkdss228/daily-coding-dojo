/*
 *  주문량이 많은 아이스크림들 조회하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/133027
 */

-- [풀이 1]
SELECT
    july.flavor
FROM
    first_half INNER JOIN july
        ON first_half.flavor = july.flavor
GROUP BY
    july.flavor
ORDER BY
    first_half.total_order + SUM(july.total_order) DESC
LIMIT 3;

-- [풀이 2]
WITH sums AS(
    SELECT
        flavor,
        SUM(total_order) total_order_sum
    FROM
        first_half
    GROUP BY
        flavor
    UNION ALL
    SELECT
        flavor,
        SUM(total_order) total_order_sum
    FROM
        july
    GROUP BY
        flavor
)
SELECT
    flavor
FROM
    sums
GROUP BY
    flavor
ORDER BY
    SUM(total_order_sum) DESC
LIMIT 3;
