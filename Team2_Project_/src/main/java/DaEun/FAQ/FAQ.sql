create table FAQ(
title varchar2(50) primary key,
write varchar2(100)
);

insert into FAQ(title,write) values('결제 하는 법','결제를 하기~');
insert into FAQ(title,write) values('결제 취소','나의 결제 내역~');
insert into FAQ(title,write) values('강의 담기','강의 옆 장바구니');
insert into FAQ(title,write) values('강의 삭제','강의 정보에서 휴지통~');
insert into FAQ(title,write) values('강의 즐겨 찾기','강의 정보에서 + 버튼');
insert into FAQ(title,write) values('회원정보 수정','마이페이지>회원정보 수정');

SELECT *FROM FAQ;

select * from FAQ
where write = (
	select write
	from FAQ
	where title = '결제'
); 
