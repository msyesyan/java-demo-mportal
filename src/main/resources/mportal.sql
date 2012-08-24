use mportal;
set names gbk;
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

create table resource(
	id int primary key,
	type varchar(20),
	url varchar(200)
)default charset utf8;

create table channel_resource(
	id int primary key auto_increment,
	channel_id int,
	resource_id int
)default charset utf8;

insert into resource(id,type,url) 
	values(1,'hls','http://58.196.13.15/sitv/V1521204060066.m3u8');

insert into channel_resource(channel_id,resource_id)
	values(10000,1);
insert into channel values(10000,1,
						   '����1��',
						   now(),
						   'http://58.196.13.15/sitv/channel/1.png',
						    '/live/channels/10000/programs.json'
);

						   



create table event(
	eventId int primary key,
	event_begin_time varchar(100),
	event_duration long,
	egp_production_text_language varchar(20),
	egp_production_text_name varchar(100),
	egp_production_text_shortDescription text
)default charset utf8;

create table channel_event(
	id int primary key auto_increment,
	channel_id int ,
	event_id int
);



insert into category values(100,'����');

insert into category values(200,'����');


create table channel_category(
	id int primary key auto_increment,
	channel_id int ,
	category_id int
)default charset utf8;
insert into channel_category (channel_id,category_id) values(10000,100);
insert into channel_category (channel_id,category_id) values(10000,200);


//ɾ��������
delete from channel where id <> 10000;
delete from channel_category where channel_id <> 10000;
delete from resource where id not in (1,2);
delete from channel_resource where channel_id <>1;





	