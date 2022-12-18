create database shop;
use shop;

drop table member;

create table member(
id varchar(20) primary key,
pw varchar(300) not null, 
email varchar(100) not null);
alter table member add createdDate datetime default now();
alter table member add modifiedDate datetime default now();

insert into member(id, pw, email) values("admin", "$2a$10$z4y2Wtl7gFRX79ww1iZF5u1g2P1x6v.Di5P6QhYlHdRaDQnZxjG7q", "admin@google.com");

create table member(
	id varchar(30) primary key,
    pw varchar(1000) not null,
    name varchar(30) not null,
    email varchar(100),
    tel varchar(50),
    addr1 varchar(100),
    addr2 varchar(100),
    postcode varchar(100),
    regdate varchar(100),
    birth varchar(50),
    pt int default 0,
    visited int default 0
);
desc member;
select * from member;
insert into member(id, pw, name, email, tel, regdate) values("admin", "$2a$10$z4y2Wtl7gFRX79ww1iZF5u1g2P1x6v.Di5P6QhYlHdRaDQnZxjG7q", "관리자", "admin@google.com", "010-2929-9292", now());
insert into member(id, pw, name, email, tel, regdate) values("bskang", "$2a$10$z4y2Wtl7gFRX79ww1iZF5u1g2P1x6v.Di5P6QhYlHdRaDQnZxjG7q", "강병수", "kbs@google.com", "010-2929-9292", now());
update member set pw="$2a$10$z4y2Wtl7gFRX79ww1iZF5u1g2P1x6v.Di5P6QhYlHdRaDQnZxjG7q" where id="admin";
commit;
delete from member where id ="admin";
 
 
 CREATE TABLE TB_USER (
  USER_NO int(11) NOT NULL AUTO_INCREMENT COMMENT '사용자번호',
  USER_ID varchar(255) NOT NULL COMMENT '아이디',
  USER_PW varchar(256) DEFAULT NULL COMMENT '비밀번호',
  USER_NAME varchar(255) NOT NULL COMMENT '사용자명',
  USER_AUTH varchar(255) NOT NULL COMMENT '권한',
  APPEND_DATE datetime DEFAULT NULL COMMENT '추가날짜',
  UPDATE_DATE datetime DEFAULT NULL COMMENT '수정날짜',
  PRIMARY KEY (USER_NO)
);
select * from TB_USER;
commit;

create table board(
	no int primary key auto_increment,
	title varchar(100) not null,
	content varchar(2000) not null,
	author varchar(20) not null,
	resDate datetime default now()
);
desc board;
insert into board(title, content, author) values ("테스트1","테스트1내용","dmin");
insert into board(title, content, author) values ("테스트2","테스트2내용","dmin");
insert into board(title, content, author) values ("테스트3","테스트3내용","dmin");
insert into board(title, content, author) values ("테스트4","테스트4내용","dmin");
select * from board;


create table item(
	id int primary key,
    name varchar(30) not null,
    text varchar(1000) not null,
    price int,
    count int,
    stock int,
    isSoldout int 
    );

commit;