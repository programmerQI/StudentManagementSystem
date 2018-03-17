drop database if exists Mybase1;

create database Mybase1;

use Mybase1;

create table students
(stuId varchar(30) primary key,
stuName nvarchar(50) not null,
stuSex varchar(5),
stuNation nvarchar(50),
stuEmail nvarchar(100)
)
