create table user(
	id int primary key auto_increment,
	name varchar(20),
	password varchar(50)
);

create table channel(
	id int primary key auto_increment,
	num int,
	name varchar(50),
	logo varchar(200)
)default charset utf8;

create table category (
	id int primary key auto_increment,
	name varchar(50)
)default charset utf8;

create table category_channel(
	id int primary key auto_increment,
	channel_id int,
	category_id int
)default charset utf8;

