
DROP TABLE member1; --회원 
CREATE TABLE member1 (
Mnum number(20) PRIMARY KEY,
id varchar2(20),
email varchar2(30),
auth varchar2(50)
);

SELECT * FROM member1;
INSERT INTO member1 VALUES (0000001, 'helloworld1', 'helloworld1@naver.com','완전프리');
INSERT INTO member1 VALUES (0000002, 'helloworld2', 'helloworld2@naver.com','개인용상업적사용');
INSERT INTO member1 VALUES (0000003, 'helloworld3', 'helloworld3@naver.com','기업용상업적사용');
INSERT INTO member1 VALUES (0000004, 'helloworld4', 'helloworld4@naver.com','상업적사용불가');
INSERT INTO member1 VALUES (0000005, 'helloworld5', 'helloworld5@naver.com','완전프리');


--================================================================
Drop TABLE artist; --작가 
CREATE TABLE artist (
anum number(20) NOT NULL PRIMARY key,
aname varchar2(30)  NOT null,
ename varchar2(30) NOT null,
img varchar2(50) NOT null,
url varchar2(50),
publicemail varchar2(100) NOT null,
Mnum number(20) NOT NULL,
CONSTRAINT FK_artist FOREIGN KEY (Mnum) references member1(Mnum)
);

INSERT INTO artist VALUES (0000010,'송민호','sonminho','url','url1','helloworld1@naver.com',0000001);
INSERT INTO artist VALUES (0000011,'피카소','pikaso','url','url2','pikaso1@naver.com',0000002);
INSERT INTO artist VALUES (0000012,'백남준','backnamjun','url','url3','back@naver.com',0000003);
INSERT INTO artist VALUES (0000013,'이중섭','leejungsub','url','url4','jung@naver.com',0000004);
INSERT INTO artist VALUES (0000014,'김봉태','kimbongte','url','url5','bong@naver.com',0000005);

SELECT *FROM artist;


--================================================================

CREATE TABLE follow (
follownum varchar2(10) PRIMARY KEY,
anum number(20),
CONSTRAINT FK_follow_artist FOREIGN KEY (anum) references artist(anum),
Mnum number(20),
CONSTRAINT FK_follow_member1 FOREIGN KEY (Mnum) references member1(Mnum)
);


INSERT INTO follow VALUES ('A00001',0000010,0000001);
INSERT INTO follow VALUES ('A00002',0000011,0000002);
INSERT INTO follow VALUES ('A00003',0000012,0000003);
INSERT INTO follow VALUES ('A00004',0000013,0000004);
INSERT INTO follow VALUES ('A00005',0000014,0000005);

SELECT * FROM follow;
--===============================================================
DROP TABLE art;
DROP TABLE artwork;
CREATE TABLE artwork (
artwork varchar2(10) PRIMARY key, --작품코드
category varchar2(50) REFERENCES category(cStr), --카테고리명
artimg varchar2(30) NOT null, --이미지
title varchar2(30) NOT null, --제목
introduce varchar2(30) NOT null, --소개
date2 varchar2(10) NOT NULL, --등록일
auth varchar2(30) NOT NULL,--권한
anum number(20) references artist(anum), --작가번호
siriesnum varchar(20) references siries(siriesnum),
sale number REFERENCES sale(sNum), --판매여부 
case1 number REFERENCES case1(aNum) --작품/시리즈여부
);

--================================================================================================================
SELECT artimg 이미지, title 제목, b.cStr 카테고리명, introduce 소개, date2 날짜, auth 권한, c.sNum 판매여부, d.aNum 작품시리즈여부
FROM artwork a,category b,sale c,case1 d
WHERE a.category = b.cStr
and a.sale = c.sNum
AND a.case1 = d.aNum
AND d.aNum LIKE '%1%' and b.cStr LIKE '%photo%' and c.sNum LIKE'%1%';


SELECT artimg 이미지, title 제목, b.cStr 카테고리명, introduce 소개, date2 날짜, auth 권한, c.sNum 판매여부, d.aNum 작품시리즈여부
FROM artwork a,category b,sale c,case1 d
WHERE a.category = b.cStr
and a.sale = c.sNum
AND a.case1 = d.aNum;

--================================================================================================================
SELECT * 
FROM artwork;

