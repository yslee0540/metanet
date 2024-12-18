create table emp1 as select * from employees;
select count(*) from emp1;

create table emp2 as select * from employees where 1=2;
select count(*) from emp2;

desc departments;

insert into departments
    (department_id, department_name, location_id)
values (280, 'Data Analytics', 1700);

select * from departments
where department_id = 280;
rollback;

create table managers as
    select employee_id, first_name, job_id, salary, hire_date
    from employees
    where 1=2;

insert into managers
    (employee_id, first_name, job_id, salary, hire_date)
    select employee_id, first_name, job_id, salary, hire_date
    from employees
    where job_id like '%MAN';

create table emps as select * from employees;
alter table emps
add (constraint emps_emp_id_pk primary key (employee_id),
     constraint emps_manager_fk foreign key (manager_id)
                references emps(employee_id)
);

select employee_id, first_name, salary
from emps
where employee_id=103;

update emps
set salary=salary*1.1
where employee_id=103;
commit;

select employee_id, first_name, job_id, salary, manager_id
from emps
where employee_id in (108, 109);

update emps
set (job_id, salary, manager_id) = 
    (select job_id, salary, manager_id
     from emps
     where employee_id = 108)
where employee_id=109;

delete from emps where employee_id=104;

create table depts as
    select * from departments;
    
delete from emps
where department_id =
                     (select department_id
                      from depts
                      where department_name='Shipping');
commit;

create table emps_it as select * from employees where 1=2;

insert into emps_it
    (employee_id, first_name, last_name, email, hire_date, job_id)
values
    (105, 'David', 'Kim', 'DAVIDKIM', '06/03/04', 'IT_PROG');

merge into emps_it a
    using (select * from employees where job_id='IT_PROG') b
    on (a.employee_id = b.employee_id)
when matched then
    update set
        a.phone_number = b.phone_number,
        a.hire_date = b.hire_date,
        a.job_id = b.job_id,
        a.salary = b.salary,
        a.commission_pct = b.commission_pct,
        a.manager_id = b.manager_id,
        a.department_id = b.department_id
when not matched then
    insert values
        (b.employee_id, b.first_name, b.last_name, b.email,
         b.phone_number, b.hire_date, b.job_id, b.salary,
         b.commission_pct, b.manager_id, b.department_id);

select * from emps_it;

insert all
    into emp1
        values (300, 'Kildong', 'Hong', 'KHONG', '011.624.7902',
                TO_DATE('2015-05-11', 'YYYY-MM-DD'), 'IT_PROG', 6000,
                null, 100, 90)
    into emp2
        values (400, 'Kilseo', 'Hong', 'KSHONG', '011.3402.7902',
                TO_DATE('2015-06-20', 'YYYY-MM-DD'), 'IT_PROG', 5500,
                null, 100, 90)
    select * from dual;
        
create table emp_salary as
    select employee_id, first_name, salary, commission_pct
    from employees
    where 1=2;
    
create table emp_hire_date as
    select employee_id, first_name, hire_date, department_id
    from employees
    where 1=2;

insert all
    into emp_salary values
        (employee_id, first_name, salary, commission_pct)
    into emp_hire_date values
        (employee_id, first_name, hire_date, department_id)
    select * from employees;

select * from emp_salary;
select * from emp_hire_date;

create table emp_20 as select * from employees where 1=2;

insert all
    when department_id=10 then
        into emp_10 values
            (employee_id, first_name, last_name, email, phone_number,
             hire_date, job_id, salary, commission_pct, manager_id,
             department_id)
    when department_id=20 then
        into emp_20 values
            (employee_id, first_name, last_name, email, phone_number,
             hire_date, job_id, salary, commission_pct, manager_id,
             department_id)
    select * from employees;

select * from emp_20;

create table emp_sal25000 as
select employee_id, first_name, salary from employees where 1=2;

insert first
    when salary <= 5000 then
        into emp_sal5000 values (employee_id, first_name, salary)
    when salary <= 10000 then
        into emp_sal10000 values (employee_id, first_name, salary)
    when salary <= 15000 then
        into emp_sal15000 values (employee_id, first_name, salary)
    when salary <= 20000 then
        into emp_sal20000 values (employee_id, first_name, salary)
    when salary <= 25000 then
        into emp_sal25000 values (employee_id, first_name, salary)
    select employee_id, first_name, salary from employees;

select count(*) from emp_sal25000;

truncate table sales_log;

insert all
    into sales_log
        values(employee_id, week_id, 'SALES_MON', sales_mon)
    into sales_log
        values(employee_id, week_id, 'SALES_TUE', sales_tue)
    into sales_log
        values(employee_id, week_id, 'SALES_WED', sales_wed)
    into sales_log
        values(employee_id, week_id, 'SALES_THU', sales_thu)
    into sales_log
        values(employee_id, week_id, 'SALES_FRI', sales_fri)
    select * from sales;

select * from sales_log;
