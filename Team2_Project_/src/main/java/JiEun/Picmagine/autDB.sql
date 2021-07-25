
/*

회원 - Member
회원번호 memno
ID memid
PW mempw
이메일 mememail
사용권한 memauth

작가 - Writer
작가번호 wrtno
이름 wrtkorname
영문이름 wrtengname
프로필이미지 wrtimgtitle
프로피URL wrturl
외부공개이메일 wrtoutemail
회원번호 memno

작가소개 - WriterIntro
작가번호 wrtno
한줄소개 wrtactivity
활동분야 wrtsmallline
상세소개 wrtbigline
웹사이트 wrtwebsite

팔로우 - Follow
팔로우번호 flwno
작가번호 wrtno
회원번호 memno


작가작품 - Works
작품번호 wrkno
카테고리 wrkcategory
작품이미지 wrkimgtitle
작품제목 wrktitle
작품소개 wrkcontent
업로드시간 wrkdate
저작권권한 wrkpicauth
작가번호 wrtno
시리즈번호 serno


작가시리즈 - Series
시리즈번호 serno
시리즈카테고리 sercategory
시리즈제목 sertitle
시리즈내용 sercontent
 
*/


-- 1. 회원
CREATE TABLE AUT01_Member (
	memno varchar2(50) PRIMARY key,
	memid varchar2(50),
	mempw varchar2(50),
	mememail varchar2(100),
	memauth varchar2(50)
);

CREATE SEQUENCE AUT01_mem_seq
	INCREMENT BY 1
	START WITH 001
	MINVALUE 1
	MAXVALUE 9999;


CREATE SEQUENCE AUT01_wrt_seq
	INCREMENT BY 1
	START WITH 001
	MINVALUE 1
	MAXVALUE 9999;

-- 2. 작가
CREATE TABLE AUT01_Writer (
	wrtno varchar2(50) PRIMARY key,
	wrtkorname varchar2(50),
	wrtengname varchar2(50), 
	wrtimgtitle varchar2(100),
	wrturl varchar2(100),
	wrtoutemail varchar(100),
	memno varchar2(50) 
);

SELECT AUT01_wrt_seq.nextval || 'a' FROM dual;
	
INSERT INTO AUT01_Writer values('w001', '허브맛쿠키', 'heyjinss', 'img01.png', 'heyjinss', NULL, 'm001');
INSERT INTO AUT01_Writer values('w002', '퍼플', 'purple', 'img02.png', 'purple', NULL, 'm002');
INSERT INTO AUT01_Writer values('w003', '알로하', 'Aloha', 'img03.png', 'Aloha', NULL, 'm003');

-- 작가정보 조회
SELECT * FROM AUT01_Writer
WHERE wrtno = 'w001';

SELECT * FROM AUT01_Writer
WHERE wrtno = ? ;

-- 작가정보, 상세정보 조회
SELECT * 
FROM AUT01_Writer a
WHERE wrtno = 'w001';

-- 3. 작가 상세정보
CREATE TABLE AUT01_WriterIntro (
	wrtno varchar2(50) PRIMARY KEY,
	wrtactivity varchar2(50),
	wrtsmallline varchar2(200),
	wrtbigline varchar2(500),
	wrtwebsite varchar2(100)
);

INSERT INTO AUT01_WriterIntro values('w001', '자연', '여행을 좋아합니다. 언제든지 놀러오세요', NULL, null);
INSERT INTO AUT01_WriterIntro values('w002', '배경화면', '많은 관심 부탁드립니다', '안녕하세요:D 퍼플입니다. 많은 관심 부탁드립니다', 'naver.com/purple');
INSERT INTO AUT01_WriterIntro values('w003', '자연', null, NULL, null);
INSERT INTO AUT01_WriterIntro values('w004', '배경화면', '귀여운 토끼 폼실', '따듯한걸 좋아해 불에 가까이 가다 수염이 타버린 토끼 폼실입니다 :)', null);
INSERT INTO AUT01_WriterIntro values('w005', '배경화면', '사진으로 위로가 되었으면 합니다.', NULL, null);


