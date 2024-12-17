SELECT first_name, last_name, salary
FROM employees;

SELECT * FROM employees;

-- 입력한 순서대로 조회
SELECT department_id, location_id FROM departments;
SELECT location_id, department_id, department_name FROM departments;

SELECT first_name, last_name, salary, salary+salary*0.1
FROM employees;

SELECT first_name, department_id, commission_pct
FROM employees;

SELECT first_name AS 이름, salary 급여
FROM employees;

SELECT first_name || ' ' || last_name || '''s salary is $' || salary
AS "Employee Details"
FROM employees;

SELECT DISTINCT department_id FROM employees;

SELECT ROWID, ROWNUM, employee_id, first_name
FROM employees;

SELECT first_name, job_id, department_id
FROM employees
WHERE job_id = 'IT_PROG';

SELECT first_name, last_name, hire_date
FROM employees
WHERE last_name = 'King';

SELECT first_name, salary, hire_date
FROM employees
WHERE salary >= 15000;

SELECT first_name, salary, hire_date
FROM employees
WHERE hire_date='14/01/30';

SELECT first_name, salary, hire_date
FROM employees
WHERE first_name='Steven';

SELECT first_name, salary
FROM employees
WHERE salary BETWEEN 10000 AND 12000;

SELECT employee_id, first_name, salary, manager_id
FROM employees
WHERE manager_id IN(101, 102, 103);

SELECT first_name, last_name, job_id, department_id
FROM employees
WHERE job_id IN('IT_PROG', 'FI_MGR', 'AD_VP');

SELECT first_name, last_name, job_id, department_id
FROM employees
WHERE job_id LIKE 'IT%';

SELECT first_name, hire_date
FROM employees
WHERE hire_date LIKE '13%';

SELECT first_name, email
FROM employees
WHERE email LIKE '_A%';

SELECT first_name, job_id
FROM employees
WHERE job_id LIKE 'SA\_M%' ESCAPE '\';

SELECT first_name, manager_id
FROM employees
WHERE manager_id IS NULL;

SELECT first_name, job_id, salary
FROM employees
WHERE job_id='IT_PROG' AND salary>=5000;

SELECT first_name, job_id, salary
FROM employees
WHERE job_id='IT_PROG' OR salary>=5000;

SELECT first_name, job_id, salary
FROM employees
WHERE job_id = 'IT_PROG'
OR job_id = 'FI_MGR'
AND salary >= 6000;

SELECT first_name, job_id, salary
FROM employees
WHERE (job_id = 'IT_PROG' OR job_id = 'FI_MGR')
AND salary >= 6000;

--연습문제
SELECT employee_id, first_name, salary
FROM employees;

SELECT first_name || ' ' || last_name AS name
FROM employees;

SELECT * FROM employees
WHERE department_id = 50;

SELECT first_name, department_id, job_id FROM employees
WHERE department_id = 50;

SELECT first_name, salary, salary+300
FROM employees;

SELECT first_name, salary
FROM employees
WHERE salary>10000;

SELECT first_name, job_id, commission_pct
FROM employees
WHERE commission_pct IS NOT NULL;

SELECT first_name, hire_date, salary
FROM employees
WHERE hire_date BETWEEN '13/01/01' AND '13/12/31';

SELECT first_name, hire_date, salary
FROM employees
WHERE hire_date LIKE '13%';

SELECT first_name, salary
FROM employees
ORDER BY salary DESC;

SELECT first_name, salary
FROM employees
WHERE department_id = 60
ORDER BY salary DESC;

SELECT first_name, job_id
FROM employees
WHERE job_id='IT_PROG' OR job_id='SA_MAN';

SELECT first_name || ' ' || last_name || ' 사원의 급여는 '
|| salary || '달러 입니다'
FROM employees
WHERE first_name='Steven' AND last_name='King';

SELECT first_name, job_id
FROM employees
WHERE job_id LIKE '%MAN';

SELECT first_name, job_id
FROM employees
WHERE job_id LIKE '%MAN'
ORDER BY job_id;
