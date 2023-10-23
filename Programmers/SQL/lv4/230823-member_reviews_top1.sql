/*
 *  그룹별 조건에 맞는 식당 목록 출력하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/131124
 */

-- 유의사항
-- member 별 리뷰 작성 개수를 알 수 있어야 한다.
-- 리뷰 작성 개수가 가장 많은 member들을 파악할 수 있어야 한다.

-- [풀이 1]
SELECT
    member_name,
    review_text,
    DATE_FORMAT(review_date, '%Y-%m-%d') review_date
FROM
    rest_review review INNER JOIN member_profile member
        ON review.member_id = member.member_id
WHERE
    member.member_id IN (
        SELECT
            review.member_id
        FROM
            rest_review review
        GROUP BY
            review.member_id
        HAVING
            COUNT(*) = (
                SELECT
                    COUNT(*)
                FROM
                    rest_review review
                GROUP BY
                    review.member_id
                ORDER BY
                    COUNT(*) DESC
                LIMIT 1
            )
    )
ORDER BY
    review_date ASC,
    review_text ASC
;

-- [풀이 2]
WITH review_ranks AS (
    SELECT
        member_id,
        RANK() OVER(ORDER BY COUNT(*) DESC) review_count_rank
    FROM
        rest_review
    GROUP BY
        member_id
)
SELECT
    member_name,
    review_text,
    DATE_FORMAT(review_date, '%Y-%m-%d') review_date
FROM
    member_profile member INNER JOIN rest_review review
        ON member.member_id = review.member_id
    INNER JOIN review_ranks ranks
        ON member.member_id = ranks.member_id
WHERE
    review_count_rank = 1
ORDER BY
    review_date ASC,
    review_text ASC
;

-- RANK(), DENSE_RANK()
-- https://dev.mysql.com/doc/refman/8.0/en/window-function-descriptions.html#function_dense-rank
-- https://satisfactoryplace.tistory.com/193

-- Window Function의 일종.
-- 같이 전달되는 OVER()에 인자로 전달되는 정렬 기준에 따라 각 행의 순위를 매긴다.
-- 공동 순위가 존재하는 경우, RANK()는 전체 인원을 기준으로 석차를 매기고,
-- DENSE_RANK()는 공동 순위의 다음 순위를 (공동 순위 +1) 값으로 매긴다.

-- 예를 들어 전체 행이 3개이고, 기준에 따라 매겨지는 순위가 공동 1등 2개, 3등 하나인 경우,
-- RANK()의 경우 결과값은 각각 1, 1, 3.
-- DENSE_RANK()의 경우 결과값은 각각 1, 1, 2.

-- 만약 특정 Column의 그룹별로 각각 순위를 매겨야 하는 경우,
-- OVER() 함수에 'PARTITION BY column_name'을 ORDER BY 구문과 같이 전달할 수 있다.
