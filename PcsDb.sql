use pcsdb;

create table Employee (

     empID int primary Key auto_increment, 
     FirstName varchar(30) not null,
     LastName varchar(30) not null,
     UserId varchar(30) not null,
     Password varchar(20) not null,
     Role varchar(3) not null,
     Gender varchar(10) not null,
     Active varchar(10) not null
);
select *from Employee;

create table Skill (
    SkillId int primary key auto_increment,
    SkillName varchar(30) not null,
    SkillDescription varchar(500) not null,
    Active varchar(10) not null
) ;
select * from Skill;

create table Job (
    JobId int primary key auto_increment,
    JobTitle VARCHAR(40) not null,
    JobDescription VARCHAR(500) not null,
    CompanyName VARCHAR(50) not null,
    Location VARCHAR(30) null,
    KeySkill VARCHAR(50) not null,
    Salary int not null,
    Active varchar(20) not null
);

select * from Job;

create table EmpSkill (
    ESId int  primary key auto_increment,
    EmployeeId int not null,
    SkillId int not null,
    ExpYear int not null
);
 select * from EmpSkill;
 
create table EmpJob (
    EJId int primary key auto_increment,
    EmployeeId int not null,
    JobId int not null,
    Recruited varchar(50) not null    
);

select * from EmpJob;

