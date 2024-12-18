--user2
select empno, ename, sal from emp
where deptno=30;
--업데이트 반영 안 됨

update emp set sal=sal+500
where empno=115;
--명령어 실행되지 않음