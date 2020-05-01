DROP DATABASE if exists Employee_DB;
CREATE DATABASE Employee_DB;
USE  Employee_DB;


create table Employee(employee_id integer(6) primary key AUTO_INCREMENT, name varchar(25) not null, 
last_name varchar(20), email_id varchar(20), mobile_no varchar(10) not null); 

CREATE SEQUENCE hibernate_sequence;

insert into Employee values(2001,'Markel', 'Garg', 'markel@gmail.com', 8765476548);
insert into Employee values(2002,'Chris', 'Jill', 'chris@gmail.com', 9696459375);
insert into Employee values(2003,'James', 'Jack', 'james@gmail.com', 8957216439);
insert into Employee values(2004,'Alex','Mittal', 'alex@gmail.com', 9140814428);
insert into Employee values(2005,'Bernard','Gupta', 'bernard@gmail.com', 7941123214);
insert into Employee values(2006,'Michel','Garg', 'michel@gmail.com', 8941123214);

select * from Employee;
