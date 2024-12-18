create table emp as
select employee_id as empno, first_name as ename, salary as sal, department_id as deptno
from employees;

--user1
select empno, ename, sal from emp
where deptno=30;

update emp set sal=sal*1.1
where deptno=30;