WHERE 
INSERT INTO artwork VALUES ('AW00001','photo','url','제주여행','제주도여행사진입니다','20210726', '상업적사용', 0000010, 'C00001',1,1 );
INSERT INTO artwork VALUES ('AW00002','calligraphy','url','캘리그라피','내가만든첫번째캘리','20210526', '개인용사용', 0000011, 'C00002',1,1 );
INSERT INTO artwork VALUES ('AW00003','illustlation','url','풍경화','내가만든일러스트에요','20210526', '상업적사용', 0000012, 'C00003',1,1 );
INSERT INTO artwork VALUES ('AW00004','sound','url','강원도여행','걍원도여행후기에요','20210426', '상업적사용', 0000013, 'C00004',1,1 );
INSERT INTO artwork VALUES ('AW00005','illustlation','url','그림일기','첫번째그림일기','20210326', '상업적사용', 0000014, 'C00005',1,1 );

--============================================================================================================================================
SELECT artimg 이미지, title 제목, b.cStr 카테고리명, introduce 소개, date2 날짜, auth 권한, c.sNum 판매여부, d.aNum 작품시리즈여부\r\n"
					+ "FROM artwork a,category b,sale c,case1 d\r\n"
					+ "WHERE a.category = b.cStr\r\n"
					+ "and a.sale = c.sNum\r\n"
					+ "AND a.case1 = d.aNum\r\n"
					+ "AND b.cStr like 1 and c.sNum = 'photo' and d.aNum =1;

SELECT artimg 이미지, title 제목, b.cStr 카테고리명, introduce 소개, date2 날짜, auth 권한, c.sNum 판매여부, d.aNum 작품시리즈여부
FROM artwork a,category b,sale c,case1 d
WHERE a.category = b.cStr
and a.sale = c.sNum
AND a.case1 = d.aNum
AND d.aNum = 1 and b.cStr = "photo" = c.sNum LIKE 1;

--====================================================================================================================
INSERT INTO art VALUES ('A0000001','사진','url','제주여행','휴가후에 간 제주','20200725','완전프리',0000010,'C00001');
INSERT INTO art VALUES ('A0000002','동영상','url','캠핑','휴가후에 간 제주','20200725','완전프리',0000011,'C00002');
INSERT INTO art VALUES ('A0000003','일러스트','url','제주','휴가후에 간 제주','20200725','완전프리',0000012,'C00003');
INSERT INTO art VALUES ('A0000004','녹음','url','자연소리','휴가후에 간 제주','20200725','완전프리',0000013,'C00004');
INSERT INTO art VALUES ('A0000005','사운드','url','빗소리','휴가후에 간 제주','20200725','완전프리',0000014,'C00005');

SELECT * FROM art;
--===============================================================

DROP TABLE siries;
CREATE TABLE siries (
siriesnum varchar(20) PRIMARY KEY,
scategory varchar2(100),
stitle varchar2(50),
scontent varchar2(100)
);


INSERT INTO siries VALUES ('C00001', '사진','여행기록','제주여행이당');
INSERT INTO siries VALUES ('C00002', '동영상','여행기록','홍성여행');
INSERT INTO siries VALUES ('C00003', '일러스트','그림기록','일러스트당');
INSERT INTO siries VALUES ('C00004', '녹음','녹음기록','녹음했당');
INSERT INTO siries VALUES ('C00005', '녹음','녹음기록','녹음했당');


SELECT *FROM siries;



--===============================================================
DROP TABLE comment01;
CREATE TABLE comment01 ( --댓글 
ccommentcode varchar2(100) PRIMARY KEY,
date1 varchar2(20),
content varchar2(100),
cimg varchar2(100),
ccomentcode2 varchar2(100),
anum number(20), --작품번호 
CONSTRAINT FK_comment01_artist FOREIGN KEY (anum) references artist(anum),
art varchar2(10) , --작품번호
CONSTRAINT FK_comment01_art FOREIGN KEY (art) references art(art)
);
DROP SEQUENCE pic_commentcode;
CREATE SEQUENCE pic_commentcode 
	START WITH 4001
	MINVALUE 1000
	MAXVALUE 9999999999;

SELECT  * FROM pic_commentcode;

