select * from user_sequences;

create sequence depts_seq
    start with 91
    increment by 1
    maxvalue 100
    nocycle
    nocache;

insert into depts(deptno, dname, loc)
values (depts_seq.nextval, 'MARKETING', 'SAN DIEGO');

select * from depts;

select depts_seq.currval from dual;

alter sequence depts_seq maxvalue 99999;

drop sequence depts_seq;


create table depts(
    deptno number(2) generated always as identity
                    (start with 10 increment by 10),
    dname varchar(14),
    loc varchar2(13) unique,
    constraint depts_deptno_pk primary key(deptno)
);

insert into depts(dname, loc)
values ('MARKETING', 'SAN DIEGO');

select * from depts;

--인덱스
select * from emps where first_name='David';

create index emps_first_name_idx on emps(first_name);

drop index emps_first_name_idx;

select ic.index_name, column_name, uniqueness
from user_indexes ix, user_ind_columns ic
where ic.index_name = ix.index_name;

create bitmap index emps_comm_idx on emps(commission_pct);

select * from emps where commission_pct > 0.3;

create unique index emps_email_idx on emps(email);

select * from emps where email='DAUSTIN';

create index emps_annsal_index
on emps(coalesce(salary+salary*commission_pct, salary));

select * from emps
where coalesce(salary+salary*commission_pct, salary) > 10000;

create unique index emps_name_indx on emps(first_name, last_name);

select * from emps
where first_name='Peter' and last_name='Hall';

create SYNONYM emp60 for emp_dept60;
drop SYNONYM emp60;
