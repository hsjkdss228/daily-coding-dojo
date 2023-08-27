/*
 *  오프라인/온라인 판매 데이터 통합하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/131537
 */

WITH sales AS (
    SELECT
        sales_date,
        product_id,
        user_id,
        sales_amount
    FROM
        online_sale
    WHERE
        sales_date BETWEEN '2022-03-01' AND '2022-03-31'
    UNION ALL
    SELECT
        sales_date,
        product_id,
        NULL user_id,
        sales_amount
    FROM
        offline_sale
    WHERE
        sales_date BETWEEN '2022-03-01' AND '2022-03-31'
)
SELECT
    DATE_FORMAT(sales_date, '%Y-%m-%d') sales_date,
    product_id,
    user_id,
    sales_amount
FROM
    sales
ORDER BY
    sales_date ASC,
    product_id ASC,
    user_id ASC
;
