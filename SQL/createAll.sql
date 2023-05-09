
-- ȸ������
create table MEMBER(
   MSEQ NUMBER,				--ȸ����ȣ
   EMAIL VARCHAR2(25),			       --�̸���
   NNAME VARCHAR2(25),                         --�г���
   PWD VARCHAR2(12),			       --���
   PHONE VARCHAR2(11),			       --����ó
   RDATE DATE DEFAULT SYSDATE,		       --������
   MILG NUMBER DEFAULT 0		       --���ϸ���
);
create sequence MEMBER_SEQ start with 1 increment by 1 nocache;
alter table MEMBER add constraint MEMBER_PK primary key(EMAIL);
alter table MEMBER add constraint MEMBER_UQ unique(NNAME);


-- �α��ν� ���� ����
create table LoginInfo(
   EMAIL VARCHAR2(25),
   LOGINDATE DATE
);
alter table LoginInfo add constraint LoginInfo_FK foreign key (EMAIL) references MEMBER(EMAIL) on delete cascade;

--����
create table MIMICOMPANY(
   FCODE NUMBER,
   LOC VARCHAR2(10)
);
alter table MIMICOMPANY add constraint MIMICOMPANY_PK primary key(FCODE);

--������ 
create table FRANCHISE(
	FCODE NUMBER,           --������ �ڵ�
	FNAME VARCHAR2(20),	 --������ �̸� 
	OWNER VARCHAR2(10),      --��ǥ�ڸ�
	FPHONE1 VARCHAR2(11),   --����ó1
	FPHONE2 VARCHAR2(11),   --����ó2
	FADDR VARCHAR2(70),     --�ּ� 
	ODATE DATE          --��������
);
alter table FRANCHISE add constraint FRANCHISE_PK primary key(FNAME);
alter table FRANCHISE add constraint FRANCHISE_FK foreign key(FCODE) references MIMICOMPANY on delete cascade;

-- �޴�����
create table MENU(
   MCODE NUMBER,         --�޴��ڵ�
   MNAME VARCHAR2(30),   --�޴���
   MCOST NUMBER          --�޴���� 
);
alter table MENU add constraint MENU primary key(MCODE);

--��Ʈ ���ý�
create table SETMENU (
   SCODE NUMBER(2),
   BEVARAGE VARCHAR2(22),
   COOKIE VARCHAR2(32),
   SCOST NUMBER
);
alter table SETMENU add constraint SETMENU_PK primary key(SCODE);

-- ��������
create table PAYMENT(
   PCODE NUMBER(2) constraint PAYMENT_PK primary key,
   PNAME VARCHAR2(22) constraint PAYMENT_NN not null
);

-- ����
create table PAYLOG(
   PAYSEQ NUMBER constraint ORDER_NN not null, --�ֹ���ȣ(pk)
   FCODE NUMBER,                             --�������ڵ�
   EMAIL VARCHAR2(25),                        -- �̸���(fk)
   MCODE NUMBER(2),                       --�޴��ڵ�(fk)
   BREAD VARCHAR2(30),			      -- ��
   CHEESE VARCHAR2(30),			      -- ġ��
   VEGETABLE VARCHAR2(60),                    -- ä��
   SEASONING VARCHAR2(110),	              -- �����
   SCODE NUMBER(2),                          --��Ʈ�ڵ�(fk)
   QUANTITY NUMBER,			      --����
   AMOUNT NUMBER,                           --����
   PCODE NUMBER(2),                          --�����ڵ�(fk)
   PDATE timestamp                             --������
);
create sequence PAY_SEQ increment by 1 start with 1 nocache;
alter table PAYLOG add constraint PAYLOG_PK primary key(PAYSEQ);
alter table PAYLOG add constraint PAYLOG_FK1 foreign key(FCODE) references MIMICOMPANY on delete cascade;
alter table PAYLOG add constraint PAYLOG_FK2 foreign key(EMAIL) references MEMBER on delete cascade;
alter table PAYLOG add constraint PAYLOG_FK3 foreign key(MCODE) references MENU on delete cascade;
alter table PAYLOG add constraint PAYLOG_FK4 foreign key(SCODE) references SETMENU on delete cascade;
alter table PAYLOG add constraint PAYLOG_FK5 foreign key(PCODE) references PAYMENT on delete cascade;
--�ֹ���ȣ ������
--insert into PAYLOG values(pay_seq.nextval, ?, ?,?,?,?,?,?,?,?,?,?, current_timestamp)
--���ã��
create table CART(
    CARTNO NUMBER,		    -- īƮ��ȣ
    FCODE NUMBER,			    -- �������ڵ�	
    EMAIL VARCHAR2(25),                     -- �̸���(fk)  
    MCODE NUMBER,                       -- �޴��ڵ�(fk)
    BREAD VARCHAR2(30),			    -- ��
    CHEESE VARCHAR2(30),		    -- ġ��
    VEGETABLE VARCHAR2(60),                 -- ä��
    SEASONING VARCHAR2(110),	            -- �����
    SCODE NUMBER,		            -- ��Ʈ�ڵ�(fk)
    QUANTITY NUMBER,		            --����
    AMOUNT NUMBER			    --����
);
alter table CART add constraint CART_PK primary key(CARTNO);
alter table CART add constraint CART_FK1 foreign key(FCODE) references MIMICOMPANY on delete cascade;
alter table CART add constraint CART_FK2 foreign key(EMAIL) references MEMBER on delete cascade;
alter table CART add constraint CART_FK3 foreign key(MCODE) references MENU on delete cascade;
alter table CART add constraint CART_FK4 foreign key(SCODE) references SETMENU on delete cascade;

