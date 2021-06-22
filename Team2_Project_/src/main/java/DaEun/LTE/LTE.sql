CREATE TABLE LtEvent(
evname varchar2(100),
evdate DATE,
annodate DATE,
explan varchar2(100)
);

INSERT INTO LTEVENT (evname, evdate, annodate, explan) values('6월 공감 퀴즈 이벤트','2021-06-01','2021-06-16','복권기금 퀴즈 풀고,스마트탭 선물하세요!');
INSERT INTO LTEVENT (evname, evdate, annodate, explan) values('건전복권문화&도박중독예방','2021-05-18','2021-05-31','건전한 복권문화로 행복한 가정의 달!');
INSERT INTO LTEVENT (evname, evdate, annodate, explan) values('5월 공감 퀴즈 이벤트,','2021-05-03','2021-05-17','복권기금 퀴즈 풀고,스마트탭 선물하세요!');
INSERT INTO LTEVENT (evname, evdate, annodate, explan) values('2021 로또 신규판매점 모집,','2021-03-31','2021-04-21','소문내면 선물이 팡팡!');
INSERT INTO LTEVENT (evname, evdate, annodate, explan) values('4월 공감 퀴즈 이벤트,','2021-04-01','2021-04-16','복권기금 퀴즈 풀고,스마트탭 선물하세요!');
INSERT INTO LTEVENT (evname, evdate, annodate, explan) values('건전복권문화&도박중독예방','2021-03-16','2021-03-31','유튜브 도박엔딩 영상 시청하고 퀴즈!');
INSERT INTO LTEVENT (evname, evdate, annodate, explan) values('3월 공감 퀴즈','2021-03-02','2021-03-37','그룹홈 아동후원, 2021 낙첨복귄 희망 캠페인!');
SELECT * FROM LtEvent;

select evname,annodate from LtEvent where annodate 
between to_date('2021-04-01', 'YYYY-MM-DD') and to_date('2021-06-18', 'YYYY-MM-DD');

