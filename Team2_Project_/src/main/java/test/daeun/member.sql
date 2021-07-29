create table MEMBER01(
   id varchar2(15) PRIMARY KEY,
   pass varchar2(20) NOT NULL,
   phone varchar2(15),
   email varchar2(55),
   memno number
);

DROP TABLE MEMBER01;

INSERT INTO MEMBER01(id,pass,phone,email,memno) 
VALUES ('higirl','1234','01055667788',
'higirl@naver.com',1);
INSERT INTO MEMBER01(id,pass,phone,email,memno) 
VALUES ('himam','3456','01011112222',
'himam@naver.com',2);
INSERT INTO MEMBER01(id,pass,phone,email,memno) 
VALUES ('oldwoman','5678','01077775555',
'oldwoman@naver.com',3);
INSERT INTO MEMBER01(id,pass,phone,email,memno) 
VALUES ('oldman','6789','01077777777',
'oldman@naver.com',4);


SELECT *FROM MEMBER01;

SELECT substr(phone,1,3)||'-'||substr(phone,4,4)||'-'||substr(phone,8)
FROM MEMBER01;

UPDATE member