-- ������ �������ڵ�(�����ڵ�) 
-- Ư���� 11 + ������ 001
-- ������ 21~25 + ������ 001
-- �� 31~39 + ������ 001
-- ����(11001), 
-- ��õ(21001, ����(22001), ����(23001), ���(24001), �λ�(25001)
-- ���(31001), ����(32001), ���(33001), �泲(34001)
-- ���(35001), �泲(36001), ����(37001), ����(38001)
---����(39001)
insert into MIMICOMPANY values(11001, '����');
insert into MIMICOMPANY values(11002, '����');
insert into MIMICOMPANY values(11003, '����');
insert into MIMICOMPANY values(31001, '���');
insert into MIMICOMPANY values(33001, '���');
insert into MIMICOMPANY values(22001, '����');
insert into MIMICOMPANY values(25001, '�λ�');

-- ������ �Է�
insert into FRANCHISE values(11001, '������', '������', '01012341234', '0211112222', '����� ��õ�� ��������з� 121-23', sysdate);
insert into FRANCHISE values(11002, '������', '������', '01012345697', '0211113333', '����� ��õ�� ���α� 12-1', sysdate);
insert into FRANCHISE values(11003, '��õ��û��', '��̰�', '01012345697', '0211114444', '����� ��õ�� ��õ��û ��õ�� 1', sysdate);
insert into FRANCHISE values(31001, '�Ⱦ翪��', '�̿�ȯ', '01012345697', '03111115555','��⵵ �Ⱦ�� ���ȱ� ���ȷ� 111', sysdate);
insert into FRANCHISE values(33001, '�����', '������', '01022223333', '04311116666','��û�ϵ� û�ֽ� ����� 32-1', sysdate);
insert into FRANCHISE values(22001, '��������', '������', '01033334444', '04211117777','���������� ���� ��õ�� 162', sysdate);
insert into FRANCHISE values(25001, '�λ꿪��', '�̺���', '01022223333', '05111118888','�λ걤���� ������ ������ 22', sysdate);

-- �޴�
insert into MENU values(1, '���׸��� ������', 5000);
insert into MENU values(2, '���׸��� ���۷δ�', 5000);
insert into MENU values(3, 'K-�ٺ�ť', 5000);
insert into MENU values(4, 'Ǯ�� ��ũ �ٺ�ť', 5000);
insert into MENU values(5, '��Ż���� ��Ƽ', 5000);
insert into MENU values(6, '������ Ŭ��', 5000);
insert into MENU values(7, '������ũ �� ġ��', 5000);
insert into MENU values(8, 'ġŲ ������ �ƺ�ī��', 5000);
insert into MENU values(9, '��Ƽ���� �ٺ�ť ġŲ', 5000);
insert into MENU values(10, '�ν�Ʈ ġŲ', 5000);

-- ������� �Է�
insert into PAYMENT values(1, '�ſ�/üũī��');
insert into PAYMENT values(2, '�ǽð��������');
insert into PAYMENT values(3, 'īī������');
insert into PAYMENT values(4, '���̹�����');

--��Ʈ �߰� �׸�
insert into SETMENU values(0, '��ǰ', '��ǰ', 0);
insert into SETMENU values(1, '�ݶ�', '����� ġ������', 2000);
insert into SETMENU values(2, '�ݶ�', '���� ����Ĩ', 2000);
insert into SETMENU values(3, '�ݶ�', '����Ĩ', 2000);
insert into SETMENU values(4, '�ݶ�', '��Ʈ�� ������', 2000);
insert into SETMENU values(5, '�ݶ�', 'ȭ��Ʈ ���� ��ī�ٹ̾�', 2000);

select * from MIMICOMPANY;
select * from FRANCHISE;
select * from MENU;
select * from SETMENU;
select * from PAYMENT;
--Ȯ��
select TNAME from TAB;
--select SEQUENCE_NAME from SEQ;
--select CONSTRAINT_NAME, CONSTRAINT_TYPE from user_constraints order by CONSTRAINT_NAME;
