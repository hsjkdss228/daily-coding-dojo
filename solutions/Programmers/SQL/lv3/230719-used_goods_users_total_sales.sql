/*
 *  조건에 맞는 사용자와 총 거래금액 조회하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/164668
 */

SELECT
    user_id,
    nickname,
    SUM(price) AS total_sales
FROM
    used_goods_board
        RIGHT JOIN used_goods_user ON used_goods_board.writer_id = used_goods_user.user_id
WHERE
    status = 'DONE'
GROUP BY
    used_goods_board.writer_id
HAVING
    SUM(price) >= 700000
ORDER BY
    total_sales ASC;
