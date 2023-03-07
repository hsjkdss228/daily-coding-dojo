/* 조건에 맞는 회원 수 구하기
   https://school.programmers.co.kr/learn/courses/30/lessons/131535
*/

SELECT COUNT(*) AS users
FROM user_info
WHERE
    YEAR(joined) = '2021'
    AND age >= 20
    AND age <= 29

# DATE 타입의 column에서 일부만을 추출하는 함수 목록 참고
# https://extbrain.tistory.com/60
