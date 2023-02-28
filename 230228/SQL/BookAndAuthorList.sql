/* 조건에 맞는 도서와 저자 리스트 출력하기
   https://school.programmers.co.kr/learn/courses/30/lessons/144854
*/

SELECT
    book_id,
    author_name,
    DATE_FORMAT(published_date, '%Y-%m-%d') AS published_date
FROM book LEFT JOIN author
    ON book.author_id = author.author_id
WHERE category LIKE '경제'
ORDER BY published_date ASC
