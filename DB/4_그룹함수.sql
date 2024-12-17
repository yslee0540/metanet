select department_id, count(first_name), sum(salary)
from employees
group by department_id
having avg(salary) > 10000;

SELECT AVG(salary), MAX(salary), MIN(salary), SUM(salary)
FROM employees
WHERE job_id LIKE 'SA%';

select min(first_name), max(last_name)
from employees;

select count(*) from employees;

select sum(salary) as 합계,
       round(avg(salary), 2) as 평균,
       round(stddev(salary), 2) as 표준편차,
       round(variance(salary), 2) as 분산
from employees;

select department_id, job_id, sum(salary)
from employees
group by department_id, job_id;

select job_id, avg(salary) PAYROLL
from employees
where job_id not like 'SA%'
group by job_id
having avg(salary) > 8000
order by avg(salary);

select department_id, job_id, round(avg(salary), 2)
from employees
group by grouping sets(department_id, job_id)
order by department_id, job_id;

select department_id, job_id, manager_id, round(avg(salary), 2) as avg_sal
from employees
group by grouping sets((department_id, job_id), (job_id, manager_id))
order by department_id, job_id;

select department_id, job_id, round(avg(salary), 2), count(*)
from employees
group by rollup(department_id, job_id)
order by department_id, job_id;

select department_id, job_id, round(avg(salary), 2), count(*)
from employees
group by cube(department_id, job_id)
order by department_id, job_id;

select
    decode(grouping(department_id), 1, '소계', to_char(department_id)) as 부서,
    decode(grouping(job_id), 1, '소계', job_id) as 직무,
    round(avg(salary), 2) as 평균, count(*) as 사원의수
from employees
group by cube(department_id, job_id)
order by 부서, 직무;

select
    decode(grouping_id(department_id, job_id), 2, '소계', 3, '합계',
        to_char(department_id)) as 부서번호,
    decode(grouping_id(department_id, job_id), 1, '소계', 3, '합계',
        job_id) as 직무,
    grouping_id(department_id, job_id) as GID,
    round(avg(salary), 2) as 평균, count(*) as 사원의수
from employees
group by cube(department_id, job_id)
order by 부서번호, 직무;