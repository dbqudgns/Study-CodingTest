-- RECURSIVE CTE (재귀 CTE)를 이용해 0부터 23까지의 숫자를 생성하는 임시 시간 테이블
WITH RECURSIVE hours AS (
    SELECT 0 AS hour -- 시작 값 (0시)
    UNION ALL -- 중복 허용해서 값을 합침
    SELECT hour + 1 FROM hours WHERE hour < 23
    )

SELECT h.hour, COUNT(A.DATETIME) AS COUNT
FROM hours h
    LEFT JOIN ANIMAL_OUTS A ON HOUR(A.DATETIME) = h.hour
GROUP BY h.hour
ORDER BY h.hour