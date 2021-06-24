CREATE TABLE LTM2(
id varchar2(15) PRIMARY KEY,
pass varchar2(15) NOT NULL,
birth DATE,
tel varchar2(20),
email varchar2(25),
loc varchar2(40)
);

INSERT INTO LTM2(id, pass, birth, tel,email, loc) VALUES('asd12','ssss12','19990101','01011112222','as23@naver.com','댕댕시');
INSERT INTO LTM2(id, pass, birth, tel,email, loc) VALUES('ezpz12','lemon12','19901215','01078781212','ez13@naver.com','멍멍시');
INSERT INTO LTM2(id, pass, birth, tel,email, loc) VALUES('yoyo12','vaey12','19980325','01055552323','yo87@naver.com','냥냥시');
INSERT INTO LTM2(id, pass, birth, tel,email, loc) VALUES('12jojo','wlqrk12','19700715','010-7099-2323','yt13@naver.com','댕댕시');
INSERT INTO LTM2(id, pass, birth, tel,email, loc) VALUES('mingo55','5858sws','20100401','010-6677-2323','ru43@naver.com','서울시');
INSERT INTO LTM2(id, pass, birth, tel,email, loc) VALUES('keki48','440toto','19881030','010-9835-3355','mn56@naver.com','대전시');
SELECT id,pass,birth, tel, email,loc
FROM LTM2;

SELECT *  FROM scott.LTM2 WHERE USER_ID='scott';

select * from all_tables where table_name = 'LTM2'