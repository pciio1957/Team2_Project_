
/*

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

작가소개 - ArtistIntro
작가번호 artno
한줄소개 artactivity
활동분야 artsmallline
상세소개 artbigline
웹사이트 artwebsite

팔로우 - Follow
팔로우번호 flwno
작가번호 artno
회원번호 memno


작가작품 - Works
작품번호 wrkno
카테고리 wrkcategory
작품이미지 wrkimgtitle
작품제목 wrktitle
작품소개 wrkcontent
업로드시간 wrkdate
저작권권한 wrkpicauth
작가번호 artno
시리즈번호 serno


작가시리즈 - Series
시리즈번호 serno
시리즈카테고리 sercategory
시리즈제목 sertitle
시리즈내용 sercontent
 
*/


-- 1. 회원 Table : 회원번호, 회원ID, 회원PW, 회원전화번호, 회원이메일, 회원사용권한
CREATE TABLE AUT01_Member (
	memno varchar2(50) PRIMARY key,
	memid varchar2(50),
	mempw varchar2(50),
	memtel varchar2(50),
	mememail varchar2(100),
	memauth number
);

DROP TABLE AUT01_Member;

CREATE SEQUENCE AUT01_mem_seq
	INCREMENT BY 1
	START WITH 1001
	MINVALUE 1001
	MAXVALUE 1999;

DROP SEQUENCE AUT01_mem_seq;

-- 12 45 7 작가
-- 3 6 회원
INSERT INTO AUT01_Member values('mb'||AUT01_mem_seq.nextval, 'heyjinss01', 'aa1111', '010-1234-1234', 'heyjinss@gmail.com', 2);
INSERT INTO AUT01_Member values('mb'||AUT01_mem_seq.nextval, 'purple77', 'qw7777', '010-1111-1111', 'purple77@naver.com', 2);
INSERT INTO AUT01_Member values('mb'||AUT01_mem_seq.nextval, 'heygirl02', 'as1234', '010-2222-2222', 'heygirl02@gmail.com', 1);
INSERT INTO AUT01_Member values('mb'||AUT01_mem_seq.nextval, 'coffee33', 'ff8888', '010-3434-4566', 'coffee33@daum.net', 1);
INSERT INTO AUT01_Member values('mb'||AUT01_mem_seq.nextval, 'Aloha08', 'cc8888', '010-6456-5647', 'Aloha08@gmail.com', 2);
INSERT INTO AUT01_Member values('mb'||AUT01_mem_seq.nextval, 'fomsil22', 'we2020', '010-1267-8053', 'fomsil22@gmail.com', 2);
INSERT INTO AUT01_Member values('mb'||AUT01_mem_seq.nextval, 'garden55', 'five55', '010-8653-1221', 'garden55@naver.com', 2);


SELECT * FROM AUT01_Member;




-- 2. 작가 Table : 작가번호, 작가명, 작가영어이름, 작가대표이미지, 작가URL, 작가외부이메일, 회원번호
CREATE TABLE AUT01_Artist (
	artno varchar2(50) PRIMARY key,
	artkorname varchar2(50),
	artengname varchar2(50), 
	artimgtitle varchar2(100),
	arturl varchar2(100),
	artoutemail varchar(100),
	memno varchar2(50) CONSTRAINT Member_memno_fk REFERENCES AUT01_Member(memno)
);

DROP TABLE AUT01_Artist;

CREATE SEQUENCE AUT01_art_seq
	INCREMENT BY 1
	START WITH 3001
	MINVALUE 3001
	MAXVALUE 3999;

DROP SEQUENCE AUT01_art_seq;
	
INSERT INTO AUT01_Artist values('at'||AUT01_art_seq.nextval, '허브맛쿠키', 'heyjinss', 
	'img01.png', 'heyjinss', NULL, 'mb1001');
INSERT INTO AUT01_Artist values('at'||AUT01_art_seq.nextval, '퍼플', 'purple', 
	'img02.png', 'purple', NULL, 'mb1002');
INSERT INTO AUT01_Artist values('at'||AUT01_art_seq.nextval, '알로하', 'Aloha', 
	'img03.png', 'Aloha', NULL, 'mb1005');
