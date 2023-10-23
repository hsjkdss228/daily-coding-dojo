/*
 *  년, 월, 성별 별 상품 구매 회원 수 구하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/131532
 */

-- gender = true: 남자, false: 여자, NULL

SELECT
    YEAR(sales_date) year,
    MONTH(sales_date) month,
    gender,
    COUNT(DISTINCT infos.user_id) users
FROM
    user_info infos INNER JOIN online_sale sales
        ON infos.user_id = sales.user_id
WHERE
    gender IS NOT NULL
GROUP BY
    YEAR(sales_date),
    MONTH(sales_date),
    gender
ORDER BY
    year ASC,
    month ASC,
    gender ASC
;

-- DISTINCT
-- SELECT 절에서 지정하는 Column에 대해 중복을 제거하고 조회할 수 있다.
-- 본 문제는 특정 년/월에 한 명의 user가 두 번 이상 상품을 구매하는 경우가 있을 수 있음.
-- 이를 고려하지 않으면 COUNT 시 동일 user에 대한 행이 여러 개 존재하더라도 모두 집계됨.
-- 따라서 집계된 각 그룹에서 DISTINCT로 user의 중복을 제거한 뒤, 남은 집계된 행들만 COUNT.
