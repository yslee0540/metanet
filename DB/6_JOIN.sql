select e.first_name, e.department_id, d.department_name
from employees e, departments d
where e.department_id = d.department_id;

select e.first_name as employee_name,
       m.first_name as manager_name
from employees e, employees m
where e.manager_id = m.employee_id and e.employee_id=103;

select e.first_name, e.salary, j.job_title
from employees e, jobs j
where e.salary
between j.min_salary and j.max_salary;

select e.employee_id, e.first_name, e.hire_date,
       j.start_date, j.end_date, j.job_id, j.department_id
from employees e, job_history j
where e.employee_id = j.employee_id(+)
order by j.employee_id;

select e.employee_id, e.first_name, d.department_id
from employees e
cross join departments d;

select first_name, department_name
from employees
natural join departments;

select first_name, department_name
from employees
join departments
using (department_id);

select department_name, street_address, city, state_province
from departments d
join locations l
on d.location_id = l.location_id;

select first_name, department_name,
    street_address || ', ' || city || ', ' || state_province
    as address
from employees e
join departments d on e.department_id = d.department_id
join locations l on d.location_id = l.location_id;

select first_name as name, department_name
from employees e
join departments d
on e.department_id = d.department_id
where employee_id = 103;

select e.employee_id, first_name, e.department_id
from employees e
left outer join job_history j
on e.employee_id = j.employee_id
order by j.employee_id;


