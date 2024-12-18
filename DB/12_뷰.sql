select * from user_role_privs;
select * from user_sys_privs;

create view emp_view_dept60
as select employee_id, first_name, last_name, job_id, salary
    from employees
    where department_id=60;

create view emp_dept60_salary
as select
    employee_id as empno,
    first_name || ' ' || last_name as name,
    salary as monthly_salary
from employees
where department_id=60;

select * from emp_dept60_salary;

create or replace view emp_dept60_salary
as select
    employee_id as empno,
    first_name || ' ' || last_name as name,
    job_id as job,
    salary
from employees
where department_id=60;

create view emp_view
as select
    e.employee_id as id,
    e.first_name as name,
    d.department_name as department,
    j.job_title as job
from employees e
left join departments d on e.department_id = d.department_id
join jobs j on e.job_id = j.job_id;

drop view emp_dept60_salary;

create or replace view emp_dept60
as select distinct * from emps where department_id=60;

delete from emp_dept60 where employee_id=106;

select * from emp_dept60;

create or replace view emp_dept60
as select
    employee_id,
    first_name || ' ' || last_name as name,
    salary*12 as annual_salary
from emps where department_id=60;

update emp_dept60 set annual_salary=annual_salary*1.1
where employee_id=105;

create or replace view emp_dept60
as select
    employee_id, first_name, hire_date, salary, department_id
    from emps
    where department_id=60
with check option constraint emp_dept60_ck;

update emp_dept60 set department_id=10
where employee_id=105;

create or replace view emp_dept60
as select
    employee_id, first_name, hire_date, salary, department_id
    from emps
    where department_id=60
with read only;

delete from emp_dept60 where employee_id=105;

select row_number, first_name, salary
from (select first_name, salary,
      row_number() over (order by salary desc) as row_number
      from employees
      order by salary desc)
where row_number between 1 and 10;
