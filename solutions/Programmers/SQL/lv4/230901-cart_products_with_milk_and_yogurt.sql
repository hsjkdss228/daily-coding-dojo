/*
 *  우유와 요거트가 담긴 장바구니
 *  https://school.programmers.co.kr/learn/courses/30/lessons/62284
 */

WITH carts_with_milk AS (
    SELECT
        DISTINCT cart_id
    FROM
        cart_products
    WHERE
        name = 'Milk'
), carts_with_yogurt AS (
    SELECT
        DISTINCT cart_id
    FROM
        cart_products
    WHERE
        name = 'Yogurt'
)
SELECT
    products.cart_id
FROM
    cart_products products LEFT JOIN carts_with_milk milks
        ON products.cart_id = milks.cart_id
    LEFT JOIN carts_with_yogurt yogurts
        ON products.cart_id = yogurts.cart_id
WHERE
    milks.cart_id IS NOT NULL
        AND yogurts.cart_id IS NOT NULL
GROUP BY
    cart_id
ORDER BY
    cart_id ASC
;
