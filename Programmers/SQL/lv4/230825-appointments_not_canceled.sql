/*
 *  취소되지 않은 진료 예약 조회하기
 *  https://school.programmers.co.kr/learn/courses/30/lessons/132204
 */

SELECT
    appointment.apnt_no,
    patient.pt_name,
    patient.pt_no,
    doctor.mcdp_cd,
    doctor.dr_name,
    appointment.apnt_ymd
FROM
    appointment INNER JOIN patient
        ON appointment.pt_no = patient.pt_no
    INNER JOIN doctor
        ON appointment.mddr_id = doctor.dr_id
WHERE
    -- DATE_FORMAT(appointment.apnt_ymd, '%Y-%m-%d') = '2022-04-13'
    appointment.apnt_ymd >= '2022-04-13 00:00:00'
    AND appointment.apnt_ymd < '2022-04-14 00:00:00'
    AND appointment.apnt_cncl_yn = 'N'
    AND doctor.mcdp_cd = 'CS'
ORDER BY
    appointment.apnt_ymd ASC
;

-- https://chat.openai.com/share/7502bfca-d705-46be-9cf2-fa0c361ee986
-- WHERE 절에서 함수를 통해 Column 값을 특정한 포맷으로 변환하는 경우,
-- 데이터베이스 엔진이 인덱싱을 하지 못하고 모른 레코드를 스캔해야 해 쿼리의 실행 속도가 저하될 수 있다.
-- 따라서 WHERE 절에서는 Column 값을 직접 비교하는 것이 좋다.
