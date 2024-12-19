--3장
select * from employees
where lower(email) like '%lee%';

select first_name, salary, job_id
from employees
where manager_id=103;

select * from employees
where (department_id=80 and job_id='SA_MAN')
or (department_id=20 and manager_id=100);

select replace(phone_number, '.', '-') as 전화번호
from employees;

select rpad(first_name || ' ' || last_name, 20, '*') as full_name,
    to_char(coalesce(salary+salary*commission_pct, salary), '$099,999.00') as salary,
    to_char(hire_date, 'yyyy-mm-dd') as hire_date,
    round(sysdate - hire_date) as work_day
from employees
where job_id='IT_PROG' and salary>=5000
order by full_name;

select rpad(first_name || ' ' || last_name, 20, '*') as full_name,
    to_char(coalesce(salary+salary*commission_pct, salary), '$099,999.00') as salary,
    to_char(hire_date, 'yyyy"년" mm"월" dd"일"') as hire_date,
    trunc(months_between(sysdate, hire_date)) as month
from employees
where department_id=30
order by salary desc;

select rpad(first_name || ' ' || last_name, 17, '*') as 이름,
    to_char(coalesce(salary+salary*commission_pct, salary), '$09,999.00') as 급여
from employees
where department_id=80 and salary>10000
order by 급여 desc;

select first_name as 이름,
    decode(trunc(trunc(months_between(sysdate, hire_date)/12)/5),
        1, '5년차',
        2, '10년차',
        3, '15년차',
        '기타') as 근무년수
from employees
where department_id=60;

select hire_date+1000 from employees
where first_name='Lex';

select first_name, hire_date
from employees
where hire_date like '%/05/%';

select first_name, salary,
    to_char(hire_date, 'yyyy"년 입사"') as year,
    to_char(hire_date, 'day') as day,
    case when hire_date >= '20/01/01'
        then to_char(salary*1.10, '$999,999')
        when hire_date >= '15/01/01'
        then to_char(salary*1.05, '$999,999')
        else to_char(salary, '$999,999')
    end as increasing_salary
from employees;

select first_name, salary,
    to_char(hire_date, 'yyyy"년 입사"') as year,
    case when hire_date like '20%'
        then to_char(salary*1.10, '$999,999')
        when hire_date like '15%'
        then to_char(salary*1.05, '$999,999')
        else to_char(salary, '$999,999')
    end as increasing_salary2
from employees;

select country_id,
    coalesce(state_province, country_id) as state
from locations;

--4장
select job_id, avg(salary) as average
from employees
group by job_id;

select department_id, count(*)
from employees
group by department_id;

select department_id, job_id, count(*)
from employees
group by department_id, job_id;

select department_id, round(stddev(salary), 2)
from employees
group by department_id;

select department_id, count(*)
from employees
group by department_id
having count(*) >= 4;

select job_id, count(*)
from employees
where department_id=50
group by job_id;

select job_id, count(*)
from employees
where department_id=50
group by job_id
having count(*) < 10;

select to_char(hire_date, 'yyyy') as 입사년도,
    round(avg(salary)) as 급여평균,
    count(*) as 사원수
from employees
group by to_char(hire_date, 'yyyy')
order by 입사년도;

select to_char(hire_date, 'yyyy') as 입사년도,
    to_char(hire_date, 'mm') as 입사월,
    round(avg(salary)) as 급여평균,
    count(*) as 사원수
from employees
group by rollup(to_char(hire_date, 'yyyy'), to_char(hire_date, 'mm'))
order by 입사년도, 입사월;

select decode(grouping(to_char(hire_date, 'yyyy')),
        1, '합계', to_char(hire_date, 'yyyy')) as 입사년도,
    decode(grouping_id(to_char(hire_date, 'yyyy'), to_char(hire_date, 'mm')),
        1, '소계', 3, '합계', to_char(hire_date, 'mm')) as 입사월,
    round(avg(salary)) as 급여평균,
    count(*) as 사원수
from employees
group by cube(to_char(hire_date, 'yyyy'), to_char(hire_date, 'mm'))
order by 입사년도, 입사월;

select decode(grouping(to_char(hire_date, 'yyyy')),
        1, '합계', to_char(hire_date, 'yyyy')) as 입사년도,
    decode(grouping(to_char(hire_date, 'mm')),
        1, '소계', to_char(hire_date, 'mm')) as 입사월,
    grouping_id(to_char(hire_date, 'yyyy'), to_char(hire_date, 'mm')) as GID,
    round(avg(salary)) as 급여평균,
    count(*) as 사원수
from employees
group by cube(to_char(hire_date, 'yyyy'), to_char(hire_date, 'mm'))
order by 입사년도, 입사월;

--5장
select department_id, first_name, salary,
    rank() over(partition by department_id order by salary desc) sal_rank,
    lag(salary, 1, 0) over(partition by department_id order by salary desc) as prev_salary,
    first_value(salary) over(partition by department_id
                             order by salary desc
                             rows 1 preceding) as prev_salary2
from employees;

select first_name
from employees
where employee_id = 169;

select first_name
from employees
where employee_id = (
    select id
    from (
        select employee_id,
            lag(employee_id, 1) over(order by employee_id) as id
        from employees
    ) where employee_id=170
);

select employee_id, department_id,
    first_value(salary)
        over (partition by department_id
              order by salary
              rows between unbounded preceding and unbounded following) as lower_sal,
    salary as my_sal,
    last_value(salary)
        over (partition by department_id
              order by salary
              rows between unbounded preceding and unbounded following) as higher_sal,
    last_value(salary)
        over (partition by department_id
              order by salary
              rows between unbounded preceding and unbounded following)
              - salary as diff_sal
from employees;
