drop database if exists taskDB;
create database taskDB;
use taskDB;

create table visitor(
	vno int auto_increment ,
    vphone varchar(13) ,
    vcount int ,
    primary key(vno)
    );

    select * from visitor;