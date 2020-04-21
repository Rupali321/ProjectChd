DROP DATABASE if exists Employee_DB;
CREATE DATABASE Employee_DB;
USE  Employee_DB;


create table Employee( employee_id number(6) primary key, name varchar2(25) not null, mobile_no number(10) not null); 

insert into Employee values(2001,'Markel',8765476548);
insert into Employee values(2002,'Chris', 9696459375);
insert into Employee values(2003,'James', 8957216439);
insert into Employee values(2004,'Alex',9140814428);
insert into Employee values(2005,'Bernard',7941123214);
insert into Employee values(2006,'Michel',8941123214);

select * from employee