INSERT INTO comment01 VALUES ('CO'|| pic_commentcode.nextval,'2021.07.25','컨텐츠가너무좋아요','url','CO00001',0000010,'A0000001');
INSERT INTO comment01 VALUES ('CO'|| pic_commentcode.nextval,'2021.07.26','사진이예쁘네요','url','CO00002',0000011,'A0000002');
INSERT INTO comment01 VALUES ('CO'|| pic_commentcode.nextval,'2021.07.27','다운로드했어요','url','CO00003',0000012,'A0000003');
INSERT INTO comment01 VALUES ('CO'|| pic_commentcode.nextval,'2021.07.28','여기어디죠','url','CO00004',0000013,'A0000004');
INSERT INTO comment01 VALUES ('CO'|| pic_commentcode.nextval,'2021.07.29','작가님 후원하고싶어요','url','CO00005',0000014,'A0000005');

SELECT *FROM comment01;


INSERT INTO comment01 VALUES ('CO'|| pic_commentcode.nextval,'?','?','url','CO00001',0000010,'A0000001');

--======================================================================================================================================


--종류 
DROP TABLE CASE1;
CREATE TABLE case1  (
aNum NUMBER CONSTRAINT case1_aStr_pk PRIMARY KEY,
aStr varchar2(50) NOT NULL);


INSERT INTO case1 VALUES (0,'artwork');
INSERT INTO case1 VALUES (1,'series');

SELECT *FROM case1;

--카테고리
DROP TABLE category;
CREATE TABLE category (
cNum NUMBER NOT NULL,
cStr varchar2(50) CONSTRAINT category_cStr_pk PRIMARY KEY);


INSERT INTO category VALUES (0,'photo');
INSERT INTO category VALUES (1,'illustlation');
INSERT INTO category VALUES (3,'sound');
INSERT INTO category VALUES (4,'calligraphy');


SELECT * FROM category;

--등록기간
CREATE TABLE 기간 (

);

--=================================================================================
DROP TABLE sale;
CREATE TABLE sale (
sNum NUMBER CONSTRAINT sale_sNum_pk PRIMARY KEY,
sStr varchar2(50) NOT null);

INSERT INTO sale VALUES (0,'Nonesale');
INSERT INTO sale VALUES (1,'sale');

SELECT * FROM sale;
SELECT artimg 이미지, title 제목, b.cStr 카테고리명, introduce 소개, date2 날짜, auth 권한, c.sNum 판매여부, d.aNum 작품시리즈여부
FROM artwork a,category b,sale c,case1 d
WHERE a.category = b.cStr
and a.sale = c.sNum
AND a.case1 = d.aNum
AND d.aNum =1 and b.cStr ='photo' and c.sNum = 1;



SELECT artimg 이미지, title 제목, b.cStr 카테고리명, introduce 소개, date2 날짜, auth 권한, c.sNum 판매여부, d.aNum 작품시리즈여부
FROM artwork a,category b,sale c,case1 d
WHERE a.category = b.cStr
and a.sale = c.sNum
AND a.case1 = d.aNum
AND b.cStr = 'photo' and c.sNum = 1 and d.aNum =1;

DROP TABLE likeck;
CREATE TABLE LIKeck(
artwork varchar2(10) references artwork(artwork),
likecheckcnt NUMBER
);


INSERT INTO LIKEcase VALUES(1,'사고싶어요');
INSERT INTO LIKEcase VALUES(2,'좋아요');
INSERT INTO LIKEcase VALUES(3,'다른작품원해요');

CREATE TABLE LIKEtab1 (
likenum NUMBER PRIMARY KEY, --좋아요 고유번호 
likecode NUMBER REFERENCES, --좋아요종류 
CONSTRAINT FK_liketab1_likecode FOREIGN KEY (likecode) references LIKEcase(likecode),
Mnum number(20) REFERENCES member1(Mnum),--아이디
CONSTRAINT FK_liketab_Mnum FOREIGN KEY (Mnum) references Member1(Mnum), --아이디
artwork varchar2(10) REFERENCES artwork(artwork), --작품코드
CONSTRAINT FK_artwork_artwork FOREIGN KEY (artwork) references artwork(artwork)
);


--좋아요저장탭
CREATE TABLE LIKEtab (
likenum NUMBER PRIMARY KEY, --좋아요 고유번호 
likecase varchar2(30), --좋아요종류 
Mnum number(20) REFERENCES member1(Mnum),--아이디
CONSTRAINT FK_liketab_Mnum FOREIGN KEY (Mnum) references Member1(Mnum), --아이디
artwork varchar2(10) REFERENCES artwork(artwork), --작품코드
CONSTRAINT FK_artwork_artwork FOREIGN KEY (artwork) references artwork(artwork)
);


