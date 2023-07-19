/*
 *  조건에 부합하는 중고거래 상태 조회하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/164672
 */

SELECT
    board_id,
    writer_id,
    title,
    price,
    CASE
        WHEN status = 'SALE' THEN '판매중'
        WHEN status = 'RESERVED' THEN '예약중'
        WHEN status = 'DONE' THEN '거래완료'
        ELSE '기타'
    END AS status
FROM
    used_goods_board
WHERE
    used_goods_board.created_date = '2022-10-05'
ORDER BY
    board_id DESC;

-- 일반적으로 문자열 조건 검사 시 '='는 'LIKE'보다 좋은 성능을 발휘할 수 있다.
-- '='는 인덱스를 활용할 수 있기 때문이다.
-- 'LIKE'는 FULL SCAN을 수행하기 때문에 인덱스를 활용하기 어렵다고 한다.
-- 자세한 비교는 실험을 통해 진행할 필요가 있다.
-- Reference: https://link2me.tistory.com/544
