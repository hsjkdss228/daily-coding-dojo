/*
 *  상품을 구매한 회원 비율 구하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/131534
 */

-- [필요한 값 및 조건]
-- 1. 2021년에 가입한 전체 회원 수: joined_counts_by_2021
SELECT
    COUNT(*) joined_count
FROM
    user_info
WHERE
    joined BETWEEN '2021-01-01' AND '2021-12-31';
-- 해당 쿼리 결과는 변수에 저장한 뒤 재사용할 수 있다.
SET @joined_counts_by_2021 := ( SELECT ... );

-- 2. 판매 기록을 년, 월 별로 그룹핑
GROUP BY YEAR(sales_date), MONTH(sales_date)

-- 3. 년, 월 별 구매 기록이 존재하는 회원을 집계하는 경우,
--    회원의 구매 기록은 각기 다른 product_id마다
--    각기 다른 sales_amount를 가진 채로 여럿 존재할 수 있기 때문에
--    년, 월 별 그룹에서 user_id에 대한 중복이 제거되어야 한다.
COUNT(DISTINCT users.user_id)

-- 4. 각 연, 월 별 2021년에 가입한 전체 회원 대비 상품을 구매한 회원 비율
ROUND(COUNT(DISTINCT users.user_id) / @joined_counts_by_2021, 1) purchased_ratio

-- [쿼리문]
SET @joined_counts_by_2021 := (
    SELECT
        COUNT(*)
    FROM
        user_info
    WHERE
        joined BETWEEN '2021-01-01' AND '2021-12-31'
);
SELECT
    YEAR(sales_date) year,
    MONTH(sales_date) month,
    COUNT(DISTINCT users.user_id) purchased_users,
    ROUND(COUNT(DISTINCT users.user_id) / @joined_counts_by_2021, 1) purchased_ratio
FROM
    user_info users INNER JOIN online_sale sales
        ON users.user_id = sales.user_id
WHERE
    users.joined BETWEEN '2021-01-01' AND '2021-12-31'
GROUP BY
    YEAR(sales_date),
    MONTH(sales_date)
ORDER BY
    year ASC,
    month ASC
;