INSERT INTO AUT01_Artist values('at'||AUT01_art_seq.nextval, '폼실', 'fomsil', 
	'img03.png', 'fomsil', NULL, 'mb1006');
INSERT INTO AUT01_Artist values('at'||AUT01_art_seq.nextval, '정원', 'garden', 
	'img03.png', 'garden', NULL, 'mb1007');

SELECT * FROM AUT01_Artist;

-- 작가정보 조회
SELECT * FROM AUT01_Artist
WHERE artno = 'at3001';

SELECT * FROM AUT01_Artist
WHERE artno = ? ;

-- 작가정보, 상세정보 조회
SELECT * 
FROM AUT01_Artist a
WHERE artno = 'at3001';




-- 3. 작가 상세정보 Table : 작가번호, 작가활동분야, 작가한줄소개, 작가상세소개, 작가웹사이트
CREATE TABLE AUT01_ArtistIntro (
	artno varchar2(50) PRIMARY KEY,
	artactivity varchar2(50),
	artsmallline varchar2(200),
	artbigline varchar2(500),
	artwebsite varchar2(100)
);

DROP TABLE AUT01_ArtistIntro;

INSERT INTO AUT01_ArtistIntro values('at3001', '자연', '여행을 좋아합니다. 언제든지 놀러오세요', NULL, null);
INSERT INTO AUT01_ArtistIntro values('at3002', '배경화면', '많은 관심 부탁드립니다', '안녕하세요:D 퍼플입니다. 많은 관심 부탁드립니다', 'naver.com/purple');
INSERT INTO AUT01_ArtistIntro values('at3005', '자연', null, NULL, null);
INSERT INTO AUT01_ArtistIntro values('at3006', '배경화면', '귀여운 토끼 폼실', '따듯한걸 좋아해 불에 가까이 가다 수염이 타버린 토끼 폼실입니다 :)', null);
INSERT INTO AUT01_ArtistIntro values('at3007', '배경화면', '사진으로 위로가 되었으면 합니다.', NULL, null);


-- 작가 + 작가 상세정보 출력
SELECT a.artno 작가번호, a.artkorname 작가명, a.artengname 작가영어이름, 
	a.artimgtitle 대표이미지명, b.artactivity 활동분야, b.artsmallline 작가소개, b.artwebsite 웹사이트
FROM AUT01_Artist a, AUT01_ArtistIntro b 
WHERE a.artno = b.artno 
AND a.artno = 'at3001';

SELECT a.artno, a.artkorname, a.artengname, 
	a.artimgtitle, b.artactivity, b.artsmallline, b.artwebsite
FROM AUT01_Artist a, AUT01_ArtistIntro b 
WHERE a.artno = b.artno 
AND a.artno = ?;



-- 4. 팔로우 Table : 팔로우번호, 작가번호, 회원번호 
CREATE TABLE AUT01_Follow (
	flwno varchar2(50),
	artno varchar2(50),
	memno varchar2(50)
);

DROP TABLE AUT01_Follow;

CREATE SEQUENCE AUT01_flw_seq 
	INCREMENT BY 1
	START WITH 5001
	MINVALUE 5001
	MAXVALUE 5999;

DROP SEQUENCE AUT01_flw_seq ;

INSERT INTO AUT01_Follow values('fw'||AUT01_flw_seq.nextval, 'at3002', 'mb1001');
INSERT INTO AUT01_Follow values('fw'||AUT01_flw_seq.nextval, 'at3003', 'mb1001');
INSERT INTO AUT01_Follow values('fw'||AUT01_flw_seq.nextval, 'at3001', 'mb1002');
INSERT INTO AUT01_Follow values('fw'||AUT01_flw_seq.nextval, 'at3003', 'mb1002');
INSERT INTO AUT01_Follow values('fw'||AUT01_flw_seq.nextval, 'at3001', 'mb1003');

SELECT * FROM AUT01_Follow;

-- 팔로워수 카운트 : 해당 작가를 팔로워한 수 카운트 
SELECT count(*)
FROM AUT01_Follow 
WHERE artno = 'at3001';

SELECT count(*)
FROM AUT01_Follow 
WHERE artno = ?;


