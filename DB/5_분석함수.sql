select employee_id, department_id, salary,
    rank() over(order by salary desc) sal_rank,
    dense_rank() over(order by salary desc) sal_dense_rank,
    row_number() over(order by salary desc) sal_number
from employees
order by sal_number;

select employee_id, department_id, salary,
    cume_dist() over(order by salary desc) sal_cume_dist,
    percent_rank() over(order by salary desc) sal_pct_rank
from employees;

select first_name, salary,
    round(ratio_to_report(salary) over (), 4) as salary_ratio
from employees
where job_id='IT_PROG';

select employee_id, department_id, salary,
    ntile(10) over (order by salary desc) sal_quart_tile
from employees
where department_id=50;

select employee_id,
    lag(salary, 1, 0) over (order by salary) as lower_sal,
    salary,
    lead(salary, 1, 0) over (order by salary) as higher_sal
from employees
order by salary;

select department_id,
    listagg(first_name, ',') within group(order by hire_date) as names
from employees
group by department_id;

select department_id, first_name, salary,
    sum(salary) over (partition by department_id
                      order by salary
                      range between unbounded preceding
                           and current row) as sum_rows
from employees;

select avg(salary), regr_avgx(commission_pct, salary)
from employees;

select distinct department_id, regr_count(manager_id, department_id)
       over (partition by department_id) "REGR_COUNT"
from employees;

select job_id, employee_id, salary,
       round(sysdate-hire_date) "WORKING_DAY",
       round(regr_slope(salary, sysdate-hire_date)
        over (partition by job_id), 2) "REGR_INTERCEPT"
from employees
where department_id=80
order by job_id, employee_id;

select distinct job_id,
       round(regr_slope(salary, sysdate-hire_date)
        over (partition by job_id), 2) "REGR_SLOPE",
       round(regr_intercept(salary, sysdate-hire_date)
        over (partition by job_id), 2) "REGR_INTERCEPT",
       round(regr_r2(salary, sysdate-hire_date)
        over (partition by job_id), 2) "REGR_R2"
from employees
where department_id=80;

create table sales_log(
    employee_id NUMBER(6),
    week_id NUMBER(2),
    week_day VARCHAR2(10),
    quantity NUMBER(8,2)
);

INSERT INTO sales_log values(1101, 4, 'SALES_MON', 100);
INSERT INTO sales_log values(1101, 4, 'SALES_TUE', 150);
INSERT INTO sales_log values(1101, 4, 'SALES_WED', 80);
INSERT INTO sales_log values(1101, 4, 'SALES_THU', 60);
INSERT INTO sales_log values(1101, 4, 'SALES_FRI', 120);
INSERT INTO sales_log values(1102, 5, 'SALES_MON', 300);
INSERT INTO sales_log values(1102, 5, 'SALES_TUE', 300);
INSERT INTO sales_log values(1102, 5, 'SALES_WED', 230);
INSERT INTO sales_log values(1102, 5, 'SALES_THU', 120);
INSERT INTO sales_log values(1102, 5, 'SALES_FRI', 150);

commit;
select * from sales_log;

create table sales(
    employee_id NUMBER(6),
    week_id NUMBER(2),
    sales_mon NUMBER(8,2),
    sales_tue NUMBER(8,2),
    sales_wed NUMBER(8,2),
    sales_thu NUMBER(8,2),
    sales_fri NUMBER(8,2)
);

INSERT INTO sales VALUES(1101, 4, 100, 150, 80, 60, 120);
INSERT INTO sales VALUES(1102, 5, 300, 300, 230, 120, 150);

commit;
select * from sales;

select * from sales_log
pivot
(
    sum(quantity)
    for week_day IN('SALES_MON' AS sales_mon,
                    'SALES_TUE' AS sales_tue,
                    'SALES_WED' AS sales_wed,
                    'SALES_THU' AS sales_thu,
                    'SALES_FRI' AS sales_fri)
)
order by employee_id, week_id;

select employee_id, week_id, week_day, quantity
from sales
unpivot
(
    quantity
    for week_day
    in(sales_mon, sales_tue, sales_wed, sales_thu, sales_fri)
);
