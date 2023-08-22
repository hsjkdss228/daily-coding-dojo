/*
 *  저자 별 카테고리 매출액 집계하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/144856
 */

SELECT
    author.author_id,
    author.author_name,
    book.category,
    SUM(book.price * sales.sales) total_sales
FROM
    book_sales sales
        INNER JOIN book ON sales.book_id = book.book_id
        INNER JOIN author ON book.author_id = author.author_id
WHERE
    sales.sales_date BETWEEN '2022-01-01' AND '2022-01-31'
GROUP BY
    book.category,
    author.author_name
ORDER BY
    author.author_id ASC,
    book.category DESC
;