INSERT INTO LIKEtab VALUES(80001,'사고싶어요',0000001,'AW00001');
INSERT INTO LIKEtab VALUES(80002,'좋아요',0000001,'AW00001');
INSERT INTO LIKEtab VALUES(80003,'다음작품원해요',0000001,'AW00001');
INSERT INTO LIKEtab VALUES(80003,'다음작품원해요',0000001,'AW00001'); --무결성 제약조건 위배 


INSERT INTO LIKEtab VALUES(80010,'사고싶어요',0000002,'AW00001');
INSERT INTO LIKEtab VALUES(80011,'좋아요',0000002,'AW00001');
INSERT INTO LIKEtab VALUES(80012,'다음작품원해요',0000002,'AW00001');


INSERT INTO LIKEtab VALUES(80013,'사고싶어요',0000005,'AW00001');
INSERT INTO LIKEtab VALUES(80014,'좋아요',0000005,'AW00001');



INSERT INTO LIKEtab VALUES(80004,'사고싶어요', 0000001,'AW00002');
INSERT INTO LIKEtab VALUES(80005,'좋아요', 0000001,'AW00002');
INSERT INTO LIKEtab VALUES(80006,'사고싶어요',0000001,'AW00002');

INSERT INTO LIKEtab VALUES(80007,'사고싶어요',0000002,'AW00003');
INSERT INTO LIKEtab VALUES(80008,'사고싶어요',0000002,'AW00004');

INSERT INTO LIKEtab VALUES(80009,'좋아요',0000003,'AW00005');
INSERT INTO LIKEtab VALUES(80015,'사고싶어요',0000003,'AW00005');



SELECT likenum "좋아요고유번호", likecase "좋아요종류", Mnum "회원번호", artwork "작품번호"
FROM liketab;
SELECT 
(SELECT count(Mnum)
FROM LIKEtab 
WHERE artwork='AW00001' AND likecase ='사고싶어요') AS a,
(SELECT count(Mnum) 
FROM LIKEtab 
WHERE artwork='AW00001' AND likecase ='좋아요') AS b,
(SELECT count(Mnum)
FROM LIKEtab 
WHERE artwork='AW00001' AND likecase ='다음작품원해요')AS c;



SELECT artwork, "사고싶어요"
FROM artwork a, 
(SELECT count(Mnum) "사고싶어요"
FROM LIKEtab 
WHERE artwork='AW00001' AND likecase ='사고싶어요')b
WHERE artwork='AW00001';



DELETE FROM liketab 
WHERE likecase = '사고싶어요'
AND Mnum =0000003
AND artwork ='AW00005';


SELECT artwork, "좋아요"
FROM artwork a, 
(SELECT count(Mnum) "좋아요"
FROM LIKEtab 
WHERE likecase ='좋아요')b
WHERE artwork=AW00005;



SELECT count(Mnum) "좋아요"
FROM LIKEtab 
WHERE likecase ='좋아요';

INSERT INTO LIKEtab VALUES(80015,'사고싶어요',0000003,'AW00005');

INSERT INTO LIKEtab VALUES(80001,?,?,?)

SELECT * 
FROM COMMENT;

--=================================================================================
(SELECT artwork, "사고싶어요"
FROM artwork a, 
(SELECT count(Mnum) "사고싶어요"
FROM LIKEtab 
WHERE artwork='AW00001' AND likecase ='사고싶어요')b
WHERE artwork='AW00001');



(SELECT artwork,"좋아요"
FROM artwork a, 
(SELECT count(Mnum) AS "좋아요"
FROM LIKEtab 
WHERE likecase ='좋아요')b
WHERE artwork='AW00001');




(SELECT artwork, "좋아요"
FROM artwork a, 
(SELECT count(Mnum) "좋아요"
FROM LIKEtab 
WHERE artwork='AW00001' AND likecase ='좋아요')b
WHERE artwork='AW00001');


SELECT count(Mnum) "좋아요"
FROM LIKEtab 
WHERE artwork='AW00001' AND likecase ='좋아요';


(SELECT artwork, "다음작품원해요"
FROM artwork a, 
(SELECT count(Mnum) "다음작품원해요"
FROM LIKEtab 
WHERE artwork='AW00001' AND likecase ='다음작품원해요')b
WHERE artwork='AW00001');
--=================================================================================





