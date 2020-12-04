drop database if exists mybatis;
create database mybatis CHARACTER SET UTF8;
use mybatis;

create table user(
                     id int primary key auto_increment,
                     name varchar(50),
                     age int
);


insert into user(name,age) values('张三',33);
insert into user(name,age) values('李四',44);
insert into user(name,age) values('王五',55);
select * from user;