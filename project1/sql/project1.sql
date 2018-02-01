set names utf8;
set foreign_key_checks = 0;
drop database if exists project1;

create database if not exists project1;
use project1;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

create table item_info(
item_id int not null primary key auto_increment,
user_id varchar(16),
item_category varchar(16),
item_name varchar(50),
item_price int,
item_count int,
item_total_price int,
item_search_word varchar(1000),
insert_date datetime,
updated_date datetime
);

create table already_read(
user_id varchar(16),
book_id varchar(16),
book_img varchar(255),
book_title varchar(255),
book_author varchar(255),
book_published_date varchar(255),
book_description varchar(1000),
insert_date datetime,
updated_date datetime
);

create table follow_list(
user_id varchar(16),
user_name varchar(16),
followed_user_id varchar(16),
followed_user_name varchar(16),
insert_date datetime,
updated_date datetime
);
