/*
 *  5월 식품들의 총매출 조회하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/131117
 */

SELECT
    products.product_id product_id,
    products.product_name product_name,
    SUM(products.price * orders.amount) total_sales
FROM
    food_product products INNER JOIN food_order orders
        ON products.product_id = orders.product_id
WHERE
    orders.produce_date BETWEEN '2022-05-01' AND '2022-05-31'
GROUP BY
    product_name
ORDER BY
    total_sales DESC,
    product_id ASC
;
