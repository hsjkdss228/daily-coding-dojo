/*
 *  카테고리 별 도서 판매량 집계하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/144855
 */

SELECT
    book.category,
    SUM(sales.sales) total_sales
FROM
    book INNER JOIN book_sales sales
        ON book.book_id = sales.book_id
WHERE
    sales.sales_date BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY
    book.category
ORDER BY
    book.category ASC
;

-- HAVING 절은 집계함수를 이용해 조건을 검사할 때 사용해야 한다.
