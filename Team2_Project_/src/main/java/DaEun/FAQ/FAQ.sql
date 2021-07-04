DROP TABLE FAQ;

create table FAQ(
title varchar2(70) primary key,
write01 varchar2(100)
);
insert into FAQ(title,write01)
values ('결제 하는 법','결제를 하기 위해서는 결제 페이지로 이동하세요');
insert into FAQ(title,write01) 
values ('결제 취소','나의 결제 내역에서 결제 취소를 진행하세요.');
insert into FAQ(title,write01) 
values ('강의 담기','강의 옆 장바구니를 클릭하세요');
insert into FAQ(title,write01) 
values ('강의 삭제','강의 정보에서 휴지통 버튼을 누르세요');
insert into FAQ(title,write01) 
values ('강의 즐겨찾기','강의 정보에서 + 버튼을 눌러 즐겨찾기에 추가하세요');
insert into FAQ(title,write01) 
values ('회원 정보 수정하기','회원정보 수정은 마이 페이지에서 가능합니다.');
insert into FAQ(title,write01) 
values ('회원 정보 기능 알기','회원 정보에서는 이러한 기능들이 있습니다.');
SELECT title,write01
FROM FAQ;


SELECT *
FROM FAQ
WHERE write01 = (
	SELECT write01
	FROM FAQ
	WHERE title = '강의');
SELECT * FROM FAQ;

SELECT title FROM FAQ;
