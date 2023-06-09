
-- 회원가입
create table MEMBER(
   MSEQ NUMBER,				--회원번호
   EMAIL VARCHAR2(25),			       --이메일
   NNAME VARCHAR2(25),                         --닉네임
   PWD VARCHAR2(12),			       --비번
   PHONE VARCHAR2(11),			       --연락처
   RDATE DATE DEFAULT SYSDATE,		       --가입일
   MILG NUMBER DEFAULT 0		       --마일리지
);
create sequence MEMBER_SEQ start with 1 increment by 1 nocache;
alter table MEMBER add constraint MEMBER_PK primary key(EMAIL);
alter table MEMBER add constraint MEMBER_UQ unique(NNAME);


-- 로그인시 정보 저장
create table LoginInfo(
   EMAIL VARCHAR2(25),
   LOGINDATE DATE
);
alter table LoginInfo add constraint LoginInfo_FK foreign key (EMAIL) references MEMBER(EMAIL) on delete cascade;

--본사
create table MIMICOMPANY(
   FCODE NUMBER,
   LOC VARCHAR2(10)
);
alter table MIMICOMPANY add constraint MIMICOMPANY_PK primary key(FCODE);

--가맹점 
create table FRANCHISE(
	FCODE NUMBER,           --가맹점 코드
	FNAME VARCHAR2(20),	 --가맹점 이름 
	OWNER VARCHAR2(10),      --대표자명
	FPHONE1 VARCHAR2(11),   --연락처1
	FPHONE2 VARCHAR2(11),   --연락처2
	FADDR VARCHAR2(70),     --주소 
	ODATE DATE          --개업일자
);
alter table FRANCHISE add constraint FRANCHISE_PK primary key(FNAME);
alter table FRANCHISE add constraint FRANCHISE_FK foreign key(FCODE) references MIMICOMPANY on delete cascade;

-- 메뉴선택
create table MENU(
   MCODE NUMBER,         --메뉴코드
   MNAME VARCHAR2(30),   --메뉴명
   MCOST NUMBER          --메뉴비용 
);
alter table MENU add constraint MENU primary key(MCODE);

--세트 선택시
create table SETMENU (
   SCODE NUMBER(2),
   BEVARAGE VARCHAR2(22),
   COOKIE VARCHAR2(32),
   SCOST NUMBER
);
alter table SETMENU add constraint SETMENU_PK primary key(SCODE);

-- 결제수단
create table PAYMENT(
   PCODE NUMBER(2) constraint PAYMENT_PK primary key,
   PNAME VARCHAR2(22) constraint PAYMENT_NN not null
);

-- 결제
create table PAYLOG(
   PAYSEQ NUMBER constraint ORDER_NN not null, --주문번호(pk)
   FCODE NUMBER,                             --가맹점코드
   EMAIL VARCHAR2(25),                        -- 이메일(fk)
   MCODE NUMBER(2),                       --메뉴코드(fk)
   BREAD VARCHAR2(30),			      -- 빵
   CHEESE VARCHAR2(30),			      -- 치즈
   VEGETABLE VARCHAR2(60),                    -- 채소
   SEASONING VARCHAR2(110),	              -- 시즈닝
   SCODE NUMBER(2),                          --세트코드(fk)
   QUANTITY NUMBER,			      --수량
   AMOUNT NUMBER,                           --가격
   PCODE NUMBER(2),                          --결제코드(fk)
   PDATE timestamp                             --결제일
);
create sequence PAY_SEQ increment by 1 start with 1 nocache;
alter table PAYLOG add constraint PAYLOG_PK primary key(PAYSEQ);
alter table PAYLOG add constraint PAYLOG_FK1 foreign key(FCODE) references MIMICOMPANY on delete cascade;
alter table PAYLOG add constraint PAYLOG_FK2 foreign key(EMAIL) references MEMBER on delete cascade;
alter table PAYLOG add constraint PAYLOG_FK3 foreign key(MCODE) references MENU on delete cascade;
alter table PAYLOG add constraint PAYLOG_FK4 foreign key(SCODE) references SETMENU on delete cascade;
alter table PAYLOG add constraint PAYLOG_FK5 foreign key(PCODE) references PAYMENT on delete cascade;
--주문번호 시퀀스
--insert into PAYLOG values(pay_seq.nextval, ?, ?,?,?,?,?,?,?,?,?,?, current_timestamp)
--즐겨찾기
create table CART(
    CARTNO NUMBER,		    -- 카트번호
    FCODE NUMBER,			    -- 가맹점코드	
    EMAIL VARCHAR2(25),                     -- 이메일(fk)  
    MCODE NUMBER,                       -- 메뉴코드(fk)
    BREAD VARCHAR2(30),			    -- 빵
    CHEESE VARCHAR2(30),		    -- 치즈
    VEGETABLE VARCHAR2(60),                 -- 채소
    SEASONING VARCHAR2(110),	            -- 시즈닝
    SCODE NUMBER,		            -- 세트코드(fk)
    QUANTITY NUMBER,		            --수량
    AMOUNT NUMBER			    --가격
);
alter table CART add constraint CART_PK primary key(CARTNO);
alter table CART add constraint CART_FK1 foreign key(FCODE) references MIMICOMPANY on delete cascade;
alter table CART add constraint CART_FK2 foreign key(EMAIL) references MEMBER on delete cascade;
alter table CART add constraint CART_FK3 foreign key(MCODE) references MENU on delete cascade;
alter table CART add constraint CART_FK4 foreign key(SCODE) references SETMENU on delete cascade;

