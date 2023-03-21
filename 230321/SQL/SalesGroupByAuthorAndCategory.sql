/* 저자 별 카테고리 별 매출액 집계하기
   https://school.programmers.co.kr/learn/courses/30/lessons/144856
*/

SELECT
    book.author_id,
    author.author_name,
    book.category,
    SUM(book.price * book_sales.sales) AS sales
FROM
    book RIGHT JOIN author
        ON book.author_id = author.author_id
    RIGHT JOIN book_sales
        ON book.book_id = book_sales.book_id
WHERE
    DATE_FORMAT(book_sales.sales_date, '%Y-%m') = '2022-01'
GROUP BY
    author_name,
    category
ORDER BY
    author_id ASC,
    category DESC
