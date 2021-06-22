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
SELECT id,pass,birth, tel, email,loc
FROM LTM2;
