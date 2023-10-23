/*
 *  식품분류별 가장 비싼 식품의 정보 조회하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/131116
 */

WITH max_prices AS (
    SELECT
        category,
        MAX(price) max_price
    FROM
        food_product
    WHERE
        category IN ('과자', '국', '김치', '식용유')
    GROUP BY
        category
)
SELECT
    products.category,
    max_prices.max_price,
    products.product_name
FROM
    food_product products INNER JOIN max_prices
        ON products.category = max_prices.category
        AND products.price = max_prices.max_price
ORDER BY
    max_price ASC
;
