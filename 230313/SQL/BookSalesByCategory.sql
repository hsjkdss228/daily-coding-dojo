/* 카테고리 별 도서 판매량 집계하기
   https://school.programmers.co.kr/learn/courses/30/lessons/144855
*/

SELECT
    category,
    SUM(sales_sum) AS total_sales
FROM book RIGHT JOIN (
    SELECT
        book_id,
        sales_date,
        SUM(sales) AS sales_sum
    FROM book_sales
    WHERE DATE_FORMAT(sales_date, '%Y-%m') = '2022-01'
    GROUP BY book_id
) AS book_sales_sums
    ON book.book_id = book_sales_sums.book_id
GROUP BY category
ORDER BY category
