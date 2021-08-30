
/*

autDB와 같은 DB (이름만 다름)
회원 - Member
회원번호 memno
ID memid
PW mempw
전화번호 memtel
이메일 mememail
사용권한 memauth

작가 - Artist
작가번호 artno
이름 artkorname
영문이름 artengname
프로필이미지 artimgtitle
프로피URL arturl
외부공개이메일 artoutemail
회원번호 memno


*/




-- 1. 회원 Table : 회원번호, 회원ID, 회원PW, 회원전화번호, 회원이메일, 회원사용권한
CREATE TABLE ACI01_Member (
	memno varchar2(50) PRIMARY key,
	memid varchar2(50),
	mempw varchar2(50),
	memtel varchar2(50),
	mememail varchar2(100),
	memauth number
);

DROP TABLE ACI01_Member;

CREATE SEQUENCE ACI01_mem_seq
	INCREMENT BY 1
	START WITH 1001
	MINVALUE 1001
	MAXVALUE 1999;

DROP SEQUENCE ACI01_mem_seq;

-- 12 45 7 작가
-- 3 6 회원
INSERT INTO ACI01_Member values('mb'||ACI01_mem_seq.nextval, 'heyjinss01', 'aa1111', '010-1234-1234', 'heyjinss@gmail.com', 2);
INSERT INTO ACI01_Member values('mb'||ACI01_mem_seq.nextval, 'purple77', 'qw7777', '010-1111-1111', 'purple77@naver.com', 2);
INSERT INTO ACI01_Member values('mb'||ACI01_mem_seq.nextval, 'heygirl02', 'as1234', '010-2222-2222', 'heygirl02@gmail.com', 1);
INSERT INTO ACI01_Member values('mb'||ACI01_mem_seq.nextval, 'coffee33', 'ff8888', '010-3434-4566', 'coffee33@daum.net', 1);
INSERT INTO ACI01_Member values('mb'||ACI01_mem_seq.nextval, 'Aloha08', 'cc8888', '010-6456-5647', 'Aloha08@gmail.com', 2);
INSERT INTO ACI01_Member values('mb'||ACI01_mem_seq.nextval, 'fomsil22', 'we2020', '010-1267-8053', 'fomsil22@gmail.com', 2);
INSERT INTO ACI01_Member values('mb'||ACI01_mem_seq.nextval, 'garden55', 'five55', '010-8653-1221', 'garden55@naver.com', 2);
INSERT INTO ACI01_Member values('mb'||ACI01_mem_seq.nextval, 'test01', 'test11', '010-1001-1001', 'test01@naver.com', 1);


-- 회원 조회 (작가의 경우 권한 2)
SELECT * 
FROM ACI01_Member 
WHERE memno = 'mb1003'
AND memauth = 1;

SELECT * 
FROM ACI01_Member 
WHERE memno = ?
AND memauth = 1;

SELECT * FROM ACI01_Member WHERE memno='mb1003';
SELECT * FROM ACI01_Member ;


-- 로그인 확인 (작가테이블 연결을 위함)
SELECT * 
FROM ACI01_Member 
WHERE memid = 'heygirl02' 
AND mempw = 'as1234';

SELECT * FROM ACI01_Member 
WHERE memid = ?
AND mempw = ?;


-- 2. 작가 Table : 작가번호, 작가명, 작가영어이름, 작가대표이미지, 작가URL, 작가외부이메일, 회원번호
CREATE TABLE ACI01_Artist (
	artno varchar2(50) PRIMARY key,
	artkorname varchar2(50),
	artengname varchar2(50), 
	artimgtitle varchar2(100),
	arturl varchar2(100),
	artoutemail varchar(100),
	memno varchar2(50)
);

DROP TABLE ACI01_Artist;

CREATE SEQUENCE ACI01_art_seq
	INCREMENT BY 1
	START WITH 3001
	MINVALUE 3001
	MAXVALUE 3999;

DROP SEQUENCE ACI01_art_seq;
	
INSERT INTO ACI01_Artist values('at'||ACI01_art_seq.nextval, '허브맛쿠키', 'heyjinss', 
	'img01.png', 'heyjinss', NULL, 'mb1001');
INSERT INTO ACI01_Artist values('at'||ACI01_art_seq.nextval, '퍼플', 'purple', 
	'img02.png', 'purple', NULL, 'mb1002');
INSERT INTO ACI01_Artist values('at'||ACI01_art_seq.nextval, '알로하', 'Aloha', 
	'img03.png', 'Aloha', NULL, 'mb1005');
INSERT INTO ACI01_Artist values('at'||ACI01_art_seq.nextval, '폼실', 'fomsil', 
	'img03.png', 'fomsil', NULL, 'mb1006');
INSERT INTO ACI01_Artist values('at'||ACI01_art_seq.nextval, '정원', 'garden', 
	'img03.png', 'garden', NULL, 'mb1007');

SELECT * FROM ACI01_Artist;

-- 작가정보 조회
SELECT * FROM ACI01_Artist
WHERE artno = 'at3001';

SELECT * FROM ACI01_Artist
WHERE artno = ? ;

-- 작가정보, 상세정보 조회
SELECT * 
FROM ACI01_Artist a
WHERE artno = 'at3001';


-- 작가 회원 등록
INSERT INTO ACI01_Artist values('at'||ACI01_art_seq.nextval, '테스트계정', 'Test01', 
	'img08.png', 'test01', NULL, 'mb1008');

INSERT INTO ACI01_Artist('at'||ACI01_art_seq.nextval, ?, ?, ?, ?, ?, ?);





SELECT memno
FROM ACI01_Member 
WHERE memid = 'heygirl02' 
AND mempw = 'as1234';

SELECT memno
FROM ACI01_Member 
WHERE memid = ? 
AND mempw = ?;



SELECT a.*, b.artno
FROM ACI01_member a, ACI01_Artist B 
WHERE a.memno = b.memno;

