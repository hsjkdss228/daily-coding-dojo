/*
 *  서울에 위치한 식당 목록 출력하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/131118
 */

SELECT
    infos.rest_id,
    infos.rest_name,
    infos.food_type,
    infos.favorites,
    infos.address,
    ROUND(AVG(reviews.review_score), 2) score
FROM
    rest_info infos INNER JOIN rest_review reviews
        ON infos.rest_id = reviews.rest_id
WHERE
    infos.address LIKE '서울%'
GROUP BY
    infos.rest_id
ORDER BY
    score DESC,
    favorites DESC
;

-- ROUND(숫자, 반올림할_소숫점_자릿수)
-- 숫자 값을 (반올림할_소숫점_자릿수 + 1) 자릿수에서 반올림한다.
-- (반올림할_소숫점_자릿수 + 1) 자릿수의 값이 4 이하인 경우 반올림할_소숫점_자릿수 값을 유지하고,
-- 5 이상인 경우 반올림할_소숫점_자릿수 값에 1을 더한다.
-- ROUND(1234.561, 2) = 1234.56
-- ROUND(1234.566, 2) = 1234.57
-- ROUND(1294, -2) = 1300

-- TRUNCATE(숫자, 유지할_소숫점_자릿수)
-- 숫자 값에서 유지할_소숫점_자릿수보다 뒤의 자릿수를 모두 0으로 변환한다.
-- TRUNCATE(1234.561, 2) = 1234.56
-- TRUNCATE(1234.566, 2) = 1234.56
-- TRUNCATE(1294, -2) = 1200