-- 작가 + 작가 상세정보 출력
SELECT a.wrtno 작가번호, a.wrtkorname 작가명, a.wrtengname 작가영어이름, 
	a.wrtimgtitle 대표이미지명, b.wrtactivity 활동분야, b.wrtsmallline 작가소개, b.wrtwebsite 웹사이트
FROM AUT01_Writer a, AUT01_WriterIntro b 
WHERE a.wrtno = b.wrtno 
AND a.wrtno = 'w001';

SELECT a.wrtno, a.wrtkorname, a.wrtengname, 
	a.wrtimgtitle, b.wrtactivity, b.wrtsmallline, b.wrtwebsite
FROM AUT01_Writer a, AUT01_WriterIntro b 
WHERE a.wrtno = b.wrtno 
AND a.wrtno = ?;

-- 4. 팔로우 
CREATE TABLE AUT01_Follow (
	flwno varchar2(50),
	wrtno varchar2(50),
	memno varchar2(50)
);

INSERT INTO AUT01_Follow values('f001', 'w002', 'm001');
INSERT INTO AUT01_Follow values('f002', 'w003', 'm001');
INSERT INTO AUT01_Follow values('f002', 'w001', 'm002');
INSERT INTO AUT01_Follow values('f002', 'w003', 'm002');
INSERT INTO AUT01_Follow values('f002', 'w001', 'm003');

SELECT * FROM AUT01_Follow;

-- 팔로워수 카운트 : 이 작가를 팔로우한 수
SELECT count(*) "팔로워 수"
FROM AUT01_Follow
WHERE memno = 'm001'
AND wrtno = 'w002';

SELECT count(*)
FROM AUT01_Follow
WHERE memno = ?
AND wrtno = ?;

-- 팔로잉수 카운트 : 작가가 다른 작가를 팔로우한 수 
-- 작가의 회원번호를 안다는 가정하에 
SELECT count(*)
FROM AUT01_Follow 
WHERE memno = 'm002';

SELECT count(*)
FROM AUT01_Follow 
WHERE memno = ?;


-- 팔로잉 수 카운트 
-- 작가의 회원번호를 모르는 가정하에 작가번호를 이용해 Writer의 회원번호를 가져옴
SELECT count(*)
FROM AUT01_Follow a
WHERE memno = (SELECT memno
				FROM AUT01_WRITER
				WHERE wrtno = 'w002');
				
			
SELECT memno
FROM AUT01_WRITER
WHERE wrtno = 'w002';

SELECT count(*)
FROM AUT01_Follow
WHERE memno = 'm002';


(String artno, String artcategory, String artimgtitle, String arttitle, String artcontent,
			Date artdate, String artpicauth, String wrtno, String serno) {

-- 작품
CREATE TABLE AUT01_Artworks (
	artno varchar2(50) PRIMARY KEY,
	artcategory varchar2(50),
	artimgtitle varchar2(50),
	arttitle varchar2(100),
	artcontent varchar2(1000),
	artdate date,
	artpicauth varchar2(50),
	serno varchar2(50),
	wrtno varchar2(50)
);

SELECT * FROM AUT01_Artworks;
DROP TABLE AUT01_Artworks;

INSERT INTO AUT01_Artworks values('a001', '사진', 'pic01.png', '제주 여행', '행복했던 제주여행', 
	sysdate, 'Free', '여기가 한국이라고?', 'w001'); 
INSERT INTO AUT01_Artworks values('a002', '사진', 'pic02.png','더운 여름날', '즐거운 친구들', 
	 sysdate, 'Free', null, 'w002');
INSERT INTO AUT01_Artworks values('a003', '배경화면', 'pic03.png', '노을의 반대편', '무엇이 있을까'
, sysdate, 'Free', null, 'w002');

-- 일단 간단하게 작가의 작품들 리스트 확인
SELECT * 
FROM AUT01_Artworks
WHERE wrtno = 'w001';

SELECT * 
FROM AUT01_Artworks
WHERE wrtno = ?;