/* 상품 별 오프라인 매출 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/131533
*/

SELECT
    product_code,
    SUM(price * sales_amount) AS sales
FROM product RIGHT JOIN offline_sale
    ON product.product_id = offline_sale.product_id
GROUP BY product_code
ORDER BY sales DESC, product_code ASC

# product 테이블에 offline_sale 테이블에 존재하지 않는
# product_id 값을 가진 tuple이 존재할 경우,
# 두 테이블을 LEFT JOIN했을 때, 해당 tuple은
# offline_sale 테이블에 해당하는 column의 값은 NULL로 나타나게 된다.
# 두 테이블을 RIGHT JOIN할 경우,
# 해당 tuple은 offline_sale에는 존재하지 않으므로 JOIN된 테이블에 나타나지 않는다.
