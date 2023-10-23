/*
 *  조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/164671
 */

SELECT
    CONCAT(
        '/home/grep/src/',
        files.board_id, '/',
        files.file_id, files.file_name, files.file_ext
    ) file_path
FROM
    used_goods_board boards INNER JOIN used_goods_file files
        ON boards.board_id = files.board_id
WHERE boards.board_id = (
    SELECT
        board_id
    FROM
        used_goods_board boards
    ORDER BY
        views DESC
    LIMIT 1
)
ORDER BY
    file_id DESC
;
