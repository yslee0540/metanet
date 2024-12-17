--문자함수
SELECT * FROM dual;
SELECT sysdate FROM dual;
--SELECT initcap(email) FROM employees;
SELECT initcap('javaspecialist') FROM dual;
SELECT lower('Javaspecialist') FROM dual;
SELECT upper('Javaspecialist') FROM dual;
SELECT length('Javaspecialist') FROM dual;
SELECT length('자바전문가그룹') FROM dual;
SELECT lengthb('자바전문가그룹') FROM dual;
-- 바이트 크기: utf-8(3바이트), EUC-KR(2바이트)
SELECT concat('Java', 'Specialist') FROM dual;
SELECT substr('JavaSpecialist', 5, 7) FROM dual;
SELECT substr('자바전문가그룹', 3, 3) FROM dual;
SELECT substrb('자바전문가그룹', 7, 9) FROM dual;
SELECT instr('JavaSpecialist', 'S') FROM dual;
SELECT instr('JavaSpecialist', 'b') FROM dual;
SELECT instr('자바전문가그룹', '전') FROM dual;
SELECT instrb('자바전문가그룹', '전') FROM dual;
SELECT lpad(17600, 10, '*') FROM dual;
SELECT rpad('Java', 10, '-') FROM dual;
SELECT ltrim('Javaspecialist', 'Jav') FROM dual;
SELECT ltrim('  Javaspecialist') FROM dual;
SELECT trim('  Javaspecialist   ') FROM dual;
SELECT replace('JavaSpecialist', 'Java', 'BigData') FROM dual;
SELECT replace('Java Specialist', ' ', '') FROM dual;
SELECT translate('javaspecialist', 'abcdefghijklmnopqrstuvwxyz', 'defghijklmnopqrstuvwxyzabc') FROM dual;

--정규표현식
CREATE TABLE test_regexp(col1 VARCHAR(10));

INSERT INTO test_regexp VALUES('ABCDE01234');
INSERT INTO test_regexp VALUES('01234ABCDE');
INSERT INTO test_regexp VALUES('abcde01234');
INSERT INTO test_regexp VALUES('01234abcde');
INSERT INTO test_regexp VALUES('1-234-5678');
INSERT INTO test_regexp VALUES('234-567890');

SELECT * FROM test_regexp
WHERE REGEXP_LIKE(col1, '[0-9][a-z]');

SELECT * FROM test_regexp
WHERE REGEXP_LIKE(col1, '[0-9]{3}-[0-9]{4}$');

INSERT INTO test_regexp VALUES('@!=)(9&%$#');
INSERT INTO test_regexp VALUES('자바3');

SELECT col1,
    REGEXP_INSTR(col1, '[0-9]') AS data1,
    REGEXP_INSTR(col1, '%') AS data2
FROM test_regexp;

SELECT col1, REGEXP_SUBSTR(col1, '[C-Z]+')
FROM test_regexp;

SELECT col1, REGEXP_REPLACE(col1, '[0-2]+', '*')
FROM test_regexp;

SELECT ROUND(45.923, 2), ROUND(45.923, 0), ROUND(45.923, -1)
FROM dual;

SELECT TRUNC(45.923, 2), TRUNC(45.923, 0), TRUNC(45.923, -1)
FROM dual;

SELECT sysdate FROM dual;
SELECT systimestamp FROM dual;

SELECT first_name, (sysdate - hire_date)/7 AS "Weeks"
FROM employees
WHERE department_id=60;

SELECT first_name, SYSDATE, hire_date,
    MONTHS_BETWEEN(SYSDATE, hire_date) AS workmonth
FROM employees
WHERE first_name='Diana';

SELECT first_name, hire_date, ADD_MONTHS(hire_date, 100)
FROM employees
WHERE first_name='Diana';

SELECT SYSDATE, NEXT_DAY(SYSDATE, '월')
FROM dual;

SELECT SYSDATE, LAST_DAY(SYSDATE)
FROM dual;

SELECT SYSDATE, ROUND(SYSDATE), TRUNC(SYSDATE)
FROM dual;

SELECT TRUNC(SYSDATE, 'Month')
FROM dual;

SELECT first_name,
    TO_CHAR(hire_date, 'YYYY"년" MM"월" DD"일"') HIREDATE
FROM employees;

SELECT first_name, last_name, TO_CHAR(salary, '$999,999') SALARY
FROM employees
WHERE first_name='David';

select to_char(2000000, '$999,999') SALARY
from dual;

select first_name, last_name, salary*0.123456 SALARY1,
       to_char(salary*0.123456, '$999,999.99') SALARY2
from employees
where first_name = 'David';

SELECT to_number('$5,500.00', '$99,999.99') - 4000
FROM dual;

SELECT first_name, hire_date FROM employees
WHERE hire_date=TO_DATE('2013/06/17', 'YYYY/MM/DD');

select first_name, salary + salary*nvl(commission_pct, 0)
from employees;

select first_name, nvl2(commission_pct, salary+salary*commission_pct, salary) ann_sal
from employees;

select first_name, coalesce(salary + (salary*commission_pct), salary) AS ann_sal
from employees;

select first_name, coalesce(salary*commission_pct, 0) as bonus
from employees
where lnnvl(salary*commission_pct >= 650);

select job_id, salary,
       decode(job_id, 'IT_PROG', salary*1.10,
                      'FI_MGR', salary*1.15,
                      'FI_ACCOUNT', salary*1.20,
                      salary)
       as revised_salary
from employees;

select job_id, salary,
       case job_id when 'IT_PROG' then salary*1.10
                   when 'FI_MGR' then salary*1.15
                   when 'FI_ACCOUNT' then salary*1.20
            else salary
       end as revised_salary
from employees;

select job_id, salary,
       case when job_id='IT_PROG' then salary*1.10
            when job_id='FI_MGR' then salary*1.15
            when job_id='FI_ACCOUNT' then salary*1.20
            else salary
       end as revised_salary
from employees;

select employee_id, first_name
from employees
where hire_date like '14%'
UNION
select employee_id, first_name
from employees
where department_id = 20;

select employee_id, first_name
from employees
where hire_date like '14%'
UNION ALL
select employee_id, first_name
from employees
where department_id = 20;

select employee_id, first_name
from employees
where hire_date like '14%'
INTERSECT
select employee_id, first_name
from employees
where department_id = 20;

select employee_id, first_name
from employees
where hire_date like '14%'
MINUS
select employee_id, first_name
from employees
where department_id = 20;