-- 본사의 가맹점코드(지역코드) 
-- 특별시 11 + 가맹점 001
-- 광역시 21~25 + 가맹점 001
-- 도 31~39 + 가맹점 001
-- 서울(11001), 
-- 인천(21001, 대전(22001), 광주(23001), 울산(24001), 부산(25001)
-- 경기(31001), 강원(32001), 충북(33001), 충남(34001)
-- 경북(35001), 경남(36001), 전북(37001), 전남(38001)
---제주(39001)
insert into MIMICOMPANY values(11001, '서울');
insert into MIMICOMPANY values(11002, '서울');
insert into MIMICOMPANY values(11003, '서울');
insert into MIMICOMPANY values(31001, '경기');
insert into MIMICOMPANY values(33001, '충북');
insert into MIMICOMPANY values(22001, '대전');
insert into MIMICOMPANY values(25001, '부산');

-- 가맹점 입력
insert into FRANCHISE values(11001, '가디역점', '이제인', '01012341234', '0211112222', '서울시 금천구 가산디지털로 121-23', sysdate);
insert into FRANCHISE values(11002, '구로점', '김은지', '01012345697', '0211113333', '서울시 금천구 구로구 12-1', sysdate);
insert into FRANCHISE values(11003, '금천구청점', '김미경', '01012345697', '0211114444', '서울시 금천구 금천구청 금천로 1', sysdate);
insert into FRANCHISE values(31001, '안양역점', '이영환', '01012345697', '03111115555','경기도 안양시 만안구 만안로 111', sysdate);
insert into FRANCHISE values(33001, '충북점', '김형수', '01022223333', '04311116666','충청북도 청주시 흥덕구 32-1', sysdate);
insert into FRANCHISE values(22001, '대전역점', '이진형', '01033334444', '04211117777','대전광역시 동구 옥천로 162', sysdate);
insert into FRANCHISE values(25001, '부산역점', '이보미', '01022223333', '05111118888','부산광역시 동래구 동래로 22', sysdate);

-- 메뉴
insert into MENU values(1, '에그마요 베이컨', 5000);
insert into MENU values(2, '에그마요 페퍼로니', 5000);
insert into MENU values(3, 'K-바비큐', 5000);
insert into MENU values(4, '풀드 포크 바비큐', 5000);
insert into MENU values(5, '이탈리안 비엠티', 5000);
insert into MENU values(6, '써브웨이 클럽', 5000);
insert into MENU values(7, '스테이크 앤 치즈', 5000);
insert into MENU values(8, '치킨 베이컨 아보카도', 5000);
insert into MENU values(9, '로티세리 바비큐 치킨', 5000);
insert into MENU values(10, '로스트 치킨', 5000);

-- 결제방법 입력
insert into PAYMENT values(1, '신용/체크카드');
insert into PAYMENT values(2, '실시간계좌출금');
insert into PAYMENT values(3, '카카오페이');
insert into PAYMENT values(4, '네이버페이');

--세트 추가 항목
insert into SETMENU values(0, '단품', '단품', 0);
insert into SETMENU values(1, '콜라', '라즈베리 치즈케익', 2000);
insert into SETMENU values(2, '콜라', '더블 초코칩', 2000);
insert into SETMENU values(3, '콜라', '초코칩', 2000);
insert into SETMENU values(4, '콜라', '오트밀 레이즌', 2000);
insert into SETMENU values(5, '콜라', '화이트 초코 마카다미아', 2000);

select * from MIMICOMPANY;
select * from FRANCHISE;
select * from MENU;
select * from SETMENU;
select * from PAYMENT;
--확인
select TNAME from TAB;
--select SEQUENCE_NAME from SEQ;
--select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints order by CONSTRAINT_NAME;