-- 팔로잉 수 카운트 : 해당 작가가 다른 작가를 팔로우한 수 
-- 작가의 회원번호를 모르는 가정하에 작가번호를 이용해 Artist에서의 회원번호를 가져옴
SELECT count(*)
FROM AUT01_Follow a
WHERE memno = (SELECT memno
				FROM AUT01_Artist
				WHERE artno = 'at3001');
	

-- 회원이 해당 작가를 팔로우했는지 여부
SELECT count(*)
FROM AUT01_Follow
WHERE memno = 'mb1001'
AND artno = 'at3002';

SELECT count(*)
FROM AUT01_Follow
WHERE memno = ?
AND artno = ?;

		

-- 5. 작품 Table : 작품번호, 작품카테고리, 작품이미지명, 작품명, 작품내용, 작품게시일, 작품저작권권한, 시리즈번호, 작가번호
CREATE TABLE AUT01_Works (
	wrkno varchar2(50) PRIMARY KEY,
	wrkcategory varchar2(50),
	wrkimgtitle varchar2(50),
	wrktitle varchar2(100),
	wrkcontent varchar2(1000),
	wrkdate date,
	wrkpicauth varchar2(50),
	serno varchar2(50) CONSTRAINT Series_serno_fk REFERENCES AUT01_Series(serno),
	artno varchar2(50) CONSTRAINT Artist_artno_fk REFERENCES AUT01_Artist(artno)
);

DROP TABLE AUT01_Works;

CREATE SEQUENCE AUT01_wrk_seq 
	INCREMENT BY 1
	START WITH 2001
	MINVALUE 2001
	MAXVALUE 2999;

DROP SEQUENCE AUT01_wrk_seq;

SELECT * FROM AUT01_Works;
DROP TABLE AUT01_Works;

INSERT INTO AUT01_Works values('wk'||AUT01_wrk_seq.nextval, '사진', 'pic01.png', '제주 여행', '행복했던 제주여행', 
	sysdate, '기업용상업적사용', 'se6001', 'at3001'); 
INSERT INTO AUT01_Works values('wk'||AUT01_wrk_seq.nextval, '사진', 'pic02.png','더운 여름날', '즐거운 친구들', 
	 sysdate, '상업적사용불가', null, 'at3002');
INSERT INTO AUT01_Works values('wk'||AUT01_wrk_seq.nextval, '배경화면', 'pic03.png', '노을의 반대편', '무엇이 있을까'
, sysdate, '개인용상업적사', null, 'at3002');

-- 일단 간단하게 작가의 작품들 리스트 확인
SELECT * 
FROM AUT01_Works
WHERE artno = 'at3001';

SELECT * 
FROM AUT01_Works
WHERE artno = ?;



-- 6. 시리즈 Table : 시리즈번호, 시리즈카테고리, 시리즈제목, 시리즈내용
CREATE TABLE AUT01_Series (
	serno varchar2(50) PRIMARY KEY,
	sercategory varchar2(50),
	sertitle varchar2(100),
	sercontent varchar2(300)
);

DROP TABLE AUT01_Series;

CREATE SEQUENCE AUT01_ser_seq 
	INCREMENT BY 1
	START WITH 6001
	MINVALUE 6001
	MAXVALUE 6999;

DROP SEQUENCE AUT01_ser_seq;


INSERT INTO AUT01_Series values('se'||AUT01_ser_seq.nextval, '사진', '여기가 한국이라고?', '한국의 멋진 풍경을 담아요~!');

SELECT * FROM AUT01_Series;

-- 시리즈만 조회
SELECT artno, serno 
FROM AUT01_Works
WHERE artno = 'at3001';

SELECT artno, serno 
FROM AUT01_Works
WHERE artno = ?;


-- 작품, 시리즈 정보 같이 조회 
SELECT w.*, s.sercategory, s.sertitle, s.sercontent
FROM AUT01_Works w, AUT01_Series s
WHERE w.artno = 'at3001'
AND w.serno = s.serno;

SELECT w.*, s.sercategory, s.sertitle, s.sercontent
FROM AUT01_Works w, AUT01_Series s
WHERE w.artno = ?
AND w.serno = s.serno;