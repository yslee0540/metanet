select * from user_constraints;
select * from tab;
select * from user_views;
select * from user_objects where object_type='TABLE';

create table emp4(
    empno number(4) constraint emp4_empno_pk primary key,
    ename varchar2(10) not null,
    sal number(7, 2) constraint emp4_sal_ck check(sal<=10000),
    deptno number(2) constraint emp4_deptno_dept_deptid_fk
                     references departments(department_id)
);

create table emp5(
    empno number(4),
    ename varchar2(10) not null,
    sal number(7, 2),
    deptno number(2),
    constraint emp5_empno_pk primary key (empno),
    constraint emp5_sal_ck check(sal<=10000),
    constraint emp5_deptno_dept_deptid_fk
        foreign key (deptno) references departments(department_id)
);

alter table emp4 disable constraint emp4_sal_ck;

insert into emp4 values(9999, 'KING', 20000, 10);
select * from emp4;

alter table emp4
enable validate constraint emp4_sal_ck;

alter table emp4
enable novalidate constraint emp4_sal_ck;

