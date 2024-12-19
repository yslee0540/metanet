--6장
select first_name, department_name, city
from employees e, departments d, locations l
where e.department_id = d.department_id
and d.location_id = l.location_id
and first_name = 'John';

select first_name, department_name, city
from employees e
    join departments d on e.department_id = d.department_id
    join locations l on d.location_id = l.location_id
where first_name = 'John';

select a.employee_id, a.first_name, a.salary, b.first_name, department_name
from employees a
    join employees b on a.manager_id=b.employee_id
    join departments d on b.department_id=d.department_id
where a.employee_id=103;

select e.employee_id, e.first_name, e.salary,
m.first_name, m.salary, department_name
from employees e
    left join employees m on e.manager_id=m.employee_id
    left join departments d on m.department_id=d.department_id
where e.department_id=90;

select e.employee_id, e.first_name, e.salary,
m.first_name, m.salary, department_name
from employees e, employees m, departments d
where e.manager_id=m.employee_id(+)
    and m.department_id=d.department_id(+)
    and e.department_id=90;

select employee_id, city
from employees e
    join departments d on e.department_id = d.department_id
    join locations l on d.location_id = l.location_id
where employee_id=103;

select city, job_title
from employees e
    left join employees m on e.manager_id=m.employee_id
    join departments d on e.department_id = d.department_id
    join locations l on d.location_id = l.location_id
    join jobs j on m.job_id = j.job_id
where e.employee_id=103;

select e.employee_id, e.first_name, e.last_name, e.email, e.phone_number, e.hire_date,
j.job_title, e.salary, e.commission_pct, m.first_name, m.last_name, d.department_name
from employees e
    left join employees m on e.manager_id=m.employee_id
    join departments d on e.department_id = d.department_id
    join jobs j on e.job_id = j.job_id;

--7장
select * from employees
where manager_id in (
    select distinct manager_id from employees
    where department_id=20
    );