create table dept(
    deptno NUMBER(2),
    dname VARCHAR2(14),
    loc VARCHAR2(13)
);

create table emp(
    empno NUMBER(4),
    ename VARCHAR2(10),
    job VARCHAR2(9),
    mgr NUMBER(4),
    hiredate date,
    sal number(7, 2),
    comm number(7, 2),
    deptno number(2)
);

create table emp_dept50
as
    select employee_id, first_name, salary*12 as ann_sal, hire_date
    from employees
    where department_id=50;

alter table emp_dept50
add (job_id VARCHAR2(10));

select * from emp_dept50;

alter table emp_dept50
modify (first_name varchar2(10));

alter table emp_dept50
drop column job_id;

alter table emp_dept50
rename column job to job_id;

alter table emp_dept50
set unused (first_name);

alter table emp_dept50 drop unused columns;

drop table emp_dept50;

truncate table emp2;

select * from emp2;
