/*
 *  조건에 부합하는 중고거래 댓글 조회하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/164673
 */

SELECT
    used_goods_board.title AS title,
    used_goods_board.board_id AS board_id,
    reply_id,
    used_goods_reply.writer_id AS writer_id,
    used_goods_reply.contents AS contents,
    DATE_FORMAT(used_goods_reply.created_date, '%Y-%m%-%d') AS created_date
FROM
    used_goods_board
        RIGHT JOIN used_goods_reply ON used_goods_board.board_id = used_goods_reply.board_id
WHERE
    used_goods_board.created_date >= '2022-10-01'
        AND used_goods_board.created_date <= '2022-10-31'
ORDER BY
    used_goods_reply.created_date ASC,
    used_goods_board.title ASC;
