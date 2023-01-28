SELECT branch_id as BRANCH_ID, SUM(salary) as TOTAL
    FROM employees
    GROUP BY branch_id
    ORDER BY branch_id ASC
