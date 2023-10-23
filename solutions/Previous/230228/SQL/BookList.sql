/* 조건에 맞는 도서 리스트 출력하기
   https://school.programmers.co.kr/learn/courses/30/lessons/144853
*/

SELECT
    book_id,
    DATE_FORMAT(published_date, '%Y-%m-%d') AS date_format
FROM book
WHERE category LIKE '인문' AND YEAR(published_date) = '2021'
ORDER BY published_date ASC

# DATE 타입의 포맷 지정 방식 참고
# https://devjhs.tistory.com/89

# DATE 타입에서 특정 값 추출 방식 참고
# https://marketinga.tistory.com/13
