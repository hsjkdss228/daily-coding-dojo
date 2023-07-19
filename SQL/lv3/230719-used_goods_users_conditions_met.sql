/*
 *  조건에 맞는 사용자 정보 조회하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/164670
 */

SELECT
    user_id,
    nickname,
    CONCAT(
        city,
        ' ',
        street_address1,
        ' ',
        street_address2
    ) AS '전체주소',
    CONCAT(
        SUBSTRING(tlno, 1, 3),
        '-',
        SUBSTRING(tlno, 4, 4),
        '-',
        SUBSTRING(tlno, 8, 4)
    ) AS '전화번호'
FROM
    used_goods_user
WHERE
    used_goods_user.user_id IN (
        SELECT
            used_goods_board.writer_id
        FROM
            used_goods_board
        GROUP BY
            used_goods_board.writer_id
        HAVING
            COUNT(*) >= 3
    )
ORDER BY
    used_goods_user.user_id DESC;

-- GROUP BY 절을 활용하는 경우에도 그룹화된 tuple들의 개별 데이터에 접근할 수 있다.
-- 집계 함수를 사용하는 경우에는 개별 데이터에 접근할 수 없지만,
-- GROUP BY 절로 집계한 상태에서 집계된 그룹에 대한 조건부 필터링이나 연산이 필요한 경우에는
-- HAVING 절을 활용할 수 있다.
