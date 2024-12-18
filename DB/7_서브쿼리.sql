select first_name, salary
from employees
where salary > (select salary
                from employees
                where first_name='Nancy');
                
select first_name, job_id, hire_date
from employees
where job_id = (select job_id
                from employees
                where employee_id=103);
                
select first_name, salary
from employees
where salary > any (select salary
                    from employees
                    where first_name='David');
                    
select first_name, department_id, job_id
from employees
where department_id in (select department_id
                        from employees
                        where first_name='David');
                        
select first_name, department_id, job_id
from employees e
where exists (select *
              from departments d
              where d.manager_id=e.employee_id);
                        
select first_name, salary
from employees a
where salary > (select avg(salary)
                from employees b
                where b.department_id=a.department_id);
                
select first_name, (select department_name
    from departments d
    where d.department_id=e.department_id) department_name
from employees e
order by first_name;

select first_name, department_name
from employees e
join departments d on (e.department_id=d.department_id)
order by first_name;

select row_number, first_name, salary
from (select first_name, salary,
      row_number() over (order by salary desc) as row_number
      from employees)
where row_number between 1 and 10;

select rownum, first_name, salary
from (select first_name, salary
      from employees
      order by salary desc)
where rownum between 1 and 10;
--첫 번째 행부터 밖에 조회 못함

select rnum, first_name, salary 
from (select rownum as rnum, first_name, salary
      from (select first_name, salary
            from employees
            order by salary desc)
      )
where rnum between 6 and 10;

select first_name, salary
from employees
order by salary desc
offset 10 rows
fetch first 4 rows only;

select employee_id,
    lpad(' ', 3*(level-1)) || first_name || ' ' || last_name as full_name,
    level
from employees
start with manager_id is null
connect by prior employee_id=manager_id
order siblings by first_name;

select employee_id,
    lpad(' ', 3*(level-1)) || first_name || ' ' || last_name as full_name,
    level
from employees
start with employee_id = 113
connect by prior manager_id=employee_id;
