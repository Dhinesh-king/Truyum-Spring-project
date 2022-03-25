create database lch_marketplace;
use lch_marketplace;
create table menu_item(
id int primary key auto_increment,
name varchar(40),
price int,
active VARCHAR(3),
date VARCHAR(10),
category VARCHAR(40),
free_delivery varchar(3)
);
select * from  menu_item;

insert into menu_item(id,name,price,active,date,category,free_delivery) 
values((2,'Burger',129,'yes','23/12/2017','Main Course','yes'),(3,'Pizza',149,'yes','21/08/2018','Main Course','yes'),(4,'French Fries',57,'no','02/07/2017','Starters','yes'),(5,'Chocolate Brownie',32,'yes','02/11/2017','Dessert','yes'));