-- 생성
CREATE TABLE IkeaProduct(
	code varchar2(10) PRIMARY key,
	name varchar2(20),
	price NUMBER, 
	infor varchar2(500)
);
CREATE TABLE Review(
	code varchar2(10) PRIMARY key,
	id varchar(20),
	rdate date,
	title varchar2(100), 
	review varchar2(500),
	grade varchar2(100)
);

ALTER TABLE review ADD id varchar(20);
-- 추가
INSERT INTO IkeaProduct values('HY44','HYLLIS 힐리스'
	,20000,'발코니의 화분, 욕실의 샴푸, 주방의 멋진 허브를 놓아두기 좋습니다');
INSERT INTO IkeaProduct values('AP47','APPLE 애플라뢰'
	,20000,'반투명 스테인을 여러 겹 칠해서 내구성을 높이고 나무 고유의 느낌을 살렸습니다.');
INSERT INTO IkeaProduct values('LA82','LAIVA 라이바'
	,20000,'벽 공간을 최대한 활용해보세요. 공간은 적게 차지하고 다양한 물건을 수납할 수 있습니다.');
INSERT INTO IkeaProduct values('AP42','앙에르스뷔'
	,149000,'소파는 공간을 효율적으로 활용할 수 있도록 포장되어 집까지 편하게 운반할 수 있습니다.');
INSERT INTO IkeaProduct values('HI95','HIKKEBY 히케뷔'
	,89000,'이 서랍장은 침실에 있거나 현관에 있는지에 관계없이 기능성과 고유한 스타일을 더할 수 있습니다.');
INSERT INTO IkeaProduct values('HO13','HOL 홀'
	,39000,'테이블 상판 아래를 실용적인 수납공간으로 활용할 수 있습니다.');
-- review
INSERT INTO Review values('HY44',to_date('2021-06-13','YYYY-MM-DD')
	,'가성비입니다','너무 약해요ㅠㅠ 하중은 어느정도 있겠지만 무거운거 올렸다가 흔들거려서 앞뒤로 쓰러질수도 있겠네요..','★★');
INSERT INTO Review values('AP47',to_date('2021-04-29','YYYY-MM-DD')
	,'좋아요','만족합니다!','★★★★★');
INSERT INTO Review values('HY44',to_date('2021-05-05','YYYY-MM-DD')
	,'크기','사이즈가 너무 큽니다','★★★','rle0401');
INSERT INTO Review values('ZK12',to_date('2021-01-11','YYYY-MM-DD')
	,'별로에요','가격만 비싸네요','★','himan');
INSERT INTO Review values('QQ04',to_date('2021-02-20','YYYY-MM-DD')
	,'이쁩니다','추천합니다!','★★★★','moos1');
INSERT INTO Review values('LM82',to_date('2021-05-04','YYYY-MM-DD')
	,'가격 대비','나쁘지않아요 배송이 좀 느립니다','★★★','alis00');
SELECT * FROM IKEAPRODUCT;
-- 정보 검색 (상품코드 : HY44)
SELECT *
FROM IkeaProduct
WHERE code ='HY44';
-- 리뷰 검색 (상품코드 : HY44)
SELECT rdate "구입 날짜", title "제목", review "내용", grade "총점", id "아이디",i.code "코드"
FROM IKEAPRODUCT I, REVIEW R
WHERE I.code = R.code
AND I.code = 'HY44';

SELECT * FROM review;

CREATE TABLE Basket(
	code varchar2(10),
	name varchar2(50),
	price NUMBER, 
	cnt NUMBER DEFAULT 1
);
INSERT INTO Basket values('KP43','KOPPANG 코팡',99000,2);
INSERT INTO Basket values('SM60','STOCKHOLM 스톡홀름',79000,1);
INSERT INTO Basket values('HY44','HYLLIS 힐리스',20000,3);
-- LA82상품
-- 장바구니에 존재하지 않을 경우 상품테이블
-- 값을 가져와서 장바구니에 추가
INSERT ALL
	WHEN code = 'LA82' THEN
	INTO Basket values(code,name,price,1)
SELECT code,name,price
FROM IKEAPRODUCT
WHERE NOT exists(
	SELECT code
	FROM Basket
	WHERE code = 'LA82'
);
-- AP47 상품 수량 2으로 조절
UPDATE Basket
SET 
cnt = 2
WHERE code ='AP47';
-- HY44 상품 장바구니에서 삭제
DELETE FROM Basket A
 WHERE code ='HY44';

SELECT * FROM basket;
SELECT * FROM ikeaproduct
ORDER BY code;
-- HY44 유사 제품 리스트
SELECT *
FROM IKEAPRODUCT
WHERE code != 'HY44'
AND code LIKE 'H%';

SELECT * FROM IKEAPRODUCT ORDER BY code;
-- 상품 정보 (상품 코드:HY44)
SELECT code "상품 코드",name "상품이름",price "가격",infor "상품정보"
FROM IKEAPRODUCT
WHERE code = 'HY44';
-- 리뷰 리스트 (상품 코드:HY44)
SELECT rdate "작성 날짜",title "제목", review "내용", grade "총점"
FROM IKEAPRODUCT i,REVIEW r 
WHERE i.code = r.code
AND i.code = 'HY44';
-- 유사 제품 리스트 (상품 코드:HY44)
SELECT code "상품 코드",name "상품이름",price "가격",infor "상품정보"
FROM IKEAPRODUCT
WHERE code != 'HY44'
AND code LIKE 'H%';


