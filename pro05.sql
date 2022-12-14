create database shop;
use shop;

drop table member;
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

commit;