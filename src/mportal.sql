use mportal;
set names gbk;
create table user(
	id int primary key auto_increment,
	name varchar(20),
	password varchar(50)
);

create table channel(
	id int primary key,
	num int,
	name varchar(50),
	updated_at long,
	logo_url varchar(200),
	resources_type varchar(100),
	resources_url varchar(200),
	programs_endpoint varchar(200)
)default charset utf8;
insert into channel values(10000,1,
						   '央视1套',
						   now(),
						   'http://58.196.13.15/sitv/channel/1.png',
						   'hls',
						   'http://58.196.13.15/sitv/V1521204060066.m3u8',
						    '/live/channels/10000/programs.json'
);

						   



create table event(
	eventId int primary key,
	event_begin_time long,
	event_duration long,
	egp_production_text_language varchar(20),
	egp_production_text_name varchar(100),
	egp_production_text_shortDescription text,
);

create table channel_event(
	id int primary key auto_increment,
	channel_id int ,
	event_id int
);

create table category (
	category_id int primary key,
	category_name varchar(50)
)default charset utf8;

insert into category values(100,'央视');

insert into category values(200,'新闻');


create table channel_category(
	id int primary key auto_increment,
	channel_id int ,
	category_id int
)default charset utf8;
insert into channel_category (channel_id,category_id) values(10000,100);
insert into channel_category (channel_id,category_id) values(10000,200);




	