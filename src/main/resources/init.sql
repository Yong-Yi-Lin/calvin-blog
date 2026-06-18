drop database if exists blog;
create database blog character set utf8mb4;
use blog;
create table user(
    id int primary key auto_increment,
    username varchar(20) not null unique,
    password varchar(20) not null,
    nickname varchar(10) not null
);
insert into user values(null,'abc','123','糯米');

create table article(
    id int primary key auto_increment,
    title varchar(50) not null,
    `date` date,
    content mediumtext,
    user_id int,
    foreign key (user_id) references user(id)
);
insert into article values(null,'文章1','2022-9-9','今天要好好学习',1);
insert into article values(null,'文章2','2022-9-17','今天要玩游戏',1);