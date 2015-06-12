select *from member;
drop table member;

select id from member where
select member_id from member where name='김진선' and email='jinsun@gmail.com' and answer='김치볶음밥'; 
create table member(
	member_id varchar2(50) primary key,
	password varchar2(50) not null,
	nick varchar2(50) not null,
	name varchar2(50) not null,
	email varchar2(50) not null,
	gender number default 0,
	answer varchar2(50) not null,
	member_level number default 0,
	register_date date not null,
	love number default 0
)
drop table recipe 
create table recipe(
   recipe_no         number               primary key,
   title               varchar2(50)      not null,
   contents         varchar2(4000)      not null,
   post_date         date      not null,
   nick               varchar2(50)      not null,
   cooking_time   number               not null,
   good               number               default 0,
   bad               number               default 0,
   hits               number             default 0,
   member_id      varchar2(50)      not null,
   constraint fk_member_id foreign key(member_id) references member(member_id)
)
 select * from member where member_id='java'
insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('java', '1234', 'abcd', '�쒖�誘�, 'java@gmail.com', 0, '�뚯뒪��, 5, sysdate, 0 )

insert into member(member_id, password, nick, name, email, gender, answer, member_level, register_date, love)
values('dindony', '1234', '吏꾩뜫', '源�쭊��, 'jinsun@gmail.com', 2, '源�튂蹂띠쓬諛�, 5, sysdate, 0 )

select *from member;
