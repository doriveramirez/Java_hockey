drop database if exists db_hockey;
create database db_hockey;
use db_hockey;
create table table_images (
id_image int primary key not null,
route varchar(200) not null
);
insert into table_images (id_image, route) values  (1,"build\\classes\\HockeyImages\\table.png");
insert into table_images (id_image, route) values  (2,"build\\classes\\HockeyImages\\pad1.png");
insert into table_images (id_image, route) values  (3,"build\\classes\\HockeyImages\\pad2.png");
insert into table_images (id_image, route) values  (4,"build\\classes\\HockeyImages\\puck.png");
