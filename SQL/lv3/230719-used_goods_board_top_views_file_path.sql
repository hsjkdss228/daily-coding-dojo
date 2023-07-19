/*
 *  조회수가 가장 많은 중고거래 게시판의 첨부파일 조회하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/164671
 */

-- 풀이 1
SELECT
    CONCAT(
        '/home/grep/src/',
        used_goods_file.board_id,
        '/',
        file_id,
        file_name,
        file_ext
    ) AS file_path
FROM
    used_goods_file
        RIGHT JOIN (
            SELECT
                board_id
            FROM
                used_goods_board
            ORDER BY
                used_goods_board.views DESC
            LIMIT 1
        ) AS used_goods_board_top_views
            ON used_goods_file.board_id = used_goods_board_top_views.board_id
ORDER BY
    used_goods_file.file_id DESC;

-- 풀이 2
SELECT
    CONCAT(
        '/home/grep/src/',
        used_goods_file.board_id,
        '/',
        file_id,
        file_name,
        file_ext
    ) AS file_path
FROM
    used_goods_file
        RIGHT JOIN used_goods_board ON used_goods_file.board_id = used_goods_board.board_id
WHERE
    used_goods_board.views = (
        SELECT
            max(views)
        FROM
            used_goods_board
    )
ORDER BY
    used_goods_file.file_id DESC;

-- CONCAT()
-- 특정 변수들의 값을 합해 새로운 문자열 값을 생성해야 하는 경우, CONCAT() 연산을 수행할 수 있다.

-- 처음에는 풀이 2의 WHERE에서 다음과 같은 두 서브쿼리를 작성한 뒤 비교했었다.
-- 1.
-- WHERE
--    used_goods_board.board_id = (
--        SELECT
--            board_id
--        FROM
--            used_goods_board
--        ORDER BY
--            used_goods_board.views DESC
--        LIMIT 1
--    )
-- 2.
-- WHERE
--    used_goods_board.board_id IN (
--        SELECT
--            board_id
--        FROM
--            used_goods_board
--        ORDER BY
--            used_goods_board.views DESC
--        LIMIT 1
--    )
-- 1번 서브쿼리는 작동했지만, 2번 서브쿼리는
-- `This version of MySQL doesn't yet support 'LIMIT & IN/ALL/ANY/SOME subquery'`
-- 예외가 발생하면서 실행되지 않았다. 서브쿼리의 실행 순서와 관련이 있다고 하는 것 같은데,
-- 어째서 실행되지 않는 것일까? 이유를 찾아볼 필요가 있다.
